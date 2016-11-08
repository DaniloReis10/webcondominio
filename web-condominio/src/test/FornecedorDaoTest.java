package test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import dao.FornecedorDao;
import model.Endereco;
import model.Fornecedor;

public class FornecedorDaoTest {
	
	@Test
	public void salvarFornecedor() throws SQLException{
		
		Endereco endereco = new Endereco();		
		endereco.setLogradouro("");
		endereco.setNumero("");
		endereco.setBairro("");
		endereco.setCidade("");
		endereco.setEstado("");
		endereco.setCep("");
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("S/F");
		fornecedor.setDescricao("S/F");
		fornecedor.setEndereco(endereco);
		
		FornecedorDao dao = new FornecedorDao();
		dao.salvar(fornecedor);
		
		System.out.println("Fornecedor cadastrado com sucesso!");
	}
	
	@Ignore
	public void alterarFornecedor() throws SQLException{
		
		Integer idFornecedor = 1;
		
		FornecedorDao dao = new FornecedorDao();
		Integer idEndereco = dao.fornecedorPorId(idFornecedor).getEndereco().getId();
		
		Endereco endereco = new Endereco();
		endereco.setId(idEndereco);
		endereco.setLogradouro("Rua Ana Bilhar");
		endereco.setNumero("123");
		endereco.setBairro("Meireles");
		endereco.setCidade("Fortaleza");
		endereco.setEstado("Ceará");
		endereco.setCep("60170021");		
		endereco.setComplemento("Proximo de X");
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(idFornecedor);
		fornecedor.setNome("Cagece");
		fornecedor.setDescricao("Cia de água");
		fornecedor.setEndereco(endereco);
		
		dao.alterar(fornecedor);
		
		System.out.println("Fornecedor atualizado com sucesso!");
	}
	
	@Ignore
	public void excluirFornecedor() throws SQLException{
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setId(2);
		
		FornecedorDao dao = new FornecedorDao();
		dao.excluir(fornecedor);
		
		System.out.println("Fornecedor excluido com sucesso!");
	}
	
	@Ignore
	public void listarFornecedor() throws SQLException {
		FornecedorDao dao = new FornecedorDao();
		List<Fornecedor> lista = dao.listar();
		for (Fornecedor fornecedor : lista) {
			System.out.println(fornecedor.toString());
		}
	}
}
