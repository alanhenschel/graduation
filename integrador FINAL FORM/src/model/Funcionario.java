package model;

public class Funcionario {
	private int funcionarioId;
	private String nomeFunc;
	private String rgFunc;
	private String cpfFunc;
	private double salario;
	private String sexoFunc;
	private String rua;
	private String cidade;
	private int numero;
	private String bairro;
	private String email;
	private String usuario;
	private String senha;
	

	public Funcionario(String nomeFunc, String rgFunc, String cpfFunc, double salario, String sexoFunc, String rua, String cidade, int numero, String bairro,String email, String usuario, String senha) {
		this.nomeFunc = nomeFunc;
		this.rgFunc = rgFunc;
		this.cpfFunc = cpfFunc;
		this.salario = salario;
		this.sexoFunc = sexoFunc;
		this.rua = rua;
		this.cidade = cidade;
		this.numero = numero;
		this.bairro = bairro;
		this.email = email;
		this.usuario = usuario;
		this.senha = senha;
	}

	public Funcionario() {
	}

	public int getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(int funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public String getNome() {
		return nomeFunc;
	}

	public void setNome(String nomeFunc) {
		this.nomeFunc = nomeFunc;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRG(){
		return rgFunc;
	}

	public void setRG(String rgFunc){
		this.rgFunc = rgFunc;
	}

	public String getCPF(){
		return cpfFunc;
	}

	public void setCPF(String cpfFunc){
		this.cpfFunc = cpfFunc;
	}
	
	
	public void setSalario (double salario) {
		this.salario = salario;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSexo(String sexoFunc) {
		this.sexoFunc = sexoFunc;
	}
	
	public String setSexo() {
		return sexoFunc;
	}
	
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
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
	
	
	public String getSexo() {
		return sexoFunc;
	}
	
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Funcionario [funcionarioId = " + funcionarioId + ", nome = " + nomeFunc + ", RG = " + rgFunc + ", CPF = " + cpfFunc + "]";
	}
}
