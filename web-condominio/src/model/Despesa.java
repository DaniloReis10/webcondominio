package model;

public class Despesa {

	private Integer id;
	private String nome;
	private TipoDespesa tipo;
	private Fornecedor fornecedor;
	private Periodicidade periodicidade;

	public Despesa() {
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

	public TipoDespesa getTipo() {
		return tipo;
	}

	public void setTipo(TipoDespesa tipo) {
		this.tipo = tipo;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Periodicidade getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(Periodicidade periodicidade) {
		this.periodicidade = periodicidade;
	}

	@Override
	public String toString() {
		return "Despesa [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", fornecedor=" + fornecedor
				+ ", periodicidade=" + periodicidade + "]";
	}

}
