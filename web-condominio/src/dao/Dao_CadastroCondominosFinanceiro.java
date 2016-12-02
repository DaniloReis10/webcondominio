package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.CadastroCondominosDados;
import model.CadastroCondominosFinanceiro;

public class Dao_CadastroCondominosFinanceiro {
	private Connection conexao;

	public Dao_CadastroCondominosFinanceiro() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	public void salvar(CadastroCondominosFinanceiro cadastro_condominos_financeiro) throws SQLException{		
		PreparedStatement ps = null;		
		String sql = "INSERT INTO tbl_statusPagamento(mes,"
				+ "fk_CPF,"
				+ "vencimento	,"
				+ "pagEfetuado,"
				+ "dataPagamento,"
				+ "boletoURL,"
				+ "values (?,?,?,?,?,?)";		
		try {			
			this.conexao.setAutoCommit(false); // iniciar transação	
			ps = this.conexao.prepareStatement(sql);
			ps.setString(1,cadastro_condominos_financeiro.getMes());
			ps.setString(2,cadastro_condominos_financeiro.getFk_CPF());
			ps.setDate(3,cadastro_condominos_financeiro.getVencimento());
			ps.setString(4,cadastro_condominos_financeiro.getPagEfetuado());
			ps.setDate(5,cadastro_condominos_financeiro.getDataPagamento());
			ps.setString(6,cadastro_condominos_financeiro.getBoletoURL());

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
	
	public List<CadastroCondominosFinanceiro> listarDadosMoradores_Financeiro() throws SQLException {

		Statement myStmt = null;

		try {
			List<CadastroCondominosFinanceiro> lista = new ArrayList<CadastroCondominosFinanceiro>();

			myStmt = this.conexao.createStatement();

			String sql = "SELECT * FROM tbl_statusPagamento";
			ResultSet rs = myStmt.executeQuery(sql);

			while (rs.next()) {

				CadastroCondominosFinanceiro cadastro_condominos_financeiro = new CadastroCondominosFinanceiro();

				cadastro_condominos_financeiro.setMes(rs.getString("mes"));
				cadastro_condominos_financeiro.setFk_CPF(rs.getString("fk_CPF"));
				cadastro_condominos_financeiro.setVencimento(rs.getDate("vencimento"));
				cadastro_condominos_financeiro.setPagEfetuado(rs.getString("pagEfetuado"));
				cadastro_condominos_financeiro.setDataPagamento(rs.getDate("dataPagamento"));
				cadastro_condominos_financeiro.setBoletoURL(rs.getString("boletoURL"));
				lista.add(cadastro_condominos_financeiro);
			}

			return lista;
		} finally {
			if(myStmt != null){
				myStmt.close();
			}
		}


	}
	public List<CadastroCondominosFinanceiro> listarDadosMoradores_FinanceiroTelaMorador(String CPF) throws SQLException {

		Statement myStmt = null;

		try {
			List<CadastroCondominosFinanceiro> lista = new ArrayList<CadastroCondominosFinanceiro>();

			myStmt = this.conexao.createStatement();

			String sql = "SELECT * FROM tbl_statusPagamento WHERE fk_CPF = "+CPF;
			ResultSet rs = myStmt.executeQuery(sql);

			while (rs.next()) {

				CadastroCondominosFinanceiro cadastro_condominos_financeiro = new CadastroCondominosFinanceiro();

				cadastro_condominos_financeiro.setMes(rs.getString("mes"));
				cadastro_condominos_financeiro.setFk_CPF(rs.getString("fk_CPF"));
				cadastro_condominos_financeiro.setVencimento(rs.getDate("vencimento"));
				cadastro_condominos_financeiro.setPagEfetuado(rs.getString("pagEfetuado"));
				cadastro_condominos_financeiro.setDataPagamento(rs.getDate("dataPagamento"));
				cadastro_condominos_financeiro.setBoletoURL(rs.getString("boletoURL"));
				lista.add(cadastro_condominos_financeiro);
			}

			return lista;
		} finally {
			if(myStmt != null){
				myStmt.close();
			}
		}


	}
}
