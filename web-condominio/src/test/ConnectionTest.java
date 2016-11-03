package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import dao.ConnectionFactory;

public class ConnectionTest {
	
	@Test
	public void connectionTest() {
		try {
			
			Connection myConn = ConnectionFactory.getConnection();
			Statement myStmt = myConn.createStatement();
			
			String sql = "SELECT * FROM tbl_fornecedor";
			ResultSet resultSet = myStmt.executeQuery(sql);
			
			while(resultSet.next()) {
				
				String codigo = resultSet.getString("id");
				String nome = resultSet.getString("nome");
				String descricao = resultSet.getString("descricao");
				
				System.out.println(codigo + "," + nome + "," + descricao);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
