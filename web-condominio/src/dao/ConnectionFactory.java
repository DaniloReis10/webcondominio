package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static String dbUrl = "jdbc:mysql://localhost/db_condominio";
	private static String dbUser = "root";
	private static String dbPass = "root";
	
	public static Connection getConnection() {		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			return myConn;
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
