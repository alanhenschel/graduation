package model;

public class Cliente {
	private int idCliente;
	private String rg;
	private String nome;
	private String data;
	private String email;
	
	public Cliente(String rg, String nome,String email) {
		this.nome = nome;
		this.rg = rg;
		this.email = email;
	}
	
	public Cliente() {
		
	}
	
	public Cliente(String email) {
		this.email = email;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data=data;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
