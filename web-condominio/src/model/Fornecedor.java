package model;

/**
 * @author alunok9
 *
 */
public class Fornecedor {

	private Integer id;
	private String nome;
	private String email;
	private Endereco endereco;
	
	/**
	 * 
	 */
	public Fornecedor() {}
	
	/**
	 * @param nome
	 */
	public Fornecedor(String nome){
		this.nome = nome;
	}

	/**
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 */
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", nome=" + nome + ", email=" + email +  ", endereco=" + endereco + "]";
	}
}
