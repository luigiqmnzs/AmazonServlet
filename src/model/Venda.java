package model;

import java.util.Date;

public class Venda {
	private int notaFiscal;
	private Date dataVenda;
	private String clienteCPF;
	
	public Venda(int notaFiscal, String clienteCPF) {
		this.notaFiscal = notaFiscal;
		this.clienteCPF = clienteCPF;
		this.dataVenda = new Date();
	}
	public int getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(int notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	public String getClienteCPF() {
		return clienteCPF;
	}
	public void setClienteCPF(String clienteCPF) {
		this.clienteCPF = clienteCPF;
	}
	
}
