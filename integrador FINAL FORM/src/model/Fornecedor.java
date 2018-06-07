package model;

public class Fornecedor {
	private int fornecedorId;
	private String nome;
	private String cnpj;
	private String estado;
	private String rua;
	private String pais;
	private String cidade;
	private int numero;
	private String bairro;
	private String cep;

	public Fornecedor(String nome, String cnpj, String estado, String rua, String pais, String cidade, int numero, String bairro, String cep) {
		//this.fornecedorId = fornecedorId;
		this.nome = nome;
		this.cnpj = cnpj;
		this.estado = estado;
		this.rua = rua;
		this.pais = pais;
		this.cidade = cidade;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
	}
	
	public Fornecedor(String nome, String estado, String rua, String pais, String cidade, int numero, String bairro, String cep) {
		//this.fornecedorId = fornecedorId;
		this.nome = nome;
		this.estado = estado;
		this.rua = rua;
		this.pais = pais;
		this.cidade = cidade;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
	}
	
	public Fornecedor() {
		
	}	

	public int getFornecedorId() {
		return fornecedorId;
	}

	public void setFornecedorId(int fornecedorId) {
		this.fornecedorId = fornecedorId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj(){
		return cnpj;
	}

	public void setCnpj(String cnpj){
		this.cnpj = cnpj;
	}
	

	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	

	@Override
	public String toString() {
		return "Fornecedor [fornecedorId = " + fornecedorId + ", nome = " + nome + ", CNPJ = " + cnpj + "]";
	}
}
