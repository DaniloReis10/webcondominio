package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Despesa;
import model.Fornecedor;
import model.Periodicidade;
import model.TipoDespesa;

/*
 * Classe responsável pelo acesso ao DB do Modelo de Despesa.
 * 
 * @author Caio Ponte
 * */
public class DespesaDao {
	
	private Connection conexao;
	
	/*
	 * Construtor
	 * */
	public DespesaDao() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	/*
	 * Método salvar despesa: todos os atributos são relevantes
	 * 
	 * @param despesa despesa com seus atributos preenchidos
	 * 
	 * @return um <code>integer</code> especificando o id no DB da última despesa inserida
	 * */
	public Integer salvar(Despesa despesa) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "INSERT INTO tbl_despesa(nome,tbl_tipo_despesa_id,tbl_fornecedor_id,tbl_periodicidade_id) values (?,?,?,?)";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transação			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setString(1, despesa.getNome());
			ps.setInt(2, despesa.getTipo().getId());
			ps.setInt(3, despesa.getFornecedor().getId());
			ps.setInt(4, despesa.getPeriodicidade().getId());
			
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
	
	/*
	 * Método alterar despesa: todos os atributos são relevantes
	 * 
	 * @param despesa despesa com seus atributos preenchidos
	 * */
	public void alterar(Despesa despesa) throws SQLException {		
		PreparedStatement ps = null;		
		String sql = "UPDATE tbl_despesa SET nome=?,tbl_tipo_despesa_id=?,tbl_fornecedor_id=?,tbl_periodicidade_id=? WHERE id=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transação			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setString(1, despesa.getNome());
			ps.setInt(2, despesa.getTipo().getId());
			ps.setInt(3, despesa.getFornecedor().getId());
			ps.setInt(4, despesa.getPeriodicidade().getId());
			ps.setInt(5, despesa.getId());
			
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
	
	/*
	 * Método excluir despesa: apenas o id é relevante
	 * 
	 * @param despesa despesa com o id da despesa que vai ser deletada
	 * */
	public void excluir(Despesa despesa) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "DELETE FROM tbl_despesa WHERE id=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transação			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setInt(1, despesa.getId());
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
	
	/*
	 * Método listar despesas
	 * 
	 * @return um lista de despesa com todas as despesas cadastradas no DB
	 * */
	public List<Despesa> listar() throws SQLException {
		
		Statement myStmt = null;
		
		try {
			List<Despesa> lista = new ArrayList<Despesa>();

			myStmt = this.conexao.createStatement();

			String sql = "SELECT * FROM tbl_despesa";
			ResultSet rs = myStmt.executeQuery(sql);

			while (rs.next()) {

				Despesa despesa = new Despesa();

				despesa.setId(rs.getInt("id"));
				despesa.setNome(rs.getString("nome"));

				Integer idTipo = rs.getInt("tbl_tipo_despesa_id");
				TipoDespesaDao tdDao = new TipoDespesaDao();
				TipoDespesa tipo = tdDao.tipoDespesaPorId(idTipo);

				Integer idFornecedor = rs.getInt("tbl_fornecedor_id");
				FornecedorDao fDao = new FornecedorDao();
				Fornecedor fornecedor = fDao.fornecedorPorId(idFornecedor);

				Integer idPeriodicidade = rs.getInt("tbl_periodicidade_id");
				PeriodicidadeDao pDao = new PeriodicidadeDao();
				Periodicidade periodicidade = pDao.periodicidadePorId(idPeriodicidade);

				despesa.setTipo(tipo);
				despesa.setFornecedor(fornecedor);
				despesa.setPeriodicidade(periodicidade);

				lista.add(despesa);
			}

			return lista;
		} finally {
			 if(myStmt != null){
				 myStmt.close();
			 }
		}
	}
	
	/*
	 * Método que retorna um objeto de despesa com um determinado id
	 * 
	 * @param um inteiro especificando o id da despesa
	 * 
	 * @return um objeto despesa com o id especificado
	 * */
	public Despesa despesaPorId(Integer id) throws SQLException {
		
		DespesaDao dao = new DespesaDao();
		
		List<Despesa> lista = dao.listar();
		
		for (Despesa despesa : lista) {
			if(despesa.getId().equals(id)){
				return despesa;
			}
		}
		
		return null;
	}
}
