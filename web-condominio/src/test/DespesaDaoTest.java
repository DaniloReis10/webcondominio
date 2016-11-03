package test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import dao.DespesaDao;
import model.Despesa;
import model.Fornecedor;
import model.TipoDespesa;

public class DespesaDaoTest {
	
	@Ignore
	public void salvarDespesa() throws SQLException{
		
		Despesa despesa = new Despesa();
		TipoDespesa tipo = new TipoDespesa();
		Fornecedor fornecedor = new Fornecedor();
		
		tipo.setId(3);
		fornecedor.setId(3);
		
		despesa.setNome("Energia Eletrica");
		despesa.setTipo(tipo);
		despesa.setFornecedor(fornecedor);
		
		DespesaDao dao = new DespesaDao();
		dao.salvar(despesa);
		
		System.out.println("Despesa cadastrada com sucesso!");
	}
	
	@Ignore
	public void alterarDespesa() throws SQLException{
		
		Integer idDespesa = 1;
		
		Despesa despesa = new Despesa();
		TipoDespesa tipo = new TipoDespesa();
		Fornecedor fornecedor = new Fornecedor();
		
		tipo.setId(2);
		fornecedor.setId(3);
		
		despesa.setId(idDespesa);
		despesa.setNome("NomeTest");
		despesa.setTipo(tipo);
		despesa.setFornecedor(fornecedor);
		
		DespesaDao dao = new DespesaDao();
		
		dao.alterar(despesa);
		
		System.out.println("Despesa atualizada com sucesso!");
	}
	
	@Ignore
	public void excluirDespesa() throws SQLException{
		
		Despesa despesa = new Despesa();
		despesa.setId(1);
		
		DespesaDao dao = new DespesaDao();
		dao.excluir(despesa);
		
		System.out.println("Despesa excluida com sucesso!");
	}
	
	@Test
	public void listarDespesa() throws SQLException {
		DespesaDao dao = new DespesaDao();
		List<Despesa> lista = dao.listar();
		for (Despesa despesa: lista) {
			System.out.println(despesa.toString());
		}
	}
}
