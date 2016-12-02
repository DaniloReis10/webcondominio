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

/**
* Esta classe possui m�todos usados para inserir no banco de dados os dados pessoais dos moradores (CPF, nome, email, data de nascimento
* Se ele � sindico ou n�o (se for sindico ele ser� o administrador), telefone, tipo de morador (propriet�rio ou locat�rio)
* e a senha (que ap�s criptografada - esta criptografia fica presente dentro da Servlet LoginAuthentication -  � armazenada no banco de dados).
* A maioria dos m�todos s�o usados pelo administrador, e a servlet que trata estas fun��es chama-se ServletExibir_e_SalvarDadosCadastrados,
* mas possui alguns m�todos que s�o tratados na servlet "Servlet_VerificarStatusPagamento".
*/
public class CadastroCondominosDao {
	private Connection conexao;

	public CadastroCondominosDao() {
		this.conexao = ConnectionFactory.getConnection();
	}	
	
	/**
	* processamento do metodo salvar (O Servlet que processa esta opera��o chama-se "ServletExibir_e_SalvarDadosCadastrados")
	* @cadastro_condominos objeto do tipo CadastroCondominosDados que armazena os dados do morador
	* @return nenhum
	*/
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
			this.conexao.setAutoCommit(false); // iniciar transaÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â§ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â£o			
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
	
	/**
	* processamento do metodo alterar (O Servlet que processa esta opera��o chama-se "ServletExibir_e_SalvarDadosCadastrados)
	* @cadastro_condominos objeto do tipo CadastroCondominosDados que armazena os dados do morador
	* @return nenhum
	*/
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
			this.conexao.setAutoCommit(false); // iniciar transaÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â§ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â£o			
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
	
	/**
	* processamento do metodo excluir (O Servlet que processa esta opera��o chama-se "ServletExibir_e_SalvarDadosCadastrados)
	* @cadastro_condominos objeto do tipo CadastroCondominosDados que armazena os dados do morador
	* @return nenhum
	*/
	public void excluir(CadastroCondominosDados cadastro_condominos) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "DELETE FROM tbl_morador WHERE CPF=?";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transa��o
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
	
	/**
	* processamento do metodo listarDadosMoradores (O Servlet que processa esta opera��o chama-se "ServletExibir_e_SalvarDadosCadastrados)
	* @cadastro_condominos objeto do tipo CadastroCondominosDados que armazena os dados do morador
	* @return List (retorna um List de objetos do tipo CadastroCondominosDados, contendo os dados dos moradores
	*/
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
	
	/**
	* processamento do metodo alterarCPF (utilizado para atualizar apenas o CPF do Morador. Processado principalmente pela Servlet_VerificarStatusPagamento)
	* @CPF objeto do tipo String que armazena o CPF
	* @return nenhum
	*/
	public void alterarCPF(String CPF) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "UPDATE tbl_morador set CPF = ? where CPF="+CPF;		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transaÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â§ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â£o			
			ps = this.conexao.prepareStatement(sql);

			ps.setString(1, CPF);
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
	
	public void alterarMorador_Sindico(String Morador_Sindico,String CPF) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "UPDATE tbl_morador set Morador_Sindico = ? where CPF="+CPF;		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transaÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â§ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â£o			
			ps = this.conexao.prepareStatement(sql);

			ps.setString(1, Morador_Sindico);
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
	
	public void alterarTipo_morador_idTipo_morador(String Tipo_morador_idTipo_morador, String CPF) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "UPDATE tbl_morador set Tipo_morador_idTipo_morador = ? where CPF="+CPF;		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transaÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â§ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â£o			
			ps = this.conexao.prepareStatement(sql);

			ps.setString(1, Tipo_morador_idTipo_morador);
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
	* processamento do metodo alterarMorador_Nome (atualizado para atualizar apenas o Nome do Morador. Processado principalmente pela Servlet_VerificarStatusPagamento)
	* @CPF objeto do tipo String que armazena o CPF
	* @Morador_Nome objeto do tipo String que armazena o nome do Morador
	* @return nenhum
	*/
	public void alterarMorador_Nome(String Morador_Nome, String CPF) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "UPDATE tbl_morador set Morador_Nome = ? where CPF="+CPF;		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transaÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â§ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â£o			
			ps = this.conexao.prepareStatement(sql);

			ps.setString(1, Morador_Nome);
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
	* processamento do metodo alterarMorador_Email (utilizado para atualizar o Email do Morador. Processado principalmente pela Servlet_VerificarStatusPagamento)
	* @CPF objeto do tipo String que armazena o CPF
	* @Morador_Email objeto do tipo String que armazena o email do Morador
	* @return nenhum
	*/
	public void alterarMorador_Email(String Morador_Email, String CPF) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "UPDATE tbl_morador set Morador_Email = ? WHERE CPF = "+CPF;		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transaÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â§ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â£o			
			ps = this.conexao.prepareStatement(sql);

			ps.setString(1, Morador_Email);
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
	* processamento do metodo alterarMorador_Telefone (utilizado para atualizar o Telefone do Morador. Processado principalmente pela Servlet_VerificarStatusPagamento)
	* @CPF objeto do tipo String que armazena o CPF
	* @Morador_Telefone objeto do tipo String que armazena o telefone do Morador
	* @return nenhum
	*/
	public void alterarMorador_Telefone(String Morador_Telefone, String CPF) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "UPDATE tbl_morador set Morador_Telefone = ? where CPF="+CPF;		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transaÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â§ÃƒÆ’Ã†â€™Ãƒâ€šÃ‚Â£o			
			ps = this.conexao.prepareStatement(sql);

			ps.setString(1, Morador_Telefone);
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

}

