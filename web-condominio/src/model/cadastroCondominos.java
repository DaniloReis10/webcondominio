package model;

public class cadastroCondominos {
	private String CPF;
	private String Morador_Nome;
	private String Morador_Email;
	private String Morador_DataNascimento;
	private String Morador_Sindico;
	private String Morador_Telefone;
	private String senha;
	
	public cadastroCondominos(){
		
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

	public String getMorador_DataNascimento() {
		return Morador_DataNascimento;
	}

	public void setMorador_DataNascimento(String morador_DataNascimento) {
		Morador_DataNascimento = morador_DataNascimento;
	}

	public String getMorador_Sindico() {
		return Morador_Sindico;
	}

	public void setMorador_Sindico(String morador_Sindico) {
		Morador_Sindico = morador_Sindico;
	}

	public String getMorador_Telefone() {
		return Morador_Telefone;
	}

	public void setMorador_Telefone(String morador_Telefone) {
		Morador_Telefone = morador_Telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}