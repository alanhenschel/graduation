package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Fornecedor;
import java.util.List;
import java.util.ArrayList;

public class Fornecedor_Banco implements Iconst{
	
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

		public void inserir(Fornecedor fornecedor) throws SQLException {
			open();
			sql = "INSERT INTO Fornecedor (nome, cnpj, estado, rua, pais, cidade, numero, bairro, cep) VALUES (?,?,?,?,?,?,?,?,?)";
			stmt = this.conn.prepareStatement(sql);
			stmt.setString(1,fornecedor.getNome());
			stmt.setString(2,fornecedor.getCnpj());
			stmt.setString(3,fornecedor.getEstado());
			stmt.setString(4,fornecedor.getRua());
			stmt.setString(5,fornecedor.getPais());
			stmt.setString(6,fornecedor.getCidade());
			stmt.setInt(7,fornecedor.getNumero());
			stmt.setString(8,fornecedor.getBairro());
			stmt.setString(9,fornecedor.getCep());
			stmt.executeUpdate();
			close();
		}

		public void update(Fornecedor fornecedor, int codigo) throws SQLException {
			open();
			sql = "UPDATE Fornecedor set nome = ?, estado = ?, rua = ?, pais = ?, cidade = ?, numero = ?, bairro = ?, cep = ? where idFornecedor = ?";
			stmt = this.conn.prepareStatement(sql);
			stmt.setString(1,fornecedor.getNome());
			stmt.setString(2,fornecedor.getEstado());
			stmt.setString(3,fornecedor.getRua());
			stmt.setString(4,fornecedor.getPais());
			stmt.setString(5,fornecedor.getCidade());
			stmt.setInt(6,fornecedor.getNumero());
			stmt.setString(7,fornecedor.getBairro());
			stmt.setString(8,fornecedor.getCep());
			stmt.setInt(9, codigo);
			stmt.executeUpdate();
			close();
		}
		
		public List<Fornecedor> consulta() throws SQLException {
	         open();
	         sql = "SELECT * FROM Fornecedor";
	         ArrayList<Fornecedor> lista = new ArrayList<>();
	         stmt = conn.prepareStatement(sql);
	         result = stmt.executeQuery();
	         while(result.next()) {
	        	Fornecedor fornecedor = new Fornecedor();
	        	fornecedor.setFornecedorId(result.getInt("idFornecedor"));
	        	fornecedor.setCnpj(result.getString("cnpj"));
	        	fornecedor.setNome(result.getString("nome"));
	        	fornecedor.setRua(result.getString("rua"));
	        	fornecedor.setEstado(result.getString("estado"));
	        	fornecedor.setPais(result.getString("pais"));
	        	fornecedor.setCep(result.getString("cep"));
	        	fornecedor.setNumero(result.getInt("numero"));
	        	fornecedor.setCidade(result.getString("cidade"));
	        	fornecedor.setBairro(result.getString("bairro"));
	            lista.add(fornecedor);
	         }
	         result.close();
	         stmt.close();
	         return lista;
	    }
		
		public List<Fornecedor> consultaCNPJ(String Cnpj) throws SQLException {
	         open();
	         sql = "SELECT * FROM Fornecedor where cnpj=?";
	         ArrayList<Fornecedor> lista = new ArrayList<>();
	         stmt = conn.prepareStatement(sql);
	         stmt.setString(1, Cnpj);
	         result = stmt.executeQuery();
	         while(result.next()) {
	        	Fornecedor fornecedor = new Fornecedor();
	        	fornecedor.setFornecedorId(result.getInt("idFornecedor"));
	        	fornecedor.setCnpj(result.getString("cnpj"));
	        	fornecedor.setNome(result.getString("nome"));
	        	fornecedor.setRua(result.getString("rua"));
	        	fornecedor.setEstado(result.getString("estado"));
	        	fornecedor.setPais(result.getString("pais"));
	        	fornecedor.setCep(result.getString("cep"));
	        	fornecedor.setNumero(result.getInt("numero"));
	        	fornecedor.setCidade(result.getString("cidade"));
	        	fornecedor.setBairro(result.getString("bairro"));
	            lista.add(fornecedor);
	         }
	         result.close();
	         stmt.close();
	         return lista;
	    }
		
		public List<Fornecedor> consultaNome(String nome) throws SQLException {
	         open();
	         sql = "SELECT * FROM Fornecedor where nome~*?";
	         ArrayList<Fornecedor> lista = new ArrayList<>();
	         stmt = conn.prepareStatement(sql);
	         stmt.setString(1, nome);
	         result = stmt.executeQuery();
	         while(result.next()) {
	        	Fornecedor fornecedor = new Fornecedor();
	        	fornecedor.setFornecedorId(result.getInt("idFornecedor"));
	        	fornecedor.setCnpj(result.getString("cnpj"));
	        	fornecedor.setNome(result.getString("nome"));
	        	fornecedor.setRua(result.getString("rua"));
	        	fornecedor.setEstado(result.getString("estado"));
	        	fornecedor.setPais(result.getString("pais"));
	        	fornecedor.setCep(result.getString("cep"));
	        	fornecedor.setNumero(result.getInt("numero"));
	        	fornecedor.setCidade(result.getString("cidade"));
	        	fornecedor.setBairro(result.getString("bairro"));
	            lista.add(fornecedor);
	         }
	         result.close();
	         stmt.close();
	         return lista;
	    }
		
		public void remove(Fornecedor fornecedor, String cnpj) throws SQLException {
	        open();
	        sql = "DELETE FROM fornecedor WHERE cnpj = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, cnpj);
	        stmt.executeUpdate();
	        close();
	    }
	}
