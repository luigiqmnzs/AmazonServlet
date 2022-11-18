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
import model.Produto;

public class ProdutoDAO {
	  public void inserir(Produto p) {
	        Connection con = null;
	        PreparedStatement stmt = null;
	        
	        try {
	            con = Conexao.getConnection();
	            stmt = con.prepareStatement("insert into produto values (?, ?, ?, ?, ?, ?, ?)");
	            stmt.setString(1,p.getCodigo()+"");
	            stmt.setString(2,p.getNome());
	            stmt.setString(3,p.getTipo());
	            stmt.setString(4,p.getValor()+"");
	            stmt.setString(5,p.getImagem());
	            stmt.setString(6,p.getVendedor());
	            stmt.setTimestamp(7,new Timestamp(p.getDataCadastro().getTime()));
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                stmt.close();
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	        public void deletar(int codigo) {
	        Connection con = null;
	        PreparedStatement stmt = null;
	        
	        try {
	            con = Conexao.getConnection();
	            stmt = con.prepareStatement("delete from produto where codigo=?");
	            stmt.setString(1, codigo+"");
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                stmt.close();
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	        public void alterar(Produto p) {
	        Connection con = null;
	        PreparedStatement stmt = null;
	        
	        try {
	            con = Conexao.getConnection();
	            stmt = con.prepareStatement("update produto set nome=?, tipo=?, valor=?, imagem=?, vendedor=? where codigo=?");
	            stmt.setString(1,p.getNome());
	            stmt.setString(2,p.getTipo());
	            stmt.setString(3,p.getValor()+"");
	            stmt.setString(4,p.getImagem());
	            stmt.setString(5,p.getVendedor());
	            stmt.setString(6,p.getCodigo()+"");
	            stmt.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                stmt.close();
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	      public List<Produto> listar() throws SQLException, ParseException{
	        Connection connection = null;
	        PreparedStatement stmt = null;
	        String sql = "select * from produto";
	        try{
	            connection = Conexao.getConnection();
	            stmt = connection.prepareStatement(sql);
	            List<Produto> produtos = new ArrayList<>();
	            ResultSet rs = stmt.executeQuery();
	            while(rs.next()){
	            	String codigo = rs.getString("codigo");
	                String nome = rs.getString("nome");
	                String tipo = rs.getString("tipo");
	                String valor = rs.getString("valor");
	                String imagem = rs.getString("imagem");
	                String vendedor = rs.getString("vendedor");
	                String data = rs.getString("data_cadastro");
	                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	                java.util.Date date = sdf1.parse(data);
	                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	                Produto add = new Produto(Integer.parseInt(codigo), nome, tipo, Double.parseDouble(valor), imagem, vendedor);
	                add.setDataCadastro(sqlDate);
	                produtos.add(add);
	            }
	            rs.close();
	            stmt.close();
	            return produtos;
	        }catch (SQLException e){
	            throw new RuntimeException(e);
	        }
	    }  
	     public Produto buscar(int codigo) throws ParseException {
	        Connection con = null;
	        PreparedStatement stmt = null;
	                
	        try {
	            con = Conexao.getConnection();
	            stmt = con.prepareStatement("select * from produto where codigo=?");
	            
	            stmt.setString(1, codigo+"");
	            ResultSet rs = stmt.executeQuery();
	            if(rs.next()) {
	            	String codigoP = rs.getString("codigo");
	                String nome = rs.getString("nome");
	                String tipo = rs.getString("tipo");
	                String valor = rs.getString("valor");
	                String imagem = rs.getString("imagem");
	                String vendedor = rs.getString("vendedor");
	                String data = rs.getString("data_cadastro");
	                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	                java.util.Date date = sdf1.parse(data);
	                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	                Produto p = new Produto(Integer.parseInt(codigoP), nome, tipo, Double.parseDouble(valor), imagem, vendedor);
	                p.setDataCadastro(sqlDate);
	                return p;
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                stmt.close();
	                con.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	        return null;
	    }
}
