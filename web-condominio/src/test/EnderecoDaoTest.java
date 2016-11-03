package test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import dao.EnderecoDao;
import model.Endereco;

public class EnderecoDaoTest {
	
	@Ignore
	public void salvarEndereco() throws SQLException{
		
		Endereco endereco = new Endereco();
		
		endereco.setLogradouro("Rua Barbosa de Freitas");
		endereco.setNumero("229");
		endereco.setBairro("Meireles");
		endereco.setCidade("Fortaleza");
		endereco.setEstado("Ceará");
		endereco.setCep("60170020");
		
		EnderecoDao dao = new EnderecoDao();
		dao.salvar(endereco);
		
		System.out.println("Endereço cadastrado com sucesso!");
	}
	
	@Ignore
	public void alterarEndereco() throws SQLException{
		
		Endereco endereco = new Endereco();
		
		endereco.setId(1);
		endereco.setLogradouro("Rua Barbosa de Freitas");
		endereco.setNumero("229");
		endereco.setBairro("Meireles");
		endereco.setCidade("Fortaleza");
		endereco.setEstado("Ceará");
		endereco.setCep("60170020");
		
		endereco.setComplemento("Esquina com Ana Bilhar");
		
		EnderecoDao dao = new EnderecoDao();
		dao.alterar(endereco);
		
		System.out.println("Endereço atualizado com sucesso!");
	}
	
	@Ignore
	public void excluirEndereco() throws SQLException{
		
		Endereco endereco = new Endereco();
		endereco.setId(3);
		
		EnderecoDao dao = new EnderecoDao();
		dao.excluir(endereco);
		
		System.out.println("Endereço excluido com sucesso!");
	}
	
	@Ignore
	public void listarEndereco() throws SQLException{
		
		EnderecoDao dao = new EnderecoDao();
		List<Endereco> lista = dao.listar();
		
		for (Endereco endereco : lista) {
			System.out.println(endereco.toString());
		}
	}
	
	@Test
	public void enderecoPorId() throws SQLException{
		EnderecoDao dao = new EnderecoDao();
		Endereco endereco = dao.enderecoPorId(4);
		System.out.println(endereco.toString());
	}
}
