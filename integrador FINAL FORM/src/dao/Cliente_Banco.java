package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

import model.Cliente;

public class Cliente_Banco implements Iconst{
	
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

		public void inserir(Cliente cliente) throws SQLException, ParseException {
			DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
			Date data;
			data = new java.sql.Date(fmt.parse(cliente.getData()).getTime());
			open();
			sql = "INSERT INTO Cliente (rg,nome,dtregistro,email) VALUES (?,?,?,?)";
			stmt = this.conn.prepareStatement(sql);
			stmt.setString(1,cliente.getRg());
			stmt.setString(2,cliente.getNome());
			stmt.setDate(3,data);
			stmt.setString(4,cliente.getEmail());
			stmt.executeUpdate();
			close();
		}

		public void update(Cliente cliente, int codigo) throws SQLException {
			open();
			sql = "UPDATE Cliente set email = ? where idCliente = ?";
			stmt = this.conn.prepareStatement(sql);
			stmt.setString(1,cliente.getEmail());
			stmt.setInt(2, codigo);
			stmt.executeUpdate();
			close();
		}
		
		public List<Cliente> consulta() throws SQLException {
	         open();
	         sql = "SELECT * FROM Cliente";
	         ArrayList<Cliente> lista = new ArrayList<>();
	         stmt = conn.prepareStatement(sql);
	         result = stmt.executeQuery();
	         while(result.next()) {
	        	Cliente cliente = new Cliente();
	        	cliente.setIdCliente(result.getInt("idCliente"));
	        	cliente.setNome(result.getString("nome"));
	        	cliente.setRg(result.getString("rg"));
	        	cliente.setEmail(result.getString("email"));
	        	cliente.setData(result.getString("dtregistro"));
	            lista.add(cliente);
	         }
	         result.close();
	         stmt.close();
	         return lista;
	    }
		
		public List<Cliente> consultaNome(String nome) throws SQLException {
	         open();
	         sql = "SELECT * FROM Cliente where nome ~* ? ";
	         ArrayList<Cliente> lista = new ArrayList<>();
	         stmt = conn.prepareStatement(sql);
	         stmt.setString(1, nome);
	         result = stmt.executeQuery();
	         while(result.next()) {
	        	Cliente cliente = new Cliente();
	        	cliente.setIdCliente(result.getInt("idCliente"));
	        	cliente.setNome(result.getString("nome"));
	        	cliente.setRg(result.getString("rg"));
	        	cliente.setEmail(result.getString("email"));
	        	cliente.setData(result.getString("dtregistro"));
	            lista.add(cliente);
	         }
	         result.close();
	         stmt.close();
	         return lista;
	    }
		
		public List<Cliente> consultaRg(String rg) throws SQLException {
	         open();
	         sql = "SELECT * FROM Cliente where rg = ? ";
	         ArrayList<Cliente> lista = new ArrayList<>();
	         stmt = conn.prepareStatement(sql);
	         stmt.setString(1, rg);
	         result = stmt.executeQuery();
	         while(result.next()) {
	        	Cliente cliente = new Cliente();
	        	cliente.setIdCliente(result.getInt("idCliente"));
	        	cliente.setNome(result.getString("nome"));
	        	cliente.setRg(result.getString("rg"));
	        	cliente.setEmail(result.getString("email"));
	        	cliente.setData(result.getString("dtregistro"));
	            lista.add(cliente);
	         }
	         result.close();
	         stmt.close();
	         return lista;
	    }
		
		 public void remove(Cliente cliente, String rg) throws SQLException {
		        open();
		        sql = "DELETE FROM cliente WHERE RG = ?";
		        stmt = conn.prepareStatement(sql);
		        stmt.setString(1, rg);
		        stmt.executeUpdate();
		        close();
		 }
	}
