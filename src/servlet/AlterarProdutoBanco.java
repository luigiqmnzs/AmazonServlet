package servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import persistence.ProdutoDAO;

/**
 * Servlet implementation class AlterarProdutoBanco
 */
@WebServlet("/AlterarProdutoBanco")
public class AlterarProdutoBanco extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		String nome = request.getParameter("nome");
		String tipo = request.getParameter("tipo");
		Double valor = Double.parseDouble(request.getParameter("valor"));
		String imagem = request.getParameter("imagem");
		String vendedor = request.getParameter("vendedor");
		ProdutoDAO dao = new ProdutoDAO();
		Produto p = null;
		try {
			p = new Produto(codigo, nome, tipo, valor, imagem, vendedor);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.alterar(p);
		RequestDispatcher rd = request.getRequestDispatcher("Alterado.html");
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
