package model;

public class ItemVenda {
	private int idVenda;
	private int idProduto;
	private int quantidade;
	
	public ItemVenda(int idVenda, int idProduto, int quantidade) {
		this.idVenda = idVenda;
		this.quantidade = quantidade;
		this.idProduto = idProduto;
	}
	
	public ItemVenda() {
		
	}
	
	public void setIdVenda(int vendaId) {
		this.idVenda = vendaId;
	}
	
	public int getIdVenda() {
		return idVenda;
	}
	
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	
	public int getIdProduto() {
		return idProduto;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	

}
