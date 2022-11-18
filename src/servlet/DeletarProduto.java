package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeletarProduto
 */
@WebServlet("/DeletarProduto")
public class DeletarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		out.println("<html><head><title>Amazon Pepe</title></head><body>");
		out.println("Você realmente deseja deletar esse produto?<br>");
		out.println("<form action=DeletarProdutoBanco><input type=\"submit\" value=\"Sim\"><input type=\"hidden\" name=\"codigo\" value=\""+codigo+"\"></form>");
		out.println("<form action=ExibirListaProdutos><input type=\"submit\" value=\"Não\"></form>");
		out.println("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
