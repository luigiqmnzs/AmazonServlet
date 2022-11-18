package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import persistence.ProdutoDAO;

/**
 * Servlet implementation class CadastrarProduto
 */
@WebServlet("/CadastrarProduto")
public class CadastrarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String nome = (String) request.getParameter("nome");
	String tipo = (String) request.getParameter("tipo");
	Double valor = Double.parseDouble(request.getParameter("valor"));
	String imagem = (String) request.getParameter("imagem");
	String vendedor = (String) request.getParameter("vendedor");
	ProdutoDAO dao = new ProdutoDAO();
	List<Produto> produtos = null;
	try {
		produtos = dao.listar();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	int codigo = 0;
	try {
		if(produtos.get(0).getCodigo() == 1){
			codigo = produtos.get(produtos.size()-1).getCodigo() + 1;
		}
	} catch (Exception e) {
		codigo = 1;
	}
	Produto p = null;
	try {
		p = new Produto(codigo, nome, tipo, valor, imagem, vendedor);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	dao.inserir(p);
	RequestDispatcher rd = request.getRequestDispatcher("Adicionado.html");
	rd.forward(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
