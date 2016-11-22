package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static String dbUrl = "jdbc:mysql://sql9.freemysqlhosting.net/sql9144998";
	private static String dbUser = "sql9144998";
	private static String dbPass = "VnAexJFcQG";
	
	private static Connection myConn = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			if(myConn == null) {
				myConn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			}
			
			return myConn;
			
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
