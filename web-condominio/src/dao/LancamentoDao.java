package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Despesa;
import model.Lancamento;

public class LancamentoDao {
	
	private Connection conexao;
	
	public LancamentoDao() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	public Integer salvar(Lancamento lancamento) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "INSERT INTO tbl_lancamento_despesa(data,valor,tbl_despesa_id) values (?,?,?)";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transação			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setDate(1, lancamento.getData());
			ps.setFloat(2, lancamento.getValor());
			ps.setInt(3, lancamento.getDespesa().getId());
			
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
	
	public void alterar(Lancamento lancamento) throws SQLException {		
		PreparedStatement ps = null;		
		String sql = "UPDATE tbl_lancamento_despesa SET data=?,valor=?,tbl_despesa_id=? WHERE id=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transação			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setDate(1, lancamento.getData());
			ps.setFloat(2, lancamento.getValor());
			ps.setInt(3, lancamento.getDespesa().getId());
			ps.setInt(4, lancamento.getId());
			
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
	
	public void excluir(Lancamento lancamento) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "DELETE FROM tbl_lancamento_despesa WHERE id=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transação			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setInt(1, lancamento.getId());
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
	
	public List<Lancamento> listar() throws SQLException {
		
		Statement myStmt = null;
		
		try {
			List<Lancamento> lista = new ArrayList<Lancamento>();

			myStmt = this.conexao.createStatement();

			String sql = "SELECT * FROM tbl_lancamento_despesa";
			ResultSet rs = myStmt.executeQuery(sql);

			while (rs.next()) {

				Lancamento lancamento = new Lancamento();

				lancamento.setId(rs.getInt("id"));
				lancamento.setData(rs.getDate("data"));
				lancamento.setValor(rs.getFloat("valor"));

				Integer idDespesa = rs.getInt("tbl_despesa_id");
				DespesaDao dDao = new DespesaDao();
				Despesa despesa = dDao.despesaPorId(idDespesa);

				lancamento.setDespesa(despesa);

				lista.add(lancamento);
			}

			return lista;
		} finally {
			if(myStmt != null){
				 myStmt.close();
			 }
		}
	}
	
public Lancamento lancamentoPorId(Integer id) throws SQLException {
		
		LancamentoDao dao = new LancamentoDao();
		
		List<Lancamento> lista = dao.listar();
		
		for (Lancamento lancamento : lista) {
			if(lancamento.getId().equals(id)){
				return lancamento;
			}
		}
		
		return null;
	}

	public List<Lancamento> lancamentoPorData(Date data) throws SQLException {
	
		LancamentoDao dao = new LancamentoDao();
		
		List<Lancamento> lista = dao.listar();
		List<Lancamento> retorno = new ArrayList<Lancamento>();
		
		for (Lancamento lancamento : lista) {
			
			Calendar d = UtilDao.toCalendar(data);
			Calendar dbData = UtilDao.toCalendar(lancamento.getData());
			
			if((d.get(Calendar.MONTH) == dbData.get(Calendar.MONTH)) &&
			   (d.get(Calendar.YEAR) == dbData.get(Calendar.YEAR))) {
						retorno.add(lancamento);			
			}
			
		}
		
		return null;
	}
	
	
}
