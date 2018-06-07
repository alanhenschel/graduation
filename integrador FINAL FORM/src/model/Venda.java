package model;

public class Venda {
	private int idVenda;
	private double valor;
	private String data;
	private int idCliente;
	private int idFuncionario;
	
	public Venda(int idVenda, int idFuncionario, int idCliente) {
		this.idVenda = idVenda;
		this.idCliente = idCliente;
		this.idFuncionario = idFuncionario;
	}
	
	public Venda() {
		
	}
	
	public void setIdVenda(int vendaId) {
		this.idVenda = vendaId;
	}
	
	public int getIdVenda() {
		return idVenda;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	public int getIdFuncionario() {
		return idFuncionario;
	}
	
	
}
