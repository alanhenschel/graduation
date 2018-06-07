package model;

public class Produto {
	
	private String nome;
	private int idProduto;
	private double valor;
	private String tipo;
	private String estudio;
	private int idFornecedor;
	private String categoria;
	private int estoque;
	
	public Produto(String nome,double valor,String tipo,String estudio,int idFornecedor,String categoria, int estoque) {
		this.nome=nome;
		this.valor=valor;
		this.tipo=tipo;
		this.estudio=estudio;
		this.idFornecedor=idFornecedor;
		this.categoria=categoria;
		this.estoque=estoque;
	}
	
	public Produto(double valor, int estoque) {
		this.valor=valor;
		this.estoque=estoque;
	}
	
	public Produto() {
		
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public void setIdProduto(int produtoId) {
		this.idProduto=produtoId;
	}
	
	public void setValor(double valor) {
		this.valor=valor;
	}
	
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}
	public void setEstudio(String estudio) {
		this.estudio=estudio;
	}
	
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor=idFornecedor;
	}
	
	public void setCategoria(String categoria) {
		this.categoria=categoria;
	}
	
	public void setEstoque(int estoque) {
		this.estoque=estoque;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getIdFornecedor() {
		return idFornecedor;
	}
	
	public String getEstudio() {
		return estudio;
	}
	public String getTipo() {
		return tipo;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public double getValor() {
		return valor;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public int getEstoque() {
		return estoque;
	}
	
	@Override
	public String toString() {
		return "Produto [produtoId = " + idProduto + ", nome = " + nome + valor + tipo + estudio +categoria + idFornecedor + "]";
	}

}
