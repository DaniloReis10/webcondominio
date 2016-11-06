package model;

import java.sql.Date;

public class Lancamento {

	private Integer id;
	private Date data;
	private Float valor;
	private Despesa despesa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	@Override
	public String toString() {
		return "Lancamento [id=" + id + ", data=" + data + ", valor=" + valor + ", despesa=" + despesa + "]";
	}

}
