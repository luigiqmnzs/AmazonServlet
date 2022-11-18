package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeletarDoCarrinho
 */
@WebServlet("/DeletarDoCarrinho")
public class DeletarDoCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
	     Carrinho carrinho;
	     int codigo = Integer.parseInt(request.getParameter("codigo"));
	     carrinho = (Carrinho) session.getAttribute("carrinho");
	     carrinho.deletarDoCarrinho(codigo);
	     session.setAttribute("carrinho", carrinho);
	     RequestDispatcher rd = request.getRequestDispatcher("DeletadoDoCarrinho");
	 	 rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
