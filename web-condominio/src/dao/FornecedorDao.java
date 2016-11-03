package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Fornecedor;

public class FornecedorDao {
	
	private Connection conexao;
	
	public FornecedorDao() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	public Integer salvar(Fornecedor fornecedor) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "INSERT INTO tbl_fornecedor(nome,descricao,email,senha,tbl_endereco_id) values (?,?,?,?,?)";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transação			
			ps = this.conexao.prepareStatement(sql);
			
			EnderecoDao enderecoDao = new EnderecoDao();
			Integer id = enderecoDao.salvar(fornecedor.getEndereco());
			
			ps.setString(1, fornecedor.getNome());
			ps.setString(2, fornecedor.getDescricao());
			ps.setString(3, fornecedor.getEmail());
			ps.setString(4, fornecedor.getSenha());
			ps.setInt(5, id);
			
			ps.execute();
			
			this.conexao.commit();
			
			return UtilDao.ultimoId(ps);
		} catch (SQLException e) {			
			e.printStackTrace();
			try {
				this.conexao.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return null;
		} finally {			
			if(ps != null){
				ps.close();
			}			
			this.conexao.setAutoCommit(true);
		}
	}
	
	public void alterar(Fornecedor fornecedor) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "UPDATE tbl_fornecedor SET nome=?,descricao=?,email=?,senha=? WHERE id=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transação			
			ps = this.conexao.prepareStatement(sql);
			
			// Altera a tabela endereço
			EnderecoDao enderecoDao = new EnderecoDao();
			Endereco endereco = enderecoDao.enderecoPorId(fornecedor.getEndereco().getId());
			enderecoDao.alterar(endereco);
			
			ps.setString(1, fornecedor.getNome());
			ps.setString(2, fornecedor.getDescricao());
			ps.setString(3, fornecedor.getEmail());
			ps.setString(4, fornecedor.getSenha());
			ps.setInt(5, fornecedor.getId());
			
			ps.execute();
			
			this.conexao.commit();			
		} catch (SQLException e) {			
			e.printStackTrace();
			try {
				this.conexao.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {			
			if(ps != null){
				ps.close();
			}			
			this.conexao.setAutoCommit(true);
		}
	}
	
	public void excluir(Fornecedor fornecedor) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "DELETE FROM tbl_fornecedor WHERE id=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transação			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setInt(1, fornecedor.getId());
			ps.execute();
			
			FornecedorDao fDao = new FornecedorDao();
			Integer idEndereco = fDao.fornecedorPorId(fornecedor.getId()).getEndereco().getId();
			
			this.conexao.commit();			

			EnderecoDao eDao = new EnderecoDao();
			Endereco endereco = new Endereco();
			endereco.setId(idEndereco);
			eDao.excluir(endereco);
			
		} catch (SQLException e) {			
			e.printStackTrace();
			try {
				this.conexao.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {			
			if(ps != null){
				ps.close();
			}			
			this.conexao.setAutoCommit(true);
		}
	}
	
	public List<Fornecedor> listar() throws SQLException {
		
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		
		Statement myStmt = this.conexao.createStatement();
		
		String sql = "SELECT * FROM tbl_fornecedor";
		ResultSet rs = myStmt.executeQuery(sql);
		
		while(rs.next()) {
			
			Fornecedor fornecedor = new Fornecedor();
			
			fornecedor.setId(rs.getInt("id"));
			fornecedor.setNome(rs.getString("nome"));
			fornecedor.setDescricao(rs.getString("descricao"));
			fornecedor.setEmail(rs.getString("email"));
			fornecedor.setSenha(rs.getString("senha"));
			
			Integer idEndereco = rs.getInt("tbl_endereco_id");
			EnderecoDao dao = new EnderecoDao();
			Endereco endereco = dao.enderecoPorId(idEndereco);
			
			fornecedor.setEndereco(endereco);
			
			lista.add(fornecedor);
		}
		
		return lista;
	}
	
	public Fornecedor fornecedorPorId(Integer id) throws SQLException {
		
		FornecedorDao dao = new FornecedorDao();
		
		List<Fornecedor> lista = dao.listar();
		
		for (Fornecedor fornecedor : lista) {
			if(fornecedor.getId().equals(id)){
				return fornecedor;
			}
		}
		
		return null;
	}
}
