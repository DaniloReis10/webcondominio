package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;

/**
 * @author alunok9
 *
 */
public class EnderecoDao {
private Connection conexao;
	
	/**
	 * 
	 */
	public EnderecoDao() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	/**
	 * @param endereco
	 * @return
	 * @throws SQLException
	 */
	public Integer salvar(Endereco endereco) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "INSERT INTO tbl_endereco(logradouro,numero,cep) values (?,?,?)";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transa��o			
			ps = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, endereco.getLogradouro());
			ps.setString(2, endereco.getNumero());
			ps.setString(3, endereco.getCep());
			
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
	
	/**
	 * @param endereco
	 * @throws SQLException
	 */
	public void alterar(Endereco endereco) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "UPDATE tbl_endereco SET logradouro=?,numero=?,bairro=?,complemento=?,cidade=?,estado=?,cep=? WHERE id=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transa��o			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setString(1, endereco.getLogradouro());
			ps.setString(2, endereco.getNumero());
			ps.setString(4, endereco.getComplemento());
			ps.setString(7, endereco.getCep());
			ps.setInt(8, endereco.getId());
			
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
	 * @param endereco
	 * @throws SQLException
	 */
	public void excluir(Endereco endereco) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "DELETE FROM tbl_endereco WHERE id=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transa��o			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setInt(1, endereco.getId());
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
	 * @return
	 * @throws SQLException
	 */
	public List<Endereco> listar() throws SQLException {
		
		Statement myStmt = null;
		
		try {
			List<Endereco> lista = new ArrayList<Endereco>();
			
			myStmt = this.conexao.createStatement();
			
			String sql = "SELECT * FROM tbl_endereco";
			ResultSet resultSet = myStmt.executeQuery(sql);
			
			while(resultSet.next()) {
				
				Endereco endereco = new Endereco();
				
				Integer id = resultSet.getInt("id");
				String logradouro = resultSet.getString("logradouro");
				String numero = resultSet.getString("numero");
				String bairro = resultSet.getString("bairro");
				String complemento = resultSet.getString("complemento");
				String cidade = resultSet.getString("cidade");
				String estado = resultSet.getString("estado");
				String cep = resultSet.getString("cep");
				
				endereco.setId(id);
				endereco.setLogradouro(logradouro);
				endereco.setNumero(numero);
				endereco.setComplemento(complemento);
				endereco.setCep(cep);
				
				lista.add(endereco);
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
	public Endereco enderecoPorId(Integer id) throws SQLException {
		
		EnderecoDao dao = new EnderecoDao();
		
		List<Endereco> lista = dao.listar();
		
		for (Endereco endereco : lista) {
			if(endereco.getId().equals(id)){
				return endereco;
			}
		}
		
		return null;
		
	}
}
