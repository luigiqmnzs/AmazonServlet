package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Venda;

public class VendaDAO {
	  public void inserir(Venda v) {
	        Connection con = null;
	        PreparedStatement stmt = null;
	        
	        try {
	            con = Conexao.getConnection();
	            stmt = con.prepareStatement("insert into venda values (?, ?, ?)");
	            stmt.setString(1, v.getNotaFiscal()+"");
	            stmt.setTimestamp(2,new Timestamp(v.getDataVenda().getTime()));
	            stmt.setString(3, v.getClienteCPF());
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                stmt.close();
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	        public void deletar(int notaFiscal) {
	        Connection con = null;
	        PreparedStatement stmt = null;
	        
	        try {
	            con = Conexao.getConnection();
	            stmt = con.prepareStatement("delete from venda where nota_fiscal=?");
	            stmt.setString(1, notaFiscal+"");
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                stmt.close();
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	        public void alterar(Venda v) {
	        Connection con = null;
	        PreparedStatement stmt = null;
	        
	        try {
	            con = Conexao.getConnection();
	            stmt = con.prepareStatement("update venda set nota_fiscal=?, data_venda=?, cliente_cpf=? where nota_fiscal=?");
	            stmt.setString(1, v.getNotaFiscal()+"");
	            stmt.setTimestamp(2,new Timestamp(v.getDataVenda().getTime()));;
	            stmt.setString(3, v.getClienteCPF());
	            stmt.setString(4, v.getNotaFiscal()+"");
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                stmt.close();
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	      public List<Venda> listar() throws SQLException, ParseException{
	        Connection connection = null;
	        PreparedStatement stmt = null;
	        String sql = "select * from venda";
	        try{
	            connection = Conexao.getConnection();
	            stmt = connection.prepareStatement(sql);
	            List<Venda> vendas = new ArrayList<>();
	            ResultSet rs = stmt.executeQuery();
	            while(rs.next()){
	            	String notaFiscal = rs.getString("nota_fiscal");
	                String dataVenda = rs.getString("data_venda");
	                String clienteCPF = rs.getString("cliente_cpf");
	                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	                java.util.Date date = sdf1.parse(dataVenda);
	                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	                Venda add = new Venda(Integer.parseInt(notaFiscal), clienteCPF);
	                add.setDataVenda(sqlDate);
	                vendas.add(add);
	            }
	            rs.close();
	            stmt.close();
	            return vendas;
	        }catch (SQLException e){
	            throw new RuntimeException(e);
	        }
	    }  
	     public Venda buscar(String notaFiscal) throws ParseException {
	        Connection con = null;
	        PreparedStatement stmt = null;
	                
	        try {
	            con = Conexao.getConnection();
	            stmt = con.prepareStatement("select * from venda where nota_fiscal=?");
	            
	            stmt.setString(1, notaFiscal);
	            ResultSet rs = stmt.executeQuery();
	            if(rs.next()) {
	            	String notaFiscalP = rs.getString("nota_fiscal");
	                String dataVenda = rs.getString("data_venda");
	                String clienteCPF = rs.getString("cliente_cpf");
	                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	                java.util.Date date = sdf1.parse(dataVenda);
	                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	                Venda v = new Venda(Integer.parseInt(notaFiscalP), clienteCPF);
	                v.setDataVenda(sqlDate);
	                return v;
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                stmt.close();
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	        return null;
	    }
}
