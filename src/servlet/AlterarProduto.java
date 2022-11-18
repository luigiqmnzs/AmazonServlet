package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import persistence.ProdutoDAO;

/**
 * Servlet implementation class AlterarProduto
 */
@WebServlet("/AlterarProduto")
public class AlterarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		ProdutoDAO dao = new ProdutoDAO(); 
		Produto p = null;
		try {
			p = dao.buscar(codigo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(p.getTipo().equalsIgnoreCase("Livro")) {
			out.println("<head> <meta charset=\"ISO-8859-1\">"
					+ " <title>Amazon Pepe</title> </head>"
					+ "<body><form action=\"AlterarProdutoBanco\"><input type=\"hidden\" name=\"codigo\" value=\""+p.getCodigo()+"\">"
					+ "<table><tr><td>Nome: </td> <td><input type=\"text\" name=\"nome\" value=\""+p.getNome()+"\" required> </td> </tr>"
					+ "<tr><td>Tipo: </td> <td><select name=tipo required> "
					+ "<option value=\"Livro\" selected>Livro</option>"
					+ "<option value=\"Eletronico\">Eletrônico</option>"
					+ "<option value=\"Casa\">Casa</option>"
					+ "<option value=\"Brinquedo\">Brinquedo</option>"
					+ "<option value=\"Esporte\">Esporte</option>"
					+ "<option value=\"Roupa\">Roupa</option>"
					+ "<option value=\"Outro\">Outro</option></select> </td></tr>"
					+ "<tr><td>Valor: </td> <td> <input type=\"text\" name=\"valor\" value=\""+p.getValor()+"\" required> </td></tr>"
					+ "<tr> <td> Imagem: </td> <td> <input type=\"text\" name=\"imagem\" value=\""+p.getImagem()+"\" required> </td></tr>"
					+ "<tr> <td> Vendedor: </td> <td> <input type=\"text\" name=\"vendedor\" value=\""+p.getVendedor()+"\" required> </td></tr>"
					+ "</table><input type=\"submit\" value=\"Alterar\"></form></body></html>");
		}else {
			if(p.getTipo().equalsIgnoreCase("Eletronico")) {
				out.println("<head> <meta charset=\"ISO-8859-1\">"
						+ " <title>Amazon Pepe</title> </head>"
						+ "<body><form action=\"AlterarProdutoBanco\"><input type=\"hidden\" name=\"codigo\" value=\""+p.getCodigo()+"\">"
						+ "<table><tr><td>Nome: </td> <td><input type=\"text\" name=\"nome\" value=\""+p.getNome()+"\" required> </td> </tr>"
						+ "<tr><td>Tipo: </td> <td><select name=tipo required> "
						+ "<option value=\"Livro\">Livro</option>"
						+ "<option value=\"Eletronico\" selected>Eletrônico</option>"
						+ "<option value=\"Casa\">Casa</option>"
						+ "<option value=\"Brinquedo\">Brinquedo</option>"
						+ "<option value=\"Esporte\">Esporte</option>"
						+ "<option value=\"Roupa\">Roupa</option>"
						+ "<option value=\"Outro\">Outro</option></select> </td></tr>"
						+ "<tr><td>Valor: </td> <td> <input type=\"text\" name=\"valor\" value=\""+p.getValor()+"\" required> </td></tr>"
						+ "<tr> <td> Imagem: </td> <td> <input type=\"text\" name=\"imagem\" value=\""+p.getImagem()+"\" required> </td></tr>"
						+ "<tr> <td> Vendedor: </td> <td> <input type=\"text\" name=\"vendedor\" value=\""+p.getVendedor()+"\" required> </td></tr>"
						+ "</table><input type=\"submit\" value=\"Alterar\"></form></body></html>");
			}else {
				if(p.getTipo().equalsIgnoreCase("Casa")) {
					out.println("<head> <meta charset=\"ISO-8859-1\">"
							+ " <title>Amazon Pepe</title> </head>"
							+ "<body><form action=\"AlterarProdutoBanco\"><input type=\"hidden\" name=\"codigo\" value=\""+p.getCodigo()+"\">"
							+ "<table><tr><td>Nome: </td> <td><input type=\"text\" name=\"nome\" value=\""+p.getNome()+"\" required> </td> </tr>"
							+ "<tr><td>Tipo: </td> <td><select name=tipo required> "
							+ "<option value=\"Livro\">Livro</option>"
							+ "<option value=\"Eletronico\">Eletrônico</option>"
							+ "<option value=\"Casa\" selected>Casa</option>"
							+ "<option value=\"Brinquedo\">Brinquedo</option>"
							+ "<option value=\"Esporte\">Esporte</option>"
							+ "<option value=\"Roupa\">Roupa</option>"
							+ "<option value=\"Outro\">Outro</option></select> </td></tr>"
							+ "<tr><td>Valor: </td> <td> <input type=\"text\" name=\"valor\" value=\""+p.getValor()+"\" required> </td></tr>"
							+ "<tr> <td> Imagem: </td> <td> <input type=\"text\" name=\"imagem\" value=\""+p.getImagem()+"\" required> </td></tr>"
							+ "<tr> <td> Vendedor: </td> <td> <input type=\"text\" name=\"vendedor\" value=\""+p.getVendedor()+"\" required> </td></tr>"
							+ "</table><input type=\"submit\" value=\"Alterar\"></form></body></html>");
				}else {
					if(p.getTipo().equalsIgnoreCase("Brinquedo")) {
						out.println("<head> <meta charset=\"ISO-8859-1\">"
								+ " <title>Amazon Pepe</title> </head>"
								+ "<body><form action=\"AlterarProdutoBanco\"><input type=\"hidden\" name=\"codigo\" value=\""+p.getCodigo()+"\">"
								+ "<table><tr><td>Nome: </td> <td><input type=\"text\" name=\"nome\" value=\""+p.getNome()+"\" required> </td> </tr>"
								+ "<tr><td>Tipo: </td> <td><select name=tipo required> "
								+ "<option value=\"Livro\">Livro</option>"
								+ "<option value=\"Eletronico\">Eletrônico</option>"
								+ "<option value=\"Casa\">Casa</option>"
								+ "<option value=\"Brinquedo\" selected>Brinquedo</option>"
								+ "<option value=\"Esporte\">Esporte</option>"
								+ "<option value=\"Roupa\">Roupa</option>"
								+ "<option value=\"Outro\">Outro</option></select> </td></tr>"
								+ "<tr><td>Valor: </td> <td> <input type=\"text\" name=\"valor\" value=\""+p.getValor()+"\" required> </td></tr>"
								+ "<tr> <td> Imagem: </td> <td> <input type=\"text\" name=\"imagem\" value=\""+p.getImagem()+"\" required> </td></tr>"
								+ "<tr> <td> Vendedor: </td> <td> <input type=\"text\" name=\"vendedor\" value=\""+p.getVendedor()+"\" required> </td></tr>"
								+ "</table><input type=\"submit\" value=\"Alterar\"></form></body></html>");
					}else {
						if(p.getTipo().equalsIgnoreCase("Esporte")) {
							out.println("<head> <meta charset=\"ISO-8859-1\">"
									+ " <title>Amazon Pepe</title> </head>"
									+ "<body><form action=\"AlterarProdutoBanco\"><input type=\"hidden\" name=\"codigo\" value=\""+p.getCodigo()+"\">"
									+ "<table><tr><td>Nome: </td> <td><input type=\"text\" name=\"nome\" value=\""+p.getNome()+"\" required> </td> </tr>"
									+ "<tr><td>Tipo: </td> <td><select name=tipo required> "
									+ "<option value=\"Livro\">Livro</option>"
									+ "<option value=\"Eletronico\">Eletrônico</option>"
									+ "<option value=\"Casa\">Casa</option>"
									+ "<option value=\"Brinquedo\">Brinquedo</option>"
									+ "<option value=\"Esporte\" selected>Esporte</option>"
									+ "<option value=\"Roupa\">Roupa</option>"
									+ "<option value=\"Outro\">Outro</option></select> </td></tr>"
									+ "<tr><td>Valor: </td> <td> <input type=\"text\" name=\"valor\" value=\""+p.getValor()+"\" required> </td></tr>"
									+ "<tr> <td> Imagem: </td> <td> <input type=\"text\" name=\"imagem\" value=\""+p.getImagem()+"\" required> </td></tr>"
									+ "<tr> <td> Vendedor: </td> <td> <input type=\"text\" name=\"vendedor\" value=\""+p.getVendedor()+"\" required> </td></tr>"
									+ "</table><input type=\"submit\" value=\"Alterar\"></form></body></html>");
						}else {
							if(p.getTipo().equalsIgnoreCase("Roupa")) {
								out.println("<head> <meta charset=\"ISO-8859-1\">"
										+ " <title>Amazon Pepe</title> </head>"
										+ "<body><form action=\"AlterarProdutoBanco\"><input type=\"hidden\" name=\"codigo\" value=\""+p.getCodigo()+"\">"
										+ "<table><tr><td>Nome: </td> <td><input type=\"text\" name=\"nome\" value=\""+p.getNome()+"\" required> </td> </tr>"
										+ "<tr><td>Tipo: </td> <td><select name=tipo required> "
										+ "<option value=\"Livro\">Livro</option>"
										+ "<option value=\"Eletronico\">Eletrônico</option>"
										+ "<option value=\"Casa\">Casa</option>"
										+ "<option value=\"Brinquedo\">Brinquedo</option>"
										+ "<option value=\"Esporte\">Esporte</option>"
										+ "<option value=\"Roupa\" selected>Roupa</option>"
										+ "<option value=\"Outro\">Outro</option></select> </td></tr>"
										+ "<tr><td>Valor: </td> <td> <input type=\"text\" name=\"valor\" value=\""+p.getValor()+"\" required> </td></tr>"
										+ "<tr> <td> Imagem: </td> <td> <input type=\"text\" name=\"imagem\" value=\""+p.getImagem()+"\" required> </td></tr>"
										+ "<tr> <td> Vendedor: </td> <td> <input type=\"text\" name=\"vendedor\" value=\""+p.getVendedor()+"\" required> </td></tr>"
										+ "</table><input type=\"submit\" value=\"Alterar\"></form></body></html>");
							}else {
								out.println("<head> <meta charset=\"ISO-8859-1\">"
										+ " <title>Amazon Pepe</title> </head>"
										+ "<body><form action=\"AlterarProdutoBanco\"><input type=\"hidden\" name=\"codigo\" value=\""+p.getCodigo()+"\">"
										+ "<table><tr><td>Nome: </td> <td><input type=\"text\" name=\"nome\" value=\""+p.getNome()+"\" required> </td> </tr>"
										+ "<tr><td>Tipo: </td> <td><select name=tipo required> "
										+ "<option value=\"Livro\">Livro</option>"
										+ "<option value=\"Eletronico\">Eletrônico</option>"
										+ "<option value=\"Casa\">Casa</option>"
										+ "<option value=\"Brinquedo\">Brinquedo</option>"
										+ "<option value=\"Esporte\">Esporte</option>"
										+ "<option value=\"Roupa\">Roupa</option>"
										+ "<option value=\"Outro\" selected>Outro</option></select> </td></tr>"
										+ "<tr><td>Valor: </td> <td> <input type=\"text\" name=\"valor\" value=\""+p.getValor()+"\" required> </td></tr>"
										+ "<tr> <td> Imagem: </td> <td> <input type=\"text\" name=\"imagem\" value=\""+p.getImagem()+"\" required> </td></tr>"
										+ "<tr> <td> Vendedor: </td> <td> <input type=\"text\" name=\"vendedor\" value=\""+p.getVendedor()+"\" required> </td></tr>"
										+ "</table><input type=\"submit\" value=\"Alterar\"></form></body></html>");
							}
						}
					}
				}
			}
		}
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
