package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ItemVenda;

public class ItemVendaDAO {
	  public void inserir(ItemVenda i) {
	        Connection con = null;
	        PreparedStatement stmt = null;
	        
	        try {
	            con = Conexao.getConnection();
	            stmt = con.prepareStatement("insert into item_venda values (?, ?, ?)");
	            stmt.setString(1, i.getCodigoProduto()+"");
	            stmt.setString(2, i.getNotaFiscalVenda()+"");
	            stmt.setString(3, i.getQuantidade()+"");
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(ItemVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                stmt.close();
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(ItemVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	        public void deletar(int codigoProduto, int notaFiscal) {
	        Connection con = null;
	        PreparedStatement stmt = null;
	        
	        try {
	            con = Conexao.getConnection();
	            stmt = con.prepareStatement("delete from item_venda where produto_codigo=? and venda_nota_fiscal=?");
	            stmt.setString(1, codigoProduto+"");
	            stmt.setString(2, notaFiscal+"");
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(ItemVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                stmt.close();
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(ItemVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	        public void alterar(ItemVenda i) {
	        Connection con = null;
	        PreparedStatement stmt = null;
	        
	        try {
	            con = Conexao.getConnection();
	            stmt = con.prepareStatement("update item_venda set produto_codigo=?, venda_nota_fiscal=?, qtde=? where produto_codigo=? and venda_nota_fiscal=?");
	            stmt.setString(1, i.getCodigoProduto()+"");
	            stmt.setString(2, i.getNotaFiscalVenda()+"");
	            stmt.setString(3, i.getQuantidade()+"");
	            stmt.setString(4, i.getCodigoProduto()+"");
	            stmt.setString(5, i.getNotaFiscalVenda()+"");
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(ItemVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                stmt.close();
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(ItemVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	      public List<ItemVenda> listar() throws SQLException{
	        Connection connection = null;
	        PreparedStatement stmt = null;
	        String sql = "select * from item_venda";
	        try{
	            connection = Conexao.getConnection();
	            stmt = connection.prepareStatement(sql);
	            List<ItemVenda> itens = new ArrayList<>();
	            ResultSet rs = stmt.executeQuery();
	            while(rs.next()){
	            	String iCodigoProduto = rs.getString("produto_codigo");
	                String iNotaFiscal = rs.getString("venda_nota_fiscal");
	                String quantidade = rs.getString("qtde");
	                ItemVenda add = new ItemVenda(Integer.parseInt(iCodigoProduto), Integer.parseInt(iNotaFiscal), Integer.parseInt(quantidade));
	                itens.add(add);
	            }
	            rs.close();
	            stmt.close();
	            return itens;
	        }catch (SQLException e){
	            throw new RuntimeException(e);
	        }
	    }  
	     public ItemVenda buscar(int codigoProduto, int notaFiscal) {
	        Connection con = null;
	        PreparedStatement stmt = null;
	                
	        try {
	            con = Conexao.getConnection();
	            stmt = con.prepareStatement("select * from item_venda where codigo_produto=? and venda_nota_fiscal=?");
	            stmt.setString(1, codigoProduto+"");
	            stmt.setString(2, notaFiscal+"");
	            ResultSet rs = stmt.executeQuery();
	            if(rs.next()) {
	                String iCodigoProduto = rs.getString("produto_codigo");
	                String iNotaFiscal = rs.getString("venda_nota_fiscal");
	                String quantidade = rs.getString("qtde");
	                ItemVenda i = new ItemVenda(Integer.parseInt(iCodigoProduto), Integer.parseInt(iNotaFiscal), Integer.parseInt(quantidade));
	                return i;
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(ItemVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                stmt.close();
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(ItemVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	        return null;
	    }
}
