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
import model.CadastroCondominosDados;

public class CadastroCondominosDao {
	private Connection conexao;
	
	public CadastroCondominosDao() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	public void salvar(CadastroCondominosDados cadastro_condominos) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "INSERT INTO morador(CPF, Morador_Nome, Morador_Email, Morador_DataNascimento, Morador_Sindico"
				+ "Morador_Telefone, Tipo_morador_idTipo_morador, senha ) "
				+ "values (?,?,?,?,?,?,?)";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transaÃ§Ã£o			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setString(1,cadastro_condominos.getCPF());
			ps.setString(2,cadastro_condominos.getMorador_Nome());
			ps.setString(3,cadastro_condominos.getMorador_Email());
			ps.setString(4,cadastro_condominos.getMorador_DataNascimento());
			ps.setString(5,cadastro_condominos.getMorador_Sindico());
			ps.setString(6,cadastro_condominos.getMorador_Telefone());
			ps.setString(7,cadastro_condominos.getTipo_morador_idTipo_morador());
			ps.setString(8,cadastro_condominos.getSenha());
			
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
	
	public void alterar(CadastroCondominosDados cadastro_condominos) throws SQLException {		
		PreparedStatement ps = null;		
		String sql = "UPDATE morador SET CPF=?,"
				+ "Morador_Nome=?,"
				+ "Morador_Email=?,"
				+ "Morador_DataNascimento=?"
				+ "Morador_Sindico=?"
				+ "Morador_Telefone=?"
				+ "Tipo_morador_idTipo_morador=?"
				+ "senha=? WHERE id=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transaÃ§Ã£o			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setString(1, cadastro_condominos.getCPF());
			ps.setString(2, cadastro_condominos.getMorador_Nome());
			ps.setString(3, cadastro_condominos.getMorador_Email());
			ps.setString(4, cadastro_condominos.getMorador_DataNascimento());
			ps.setString(5, cadastro_condominos.getMorador_Sindico());
			ps.setString(6, cadastro_condominos.getMorador_Telefone());
			ps.setString(7,cadastro_condominos.getTipo_morador_idTipo_morador());
			ps.setString(8,cadastro_condominos.getSenha());
			
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
	
	public void excluir(CadastroCondominosDados cadastro_condominos) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "DELETE FROM morador WHERE CPF=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transaÃ§Ã£o			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setString(1, cadastro_condominos.getCPF());
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
	
	public List<CadastroCondominosDados> listar() throws SQLException {
		
		Statement myStmt = null;
		
		try {
			List<CadastroCondominosDados> lista = new ArrayList<CadastroCondominosDados>();

			myStmt = this.conexao.createStatement();

			String sql = "SELECT * FROM morador";
			ResultSet rs = myStmt.executeQuery(sql);

			while (rs.next()) {

				CadastroCondominosDados cadastro_condominos = new CadastroCondominosDados();

				cadastro_condominos.setCPF(rs.getString("CPF"));
				cadastro_condominos.setMorador_Nome("Morador_Nome");
				cadastro_condominos.setCPF(rs.getString("Morador_Email"));
				cadastro_condominos.setCPF(rs.getString("Morador_DataNascimento"));
				cadastro_condominos.setCPF(rs.getString("Morador_Sindico"));
				cadastro_condominos.setCPF(rs.getString("Morador_Telefone"));
				cadastro_condominos.setCPF(rs.getString("senha"));
				cadastro_condominos.setCPF(rs.getString("Morador_Adimplente"));
				cadastro_condominos.setCPF(rs.getString("Tipo_morador_idTipo_morador"));

				lista.add(cadastro_condominos);
			}

			return lista;
		} finally {
			 if(myStmt != null){
				 myStmt.close();
			 }
		}
		
		
	}
	
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

