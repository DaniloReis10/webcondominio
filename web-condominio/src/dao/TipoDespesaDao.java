package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.TipoDespesa;

public class TipoDespesaDao {
	
	private Connection conexao;
	
	public TipoDespesaDao() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	public void salvar(TipoDespesa tipoDespesa) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "INSERT INTO tbl_tipo_despesa(descricao) values (?)";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transação			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setString(1, tipoDespesa.getDescricao());			
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
	
	public void alterar(TipoDespesa tipoDespesa) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "UPDATE tbl_tipo_despesa SET descricao=? WHERE id=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transação			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setString(1, tipoDespesa.getDescricao());
			ps.setInt(2, tipoDespesa.getId());
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
	
	public void excluir(TipoDespesa tipoDespesa) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "DELETE FROM tbl_tipo_despesa WHERE id=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transação			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setInt(1, tipoDespesa.getId());
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
	
	public List<TipoDespesa> listar() throws SQLException {
		
		List<TipoDespesa> lista = new ArrayList<TipoDespesa>();
		
		Statement myStmt = this.conexao.createStatement();
		
		String sql = "SELECT * FROM tbl_tipo_despesa";
		ResultSet resultSet = myStmt.executeQuery(sql);
		
		while(resultSet.next()) {
			
			TipoDespesa tipo = new TipoDespesa();
			
			Integer id = resultSet.getInt("id");
			String descricao = resultSet.getString("descricao");
			
			tipo.setId(id);
			tipo.setDescricao(descricao);
			
			lista.add(tipo);
		}
		
		return lista;
	}
	
	public TipoDespesa tipoDespesaPorId(Integer id) throws SQLException {
		
		TipoDespesaDao dao = new TipoDespesaDao();
		
		List<TipoDespesa> lista = dao.listar();
		
		for (TipoDespesa tipo : lista) {
			if(tipo.getId().equals(id)){
				return tipo;
			}
		}
		
		return null;
	}
}
