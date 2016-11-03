package test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import dao.TipoDespesaDao;
import model.TipoDespesa;

public class TipoDespesaDaoTest {
	
	@Ignore
	public void salvarTipoDespesa() throws SQLException{
		
		TipoDespesa tipo = new TipoDespesa();
		tipo.setDescricao("Básica");
		
		TipoDespesaDao dao = new TipoDespesaDao();
		dao.salvar(tipo);
		
		System.out.println("Tipo de Despesa cadastrado com sucesso!");
	}
	
	@Ignore
	public void alterarTipoDespesa() throws SQLException{
		
		TipoDespesa tipo = new TipoDespesa();
		tipo.setId(2);
		tipo.setDescricao("Imposto");
		
		TipoDespesaDao dao = new TipoDespesaDao();
		dao.alterar(tipo);
		
		System.out.println("Tipo de Despesa atualizado com sucesso!");
	}
	
	@Ignore
	public void excluirTipoDespesa() throws SQLException{
		
		TipoDespesa tipo = new TipoDespesa();
		tipo.setId(1);
		
		TipoDespesaDao dao = new TipoDespesaDao();
		dao.excluir(tipo);
		
		System.out.println("Tipo de Despesa excluido com sucesso!");
	}
	
	@Test
	public void listarTipoDespesa() throws SQLException{
		
		TipoDespesaDao dao = new TipoDespesaDao();
		List<TipoDespesa> lista = dao.listar();
		
		for (TipoDespesa tipo : lista) {
			System.out.println(tipo.toString());
		}
	}
}
