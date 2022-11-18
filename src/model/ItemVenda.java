package model;

public class ItemVenda {
	private int codigoProduto;
	private int quantidade;
	private int notaFiscalVenda;
	
	public ItemVenda(int codigoProduto, int quantidade, int notaFiscalVenda) {
		this.codigoProduto = codigoProduto;
		this.quantidade = quantidade;
		this.notaFiscalVenda = notaFiscalVenda;
	}
	public int getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getNotaFiscalVenda() {
		return notaFiscalVenda;
	}
	public void setNotaFiscalVenda(int notaFiscalVenda) {
		this.notaFiscalVenda = notaFiscalVenda;
	}
}
