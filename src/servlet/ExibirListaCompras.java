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

import model.Venda;
import persistence.VendaDAO;

/**
 * Servlet implementation class ExibirListaCompras
 */
@WebServlet("/ExibirListaCompras")
public class ExibirListaCompras extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VendaDAO daoV = new VendaDAO();	
        List<Venda> vendas = null;
		try {
			vendas = daoV.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>Amazon Pepe</title></head><body>");
		
		out.println("<table border=\"1px\">");
		out.println("<tr style='background-color: gray'>");
		out.println("<td>Nota Fiscal</td>");
		out.println("<td>Data da Venda</td>");
		out.println("<td>CPF do Cliente</td>");
		out.println("</tr>");
		
		for (Venda v : vendas) {
			out.println("<tr>");
			out.println("<td>"+v.getNotaFiscal()+"</td>");
			out.println("<td>"+s.format(v.getDataVenda())+"</td>");
			out.println("<td>"+v.getClienteCPF()+"</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("<br><form action=\"Menu.html\"><input type=\"submit\" value=\"Voltar ao Menu\"></form>");
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
