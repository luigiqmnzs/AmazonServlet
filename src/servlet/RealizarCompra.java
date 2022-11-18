package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;
import persistence.ClienteDAO;

/**
 * Servlet implementation class RealizarCompra
 */
@WebServlet("/RealizarCompra")
public class RealizarCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Carrinho carrinho;
		carrinho = (Carrinho) sessao.getAttribute("carrinho");
		if(carrinho.getItensCarrinho().isEmpty()) {
			 RequestDispatcher rd = request.getRequestDispatcher("CarrinhoVazio.html");
		 	 rd.forward(request, response);
		}else {
		ClienteDAO daoC = new ClienteDAO();
		List<Cliente> clientes = null;
		try {
			clientes = daoC.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Amazon Pepe</title></head><body>");
		out.println("<form action=\"FinalizarCompra\"><table><tr><td>Nome:</td> <td><select name=nome required> ");
		for (Cliente c : clientes) {
			out.print("<option value=\""+c.getCpf()+"\">"+c.getNome()+"</option>");
		}
		out.println("</select></td></tr>");
		out.println("<tr><td>CPF:</td><td><input type=\"text\" name=\"cpf\" required></td></tr></table>");
		out.println("<input type=\"submit\" value=\"Finalizar\"></body></html>");
		out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
