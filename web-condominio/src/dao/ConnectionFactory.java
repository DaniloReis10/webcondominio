package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static String dbUrl = "jdbc:mysql://localhost/bdcondominio";
	private static String dbUser = "root";
	private static String dbPass = "123456";
	/*private static String dbUrl = "jdbc:mysql://localhost/db_condominio";
	private static String dbUser = "root";
	private static String dbPass = "ivia@2015";*/
	
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
