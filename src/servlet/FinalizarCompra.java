package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ItemVenda;
import model.Produto;
import model.Venda;
import persistence.ItemVendaDAO;
import persistence.VendaDAO;

/**
 * Servlet implementation class FinalizarCompra
 */
@WebServlet("/FinalizarCompra")
public class FinalizarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeCPF = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		HttpSession sessao = request.getSession();
		Carrinho carrinho;
		carrinho = (Carrinho) sessao.getAttribute("carrinho");
		HashMap<Integer, Produto> items = carrinho.itensCarrinho;
		ItemVendaDAO daoI = new ItemVendaDAO();
		VendaDAO daoV = new VendaDAO();
		if(nomeCPF.equalsIgnoreCase(cpf)) {
			int notaFiscal = 0;
			try {
				if(daoV.listar().size() == 0) {
					notaFiscal = 1;
				}else {
					notaFiscal = daoV.listar().get(daoV.listar().size()- 1).getNotaFiscal() + 1;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Venda add = new Venda(notaFiscal, cpf);
			daoV.inserir(add);
			for(Integer key: items.keySet()){
				ItemVenda addI = new ItemVenda(items.get(key).getCodigo(), add.getNotaFiscal(), 1); 
				daoI.inserir(addI);
			 }
			Carrinho carrinhoVazio = new Carrinho();
			sessao.setAttribute("carrinho", carrinhoVazio);
			RequestDispatcher rd = request.getRequestDispatcher("CompraFinalizada.html");
		 	rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("CPFErrado.html");
		 	rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
