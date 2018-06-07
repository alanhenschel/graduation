package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;

public class Funcionario_Banco implements Iconst{
	
		private String sql;
		private Connection conn;
		private PreparedStatement stmt;

		private void open() throws SQLException {
			conn = conect.getConect(conect.stringConect, conect.usuario, conect.senha);
		}

		private void close() throws SQLException {
			conn.close();
		}

		public void inserir(Funcionario funcionario) throws SQLException, ParseException {
			open();
			sql = "INSERT INTO Funcionario (nome, RG, CPF, salario, sexo, rua, cidade, numero, bairro,email,usuario,senha) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			stmt = this.conn.prepareStatement(sql);
			stmt.setString(1,funcionario.getNome());
			stmt.setString(2,funcionario.getRG());
			stmt.setString(3,funcionario.getCPF());
			stmt.setDouble(4,funcionario.getSalario());
			stmt.setString(5,funcionario.getSexo());
			stmt.setString(6,funcionario.getRua());
			stmt.setString(7,funcionario.getCidade());
			stmt.setInt(8,funcionario.getNumero());
			stmt.setString(9,funcionario.getBairro());
			stmt.setString(10,funcionario.getEmail());
			stmt.setString(11,funcionario.getUsuario());
			stmt.setString(12,funcionario.getSenha());
			stmt.executeUpdate();
			close();
		}

		public void update(Funcionario funcionario, String rua, double salario, String cidade, String bairro, int numero, int codigo) throws SQLException{
			open();
			sql = "UPDATE Funcionario SET salario = ?, rua = ?, cidade = ?, numero = ?, bairro = ? where idfuncionario = ?";
			stmt = this.conn.prepareStatement(sql);
			stmt.setDouble(1, salario);
			stmt.setString(2, rua);
			stmt.setString(3, cidade);
			stmt.setInt(4, numero);
			stmt.setString(5, bairro);
			stmt.setInt(6, codigo);
			stmt.executeUpdate();
			close();
		}
		
		public List<Funcionario> consulta() throws SQLException {
	         open();
	         sql = "SELECT * FROM Funcionario";
	         ArrayList<Funcionario> funcionarios = new ArrayList<>();
	         stmt = conn.prepareStatement(sql);
	         ResultSet result = stmt.executeQuery();
	         while(result.next()) {
	            Funcionario funcionario = new Funcionario();
	            funcionario.setFuncionarioId(result.getInt("idFuncionario"));
	            funcionario.setNome(result.getString("nome"));
	            funcionario.setRG(result.getString("RG"));
	            funcionario.setCPF(result.getString("cpf"));
	            funcionario.setEmail(result.getString("email"));
	            funcionario.setSexo(result.getString("sexo"));
	            funcionario.setRua(result.getString("rua"));
	            funcionario.setCidade(result.getString("cidade"));
	            funcionario.setBairro(result.getString("bairro"));
	            funcionario.setSalario(result.getDouble("salario"));
	            funcionario.setNumero(result.getInt("numero"));
	            funcionario.setUsuario(result.getString("usuario"));
	            funcionario.setSenha(result.getString("senha"));
	            funcionarios.add(funcionario);
	         }
	         close();
	         return funcionarios;
	    }
		
		public List<Funcionario> consultaRg(String rg) throws SQLException {
	         open();
	         sql = "SELECT * FROM Funcionario where rg=?";
	         ArrayList<Funcionario> funcionarios = new ArrayList<>();
	         stmt = conn.prepareStatement(sql);
	         stmt.setString(1, rg);
	         ResultSet result = stmt.executeQuery();
	         while(result.next()) {
	            Funcionario funcionario = new Funcionario();
	            funcionario.setFuncionarioId(result.getInt("idFuncionario"));
	            funcionario.setNome(result.getString("nome"));
	            funcionario.setRG(result.getString("RG"));
	            funcionario.setCPF(result.getString("cpf"));
	            funcionario.setEmail(result.getString("email"));
	            funcionario.setSexo(result.getString("sexo"));
	            funcionario.setRua(result.getString("rua"));
	            funcionario.setCidade(result.getString("cidade"));
	            funcionario.setBairro(result.getString("bairro"));
	            funcionario.setSalario(result.getDouble("salario"));
	            funcionario.setNumero(result.getInt("numero"));
	            funcionario.setUsuario(result.getString("usuario"));
	            funcionario.setSenha(result.getString("senha"));
	            funcionarios.add(funcionario);
	         }
	         close();
	         return funcionarios;
	    }
		
		public List<Funcionario> consultaCpf(String cpf) throws SQLException {
	         open();
	         sql = "SELECT * FROM Funcionario where cpf=?";
	         ArrayList<Funcionario> funcionarios = new ArrayList<>();
	         stmt = conn.prepareStatement(sql);
	         stmt.setString(1, cpf);
	         ResultSet result = stmt.executeQuery();
	         while(result.next()) {
	            Funcionario funcionario = new Funcionario();
	            funcionario.setFuncionarioId(result.getInt("idFuncionario"));
	            funcionario.setNome(result.getString("nome"));
	            funcionario.setRG(result.getString("RG"));
	            funcionario.setCPF(result.getString("cpf"));
	            funcionario.setEmail(result.getString("email"));
	            funcionario.setSexo(result.getString("sexo"));
	            funcionario.setRua(result.getString("rua"));
	            funcionario.setCidade(result.getString("cidade"));
	            funcionario.setBairro(result.getString("bairro"));
	            funcionario.setSalario(result.getDouble("salario"));
	            funcionario.setNumero(result.getInt("numero"));
	            funcionario.setUsuario(result.getString("usuario"));
	            funcionario.setSenha(result.getString("senha"));
	            funcionarios.add(funcionario);
	         }
	         close();
	         return funcionarios;
	    }
		
		public List<Funcionario> consultaNome(String nome) throws SQLException {
	         open();
	         sql = "SELECT * FROM Funcionario where nome~*?";
	         ArrayList<Funcionario> funcionarios = new ArrayList<>();
	         stmt = conn.prepareStatement(sql);
	         stmt.setString(1, nome);
	         ResultSet result = stmt.executeQuery();
	         while(result.next()) {
	            Funcionario funcionario = new Funcionario();
	            funcionario.setFuncionarioId(result.getInt("idFuncionario"));
	            funcionario.setNome(result.getString("nome"));
	            funcionario.setRG(result.getString("RG"));
	            funcionario.setCPF(result.getString("cpf"));
	            funcionario.setEmail(result.getString("email"));
	            funcionario.setSexo(result.getString("sexo"));
	            funcionario.setRua(result.getString("rua"));
	            funcionario.setCidade(result.getString("cidade"));
	            funcionario.setBairro(result.getString("bairro"));
	            funcionario.setSalario(result.getDouble("salario"));
	            funcionario.setNumero(result.getInt("numero"));
	            funcionario.setUsuario(result.getString("usuario"));
	            funcionario.setSenha(result.getString("senha"));
	            funcionarios.add(funcionario);
	         }
	         close();
	         return funcionarios;
	    }
		
		public void removeRG(Funcionario funcionario, String rg) throws SQLException {
	        open();
	        sql = "DELETE FROM funcionario WHERE RG = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, rg);
	        stmt.executeUpdate();
	        close();
	    }
		
		
	}
