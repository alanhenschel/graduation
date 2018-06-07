package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import model.ItemVenda;
import model.Venda;

public class Venda_Banco implements Iconst{
	
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
	
	public void inserirItemVenda(ItemVenda itemvenda) throws SQLException{
		open();
		sql = "INSERT INTO ItemVenda (idVenda,quantidade,idProduto) VALUES (?,?,?)";
		stmt = this.conn.prepareStatement(sql);
		stmt.setInt(1,itemvenda.getIdVenda());
		stmt.setInt(2,itemvenda.getQuantidade());
		stmt.setInt(3,itemvenda.getIdProduto());
		stmt.executeUpdate();
		close();
	}
	
	public void inserirVenda(Venda venda) throws SQLException{
		open();
		sql = "INSERT INTO Venda (idVenda, idCliente,idFuncionario) VALUES (?,?,?)";
		stmt = this.conn.prepareStatement(sql);
		stmt.setInt(1, venda.getIdVenda());
		stmt.setInt(2,venda.getIdCliente());
		stmt.setInt(3,venda.getIdFuncionario());
		stmt.executeUpdate();
		close();
	}
	
	public List<ItemVenda> consulta() throws SQLException {
        open();
        sql = "SELECT * FROM Cliente";
        ArrayList<ItemVenda> lista = new ArrayList<>();
        stmt = conn.prepareStatement(sql);
        result = stmt.executeQuery();
        while(result.next()) {
        	ItemVenda itemvenda = new ItemVenda();
        	itemvenda.setIdVenda(result.getInt("idVenda"));
        	itemvenda.setIdProduto(result.getInt("idProduto"));
            lista.add(itemvenda);
        }
        result.close();
        stmt.close();
        return lista;
   }

}
