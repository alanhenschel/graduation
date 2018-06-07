package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import dao.Produto_Banco;

public class Produto_Banco implements Iconst{
	
		private String sql;
		private Connection conn;
		private PreparedStatement stmt;
		private ResultSet result;

		private void open() throws SQLException {
			conn = conect.getConect(conect.stringConect, conect.usuario, conect.senha);
		}

		private void close() throws SQLException {
			conn.close();
		}

		public void inserir(Produto produto) throws SQLException {
			open();
			sql = "INSERT INTO Produto (titulo,categoria,estoque,valor,tipo,estudio,idFornecedor) VALUES (?,?,?,?,?,?,?)";
			stmt = this.conn.prepareStatement(sql);
			stmt.setString(1,produto.getNome());
			stmt.setString(2,produto.getCategoria());
			stmt.setDouble(3,produto.getValor());
			stmt.setDouble(4,produto.getValor());
			stmt.setString(5,produto.getTipo());
			stmt.setString(6,produto.getEstudio());
			stmt.setInt(7,produto.getIdFornecedor());
			stmt.executeUpdate();
			close();
		}

		public void update(Produto produto, int id) throws SQLException {
			open();
			sql = "UPDATE Produto SET valor = ?, estoque = ? where idProduto = ?";
			stmt = this.conn.prepareStatement(sql);
			stmt.setDouble(1, produto.getValor());
			stmt.setInt(2, produto.getEstoque());
			stmt.setInt(3, id);
			stmt.executeUpdate();
			close();
		}
		
		public List<Produto> consulta() throws SQLException {
	         open();
	         sql = "SELECT * FROM Produto";
	         ArrayList<Produto> lista = new ArrayList<>();
	         stmt = conn.prepareStatement(sql);
	         result = stmt.executeQuery();
	         while(result.next()) {
	        	Produto produto = new Produto();
	        	produto.setIdProduto(result.getInt("idproduto"));
	        	produto.setNome(result.getString("titulo"));
	        	produto.setValor(result.getDouble("valor"));
	        	produto.setTipo(result.getString("tipo"));
	        	produto.setEstoque(result.getInt("estoque"));
	        	produto.setCategoria(result.getString("categoria"));
	        	produto.setEstudio(result.getString("estudio"));
	        	produto.setIdFornecedor(result.getInt("idfornecedor"));
	            lista.add(produto);
	         }
	         result.close();
	         stmt.close();
	         return lista;
	    }
		
		public List<Produto> consultaNome(String nome) throws SQLException {
	         open();
	         sql = "SELECT * FROM Produto where titulo ~* ?";
	         ArrayList<Produto> lista = new ArrayList<>();
	         stmt = conn.prepareStatement(sql);
	         stmt.setString(1, nome);
	         result = stmt.executeQuery();
	         while(result.next()) {
	        	Produto produto = new Produto();
	        	produto.setIdProduto(result.getInt("idproduto"));
	        	produto.setNome(result.getString("titulo"));
	        	produto.setValor(result.getDouble("valor"));
	        	produto.setTipo(result.getString("tipo"));
	        	produto.setEstoque(result.getInt("estoque"));
	        	produto.setCategoria(result.getString("categoria"));
	        	produto.setEstudio(result.getString("estudio"));
	        	produto.setIdFornecedor(result.getInt("idfornecedor"));
	            lista.add(produto);
	         }
	         result.close();
	         stmt.close();
	         return lista;
	    }
		
		public List<Produto> consultaTipo(String tipo) throws SQLException {
	         open();
	         sql = "SELECT * FROM Produto where tipo ~* ?";
	         ArrayList<Produto> lista = new ArrayList<>();
	         stmt = conn.prepareStatement(sql);
	         stmt.setString(1, tipo);
	         result = stmt.executeQuery();
	         while(result.next()) {
	        	Produto produto = new Produto();
	        	produto.setIdProduto(result.getInt("idproduto"));
	        	produto.setNome(result.getString("titulo"));
	        	produto.setValor(result.getDouble("valor"));
	        	produto.setTipo(result.getString("tipo"));
	        	produto.setEstoque(result.getInt("estoque"));
	        	produto.setCategoria(result.getString("categoria"));
	        	produto.setEstudio(result.getString("estudio"));
	        	produto.setIdFornecedor(result.getInt("idfornecedor"));
	            lista.add(produto);
	         }
	         result.close();
	         stmt.close();
	         return lista;
	    }
		
		public List<Produto> consultaCategoria(String categoria) throws SQLException {
	         open();
	         sql = "SELECT * FROM Produto where categoria ~* ?";
	         ArrayList<Produto> lista = new ArrayList<>();
	         stmt = conn.prepareStatement(sql);
	         stmt.setString(1, categoria);
	         result = stmt.executeQuery();
	         while(result.next()) {
	        	Produto produto = new Produto();
	        	produto.setIdProduto(result.getInt("idproduto"));
	        	produto.setNome(result.getString("titulo"));
	        	produto.setValor(result.getDouble("valor"));
	        	produto.setTipo(result.getString("tipo"));
	        	produto.setEstoque(result.getInt("estoque"));
	        	produto.setCategoria(result.getString("categoria"));
	        	produto.setEstudio(result.getString("estudio"));
	        	produto.setIdFornecedor(result.getInt("idfornecedor"));
	            lista.add(produto);
	         }
	         result.close();
	         stmt.close();
	         return lista;
	    }
		
		public double somaValor(int idProduto) throws SQLException {
	         open();
	         double valor=0;
	         sql = "SELECT valor FROM Produto where idProduto=?";
	         stmt = conn.prepareStatement(sql);
	         stmt.setInt(1, idProduto);
	         result = stmt.executeQuery();
	         while(result.next()) {
	        	Produto produto = new Produto();
	         	produto.setValor(result.getDouble("valor"));
	         	valor = produto.getValor();
	         }
	         result.close();
	         stmt.close();
	         System.out.println(""+valor);
	         return valor;
	    }
		
		public void remove(Produto produto, String titulo) throws SQLException {
	        open();
	        sql = "DELETE FROM produto WHERE titulo = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, titulo);
	        stmt.executeUpdate();
	        close();
	    }
	}
