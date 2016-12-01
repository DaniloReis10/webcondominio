package model;

/**
 * @author alunok9
 *
 */
public class Endereco {

	private Integer id;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cep;
	
	/**
	 * 
	 */
	public Endereco() {
		this.complemento = "";
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
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento 
				+ ", cep=" + cep + "]";
	}
}
