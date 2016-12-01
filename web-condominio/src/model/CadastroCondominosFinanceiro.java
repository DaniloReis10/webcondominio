package model;

import java.sql.Date;

public class CadastroCondominosFinanceiro {
	private String mes;
	private String fk_CPF;
	private Date vencimento;
	private String pagEfetuado;
	private Date dataPagamento;
	private String boletoURL;
	
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getFk_CPF() {
		return fk_CPF;
	}
	public void setFk_CPF(String fk_CPF) {
		this.fk_CPF = fk_CPF;
	}
	public Date getVencimento() {
		return vencimento;
	}
	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}
	public String getPagEfetuado() {
		return pagEfetuado;
	}
	public void setPagEfetuado(String pagEfetuado) {
		this.pagEfetuado = pagEfetuado;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public String getBoletoURL() {
		return boletoURL;
	}
	public void setBoletoURL(String boletoURL) {
		this.boletoURL = boletoURL;
	}
	
}
