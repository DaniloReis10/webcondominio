package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
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
	
	//O Servlet que faz esta operação chama-se "ServletExibir_e_SalvarDadosCadastrados
	public void salvar(CadastroCondominosDados cadastro_condominos) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "INSERT INTO tbl_morador(CPF,"
				+ "Morador_Nome,"
				+ "Morador_Email,"
				+ "Morador_DataNascimento,"
				+ "Morador_Sindico,"
				+ "Morador_Telefone,"
				+ "Tipo_morador_idTipo_morador,"
				+ "Morador_Senha_Hash) "
				+ "values (?,?,?,?,?,?,?,?)";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transaÃƒÆ’Ã‚Â§ÃƒÆ’Ã‚Â£o			
			ps = this.conexao.prepareStatement(sql);
			ps.setString(1,cadastro_condominos.getCPF());
			ps.setString(2,cadastro_condominos.getMorador_Nome());
			ps.setString(3,cadastro_condominos.getMorador_Email());
			ps.setDate(4,cadastro_condominos.getMorador_DataNascimento());
			ps.setInt(5,cadastro_condominos.getMorador_Sindico());
			ps.setString(6,cadastro_condominos.getMorador_Telefone());
			ps.setString(7,cadastro_condominos.getTipo_morador_idTipo_morador());
			ps.setString(8,cadastro_condominos.getMorador_Senha_Hash());
			
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
		String sql = "UPDATE tbl_morador SET CPF=?,"
				+ "Morador_Nome=?,"
				+ "Morador_Email=?,"
				+ "Morador_DataNascimento=?"
				+ "Morador_Sindico=?"
				+ "Morador_Telefone=?"
				+ "Tipo_morador_idTipo_morador=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transaÃƒÆ’Ã‚Â§ÃƒÆ’Ã‚Â£o			
			ps = this.conexao.prepareStatement(sql);
			
			ps.setString(1, cadastro_condominos.getCPF());
			ps.setString(2, cadastro_condominos.getMorador_Nome());
			ps.setString(3, cadastro_condominos.getMorador_Email());
			ps.setDate(4, cadastro_condominos.getMorador_DataNascimento());
			ps.setInt(5, cadastro_condominos.getMorador_Sindico());
			ps.setString(6, cadastro_condominos.getMorador_Telefone());
			ps.setString(7,cadastro_condominos.getTipo_morador_idTipo_morador());
			
			
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
		String sql = "DELETE FROM tbl_morador WHERE CPF=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transaÃƒÆ’Ã‚Â§ÃƒÆ’Ã‚Â£o			
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
	
	public List<CadastroCondominosDados> listarDadosMoradores() throws SQLException {
		
		Statement myStmt = null;
		
		try {
			List<CadastroCondominosDados> lista = new ArrayList<CadastroCondominosDados>();

			myStmt = this.conexao.createStatement();

			String sql = "SELECT * FROM tbl_morador";
			ResultSet rs = myStmt.executeQuery(sql);

			while (rs.next()) {

				CadastroCondominosDados cadastro_condominos = new CadastroCondominosDados();

				cadastro_condominos.setCPF(rs.getString("CPF"));
				cadastro_condominos.setMorador_Nome(rs.getString("Morador_Nome"));
				cadastro_condominos.setMorador_Email(rs.getString("Morador_Email"));
				cadastro_condominos.setMorador_DataNascimento(rs.getDate("Morador_DataNascimento"));
				cadastro_condominos.setMorador_Sindico(rs.getInt("Morador_Sindico"));
				cadastro_condominos.setMorador_Telefone(rs.getString("Morador_Telefone"));
				cadastro_condominos.setTipo_morador_idTipo_morador(rs.getString("Tipo_morador_idTipo_morador"));

				lista.add(cadastro_condominos);
			}

			return lista;
		} finally {
			 if(myStmt != null){
				 myStmt.close();
			 }
		}
		
		
	}
	
	
}

