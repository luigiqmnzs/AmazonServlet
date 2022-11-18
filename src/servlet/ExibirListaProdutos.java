package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import persistence.ProdutoDAO;

/**
 * Servlet implementation class ExibirListaProdutos
 */
@WebServlet("/ExibirListaProdutos")
public class ExibirListaProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProdutoDAO dao = new ProdutoDAO();	
        List<Produto> produtos = null;
		try {
			produtos = dao.listar();
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>Amazon Pepe</title></head><body>");
		
		out.println("<form action=\"ExibirListaProdutosBuscados\">");
		out.println("<input type=\"text\" name=\"busca\" placeholder=\"Nome ou código para busca\"><input type=\"submit\" value=\"Buscar\">");
		out.println("</form>");
		
		out.println("<table border=\"1px\">");
		out.println("<tr style='background-color: gray'>");
		out.println("<td>Código</td>");
		out.println("<td>Nome</td>");
		out.println("<td>Tipo</td>");
		out.println("<td>Imagem</td>");
		out.println("<td>Vendedor</td>");
		out.println("<td>Data Cadastro</td>");
		out.println("<td></td>");
		out.println("<td></td>");
		out.println("<td></td>");
		out.println("</tr>");
		
		for (Produto p : produtos) {
			out.println("<tr>");
			out.println("<td>"+p.getCodigo()+"</td>");
			out.println("<td>"+p.getNome()+"</td>");
			out.println("<td>"+p.getTipo()+"</td>");
			out.println("<td>"+p.getImagem()+"</td>");
			out.println("<td>"+p.getVendedor()+"</td>");
			out.println("<td>"+s.format(p.getDataCadastro())+"</td>");
			out.println("<form action=\"AdicionarNoCarrinho\"><td><input type=\"submit\" value=\"+ Carrinho\"><input type=\"hidden\" value=\""+p.getCodigo()+"\" name=\"codigo\"></form></td>");
			out.println("<form action=\"AlterarProduto\"><td><input type=\"submit\" value=\"Alterar\"><input type=\"hidden\" value=\""+p.getCodigo()+"\" name=\"codigo\"></form></td>");
			out.println("<form action=\"DeletarProduto\"><td><input type=\"submit\" value=\"Deletar\"><input type=\"hidden\" value=\""+p.getCodigo()+"\" name=\"codigo\"></form></td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("<br><form action=\"Menu.html\"><input type=\"submit\" value=\"Voltar ao Menu\"></form>");
		out.println("<form action=\"ExibirCarrinho\"><div align=\"right\"><input type=\"submit\" value=\"Ir ao carrinho\"></div></form>");
		out.println("</body></html>");
		
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
