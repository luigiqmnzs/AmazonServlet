package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Cliente;

public class ClienteDAO {
	  public void inserir(Cliente c) {
	        Connection con = null;
	        PreparedStatement stmt = null;
	        
	        try {
	            con = Conexao.getConnection();
	            stmt = con.prepareStatement("insert into cliente values (?, ?)");
	            stmt.setString(1,c.getCpf());
	            stmt.setString(2, c.getNome());
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                stmt.close();
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	        public void deletar(String cpf) {
	        Connection con = null;
	        PreparedStatement stmt = null;
	        
	        try {
	            con = Conexao.getConnection();
	            stmt = con.prepareStatement("delete from cliente where cpf=?");
	            stmt.setString(1, cpf);
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                stmt.close();
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	        public void alterar(Cliente c) {
	        Connection con = null;
	        PreparedStatement stmt = null;
	        
	        try {
	            con = Conexao.getConnection();
	            stmt = con.prepareStatement("update cliente set cpf=?, nome=? where cpf=?");
	            stmt.setString(1, c.getCpf());
	            stmt.setString(2,c.getNome());
	            stmt.setString(3, c.getCpf());
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                stmt.close();
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	      public List<Cliente> listar() throws SQLException{
	        Connection connection = null;
	        PreparedStatement stmt = null;
	        String sql = "select * from cliente";
	        try{
	            connection = Conexao.getConnection();
	            stmt = connection.prepareStatement(sql);
	            List<Cliente> clientes = new ArrayList<>();
	            ResultSet rs = stmt.executeQuery();
	            while(rs.next()){
	            	String cpf = rs.getString("cpf");
	                String nome = rs.getString("nome");
	                Cliente add = new Cliente(cpf, nome);
	                clientes.add(add);
	            }
	            rs.close();
	            stmt.close();
	            return clientes;
	        }catch (SQLException e){
	            throw new RuntimeException(e);
	        }
	    }  
	     public Cliente buscar(String cpf) {
	        Connection con = null;
	        PreparedStatement stmt = null;
	                
	        try {
	            con = Conexao.getConnection();
	            stmt = con.prepareStatement("select * from cliente where cpf=?");
	            
	            stmt.setString(1, cpf);
	            ResultSet rs = stmt.executeQuery();
	            if(rs.next()) {
	                String cCPF = rs.getString("cpf");
	                String nome = rs.getString("nome");
	                Cliente c = new Cliente(cCPF, nome);
	                return c;
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                stmt.close();
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	        return null;
	    }
}
