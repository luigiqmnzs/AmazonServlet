package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Produto;
import persistence.ProdutoDAO;

/**
 * Servlet implementation class AdicionarNoCarrinho
 */
@WebServlet("/AdicionarNoCarrinho")
public class AdicionarNoCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		Carrinho carrinho;
		carrinho = (Carrinho) sessao.getAttribute("carrinho");
		if(carrinho == null) {
			carrinho = new Carrinho();
			sessao.setAttribute("carrinho", carrinho);
		}
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		ProdutoDAO dao = new ProdutoDAO();
		Produto add = null;
		try {
			add = dao.buscar(codigo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		carrinho.colocarNoCarrinho(codigo, add);
		sessao.setAttribute("carrinho", carrinho);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Amazon Pepe</title></head><body>");
		out.println("<h1>Produto adicionado com sucesso!</h1>");
		out.println("<form action=\"ExibirListaProdutos\"><input type=\"submit\" value=\"Voltar a lista de produtos\"></form>");
		 out.println("<hr>");
         out.println("<h2>Carrinho</h2>");
         HashMap<Integer, Produto> items = carrinho.itensCarrinho;
         out.println("<table border=\"1px\">");
         for(Integer key: items.keySet()){
             out.println("<tr><td>"+items.get(key).getNome()+"</td><td>R$"+items.get(key).getValor()+"</td><form action=\"DeletarDoCarrinho\"><input type=\"hidden\" name=\"codigo\" value=\""+key+"\"><td><input type=\"submit\" value=\"Deletar\"></td></tr>");
         }
         out.println("<table>");
         out.println("</body>");
         out.println("</html>");
         out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
