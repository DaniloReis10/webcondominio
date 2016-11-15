package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Periodicidade;

public class PeriodicidadeDao {
	
	private Connection conexao;
	
	public PeriodicidadeDao() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	public void salvar(Periodicidade periodicidade) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "INSERT INTO tbl_periodicidade(descricao) values (?)";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transação			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setString(1, periodicidade.getDescricao());			
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
	
	public void alterar(Periodicidade periodicidade) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "UPDATE tbl_periodicidade SET descricao=? WHERE id=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transação			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setString(1, periodicidade.getDescricao());
			ps.setInt(2, periodicidade.getId());
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
	
	public void excluir(Periodicidade periodicidade) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "DELETE FROM tbl_periodicidade WHERE id=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transação			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setInt(1, periodicidade.getId());
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
	
	public List<Periodicidade> listar() throws SQLException {
		
		Statement myStmt = null;
		
		try {
			List<Periodicidade> lista = new ArrayList<Periodicidade>();

			myStmt = this.conexao.createStatement();

			String sql = "SELECT * FROM tbl_periodicidade";
			ResultSet resultSet = myStmt.executeQuery(sql);

			while (resultSet.next()) {

				Periodicidade periodicidade = new Periodicidade();

				Integer id = resultSet.getInt("id");
				String descricao = resultSet.getString("descricao");

				periodicidade.setId(id);
				periodicidade.setDescricao(descricao);

				lista.add(periodicidade);
			}

			return lista;
		} finally {
			if(myStmt != null){
				 myStmt.close();
			 }
		}
	}
	
	public Periodicidade periodicidadePorId(Integer id) throws SQLException {
		
		PeriodicidadeDao dao = new PeriodicidadeDao();
		
		List<Periodicidade> lista = dao.listar();
		
		for (Periodicidade periodicidade : lista) {
			if(periodicidade.getId().equals(id)){
				return periodicidade;
			}
		}
		
		return null;
	}
}
