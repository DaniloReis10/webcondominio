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

/**
 * @author alunok9
 *
 */
public class FornecedorDao {
	
	private Connection conexao;
	
	/**
	 * 
	 */
	public FornecedorDao() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	/**
	 * @param fornecedor
	 * @return
	 * @throws SQLException
	 */
	public Integer salvar(Fornecedor fornecedor) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "INSERT INTO tbl_fornecedor(nome, email, tbl_endereco_id) values (?, ?, ?)";		
		try {			
			this.conexao.setAutoCommit(false);	
			ps = this.conexao.prepareStatement(sql);
			
			EnderecoDao enderecoDao = new EnderecoDao();
			Integer id = enderecoDao.salvar(fornecedor.getEndereco());
			
			ps.setString(1, fornecedor.getNome());
			ps.setString(2, fornecedor.getEmail());
			ps.setInt(3, id);
			
			ps.execute();
			
			this.conexao.commit();
			
			return UtilDao.ultimoId(ps);
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao salvar um fornecedor");
			try {
				this.conexao.rollback();
			} catch (SQLException e1) {
				System.out.println("N�o foi possivel fazer rollback");
			}
			return null;
		} finally {			
			if(ps != null){
				ps.close();
			}			
			this.conexao.setAutoCommit(true);
		}
	}
	
	/**
	 * @param fornecedor
	 * @throws SQLException
	 */
	public void alterar(Fornecedor fornecedor) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "UPDATE tbl_fornecedor SET nome=?, email=? WHERE id=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transa��o			
			ps = this.conexao.prepareStatement(sql);
			
			// Altera a tabela endere�o
			EnderecoDao enderecoDao = new EnderecoDao();
			Endereco endereco = enderecoDao.enderecoPorId(fornecedor.getEndereco().getId());
			enderecoDao.alterar(endereco);
			
			ps.setString(1, fornecedor.getNome());
			ps.setString(2, fornecedor.getEmail());
			ps.setInt(3, fornecedor.getId());
			
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
	
	/**
	 * @param fornecedor
	 * @throws SQLException
	 */
	public void excluir(Fornecedor fornecedor) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "DELETE FROM tbl_fornecedor WHERE id=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transa��o			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setInt(1, fornecedor.getId());
			ps.execute();
			
			FornecedorDao fDao = new FornecedorDao();
			EnderecoDao eDao = new EnderecoDao();
			eDao.excluir(fornecedor.getEndereco());
			
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
	
	/**
	 * @return
	 * @throws SQLException
	 */
	public List<Fornecedor> listar() throws SQLException {
		
		Statement myStmt = null;
		
		try {
			List<Fornecedor> lista = new ArrayList<Fornecedor>();

			myStmt = this.conexao.createStatement();

			String sql = "SELECT forn.id as id, forn.nome as nome, forn.email as email, ender.id as enderecoId, ender.logradouro as logradouro, "
					+ "ender.numero as numero, ender.cep as cep FROM tbl_fornecedor as forn JOIN tbl_endereco as ender ON ender.id = forn.tbl_endereco_id";
			ResultSet rs = myStmt.executeQuery(sql);

			while (rs.next()) {

				Fornecedor fornecedor = new Fornecedor();

				fornecedor.setId(rs.getInt("id"));
				fornecedor.setNome(rs.getString("nome"));
				fornecedor.setEmail(rs.getString("email"));
				
				Endereco endereco = new Endereco();
				endereco.setId(rs.getInt("enderecoId"));
				endereco.setLogradouro(rs.getString("logradouro"));
				endereco.setNumero(rs.getString("numero"));
				endereco.setCep(rs.getString("cep"));
				
				fornecedor.setEndereco(endereco);

				lista.add(fornecedor);
			}

			return lista;
		} finally {
			if(myStmt != null){
				 myStmt.close();
			 }
		}
	}
	
	/**
	 * @param id
	 * @return
	 * @throws SQLException
	 */
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
