package model;

import java.sql.Date;

public class CadastroCondominosDados {
	private String CPF;
	private String Morador_Nome;
	private String Morador_Email;
	private Date Morador_DataNascimento;
	private int Morador_Sindico;
	private String Morador_Telefone;
	private String Tipo_morador_idTipo_morador;
	private String Morador_Senha_Hash;
	private String mes;
	private String fk_CPF;
	private Date vencimento;
	private String pagEfetuado;
	private Date dataPagamento;
	private String boletoURL;
	
	public String getTipo_morador_idTipo_morador() {
		return Tipo_morador_idTipo_morador;
	}

	public void setTipo_morador_idTipo_morador(String tipo_morador_idTipo_morador) {
		Tipo_morador_idTipo_morador = tipo_morador_idTipo_morador;
	}
	
	public CadastroCondominosDados(){
		
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getMorador_Nome() {
		return Morador_Nome;
	}

	public void setMorador_Nome(String morador_Nome) {
		Morador_Nome = morador_Nome;
	}

	public String getMorador_Email() {
		return Morador_Email;
	}

	public void setMorador_Email(String morador_Email) {
		Morador_Email = morador_Email;
	}

	public int getMorador_Sindico() {
		return Morador_Sindico;
	}

	public void setMorador_Sindico(int morador_Sindico) {
		Morador_Sindico = morador_Sindico;
	}

	public String getMorador_Telefone() {
		return Morador_Telefone;
	}

	public void setMorador_Telefone(String morador_Telefone) {
		Morador_Telefone = morador_Telefone;
	}

	public String getMorador_Senha_Hash() {
		return Morador_Senha_Hash;
	}

	public void setMorador_Senha_Hash(String Morador_Senha_Hash) {
		this.Morador_Senha_Hash = Morador_Senha_Hash;
	}

	public Date getMorador_DataNascimento() {
		return Morador_DataNascimento;
	}

	public void setMorador_DataNascimento(Date morador_DataNascimento) {
		Morador_DataNascimento = morador_DataNascimento;
	}

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
