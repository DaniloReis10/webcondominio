package model;

public class Fornecedor {

	private Integer id;
	private String nome;
	private String descricao;
	private String email;
	private String senha;
	private Endereco endereco;
	
	public Fornecedor() {}
	
	public Fornecedor(String nome){
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", email=" + email + ", senha="
				+ senha + ", endereco=" + endereco + "]";
	}
}
