package test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import dao.TipoDespesaDao;
import model.TipoDespesa;

public class CargaTipoDespesa {

	@Test
	public void carga() throws SQLException {
		
		String[] lista = {
			"Básico",
			"Manutenção",
			"Funcionario",
			"Imposto",
			"Segurança"
		};
		
		for (String descricao: lista) {
			TipoDespesa tipo = new TipoDespesa();
			tipo.setDescricao(descricao);
			
			TipoDespesaDao dao = new TipoDespesaDao();
			dao.salvar(tipo);
		}
	}
	
	@Ignore
	public void excluirTudo() throws SQLException {
		
		TipoDespesaDao dao = new TipoDespesaDao();
		
		List<TipoDespesa> lista = dao.listar();
		
		for (TipoDespesa tipo : lista) {
			dao.excluir(tipo);
		}
	}
	
}
