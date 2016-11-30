package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Classe responsável por criar novas
 * connections como um Singleton
 * 
 *  @author Caio Ponte
 * */
public class ConnectionFactory {
	
	// Atributos do banco de dados online
	private static String dbUrl = "jdbc:mysql://sql3.freemysqlhosting.net/sql3147054";
	private static String dbUser = "sql3147054";
	private static String dbPass = "FtGgfm3IC6";
	
	// Descomentar caso queira usa banco de dados local
//	private static String dbUrl = "jdbc:mysql://localhost/db_condominio";
//	private static String dbUser = "root";
//	private static String dbPass = "root";
	
	private static Connection myConn = null;

	
	/*
	 * @return retorna uma nova conexão caso ela já não exista(Singleton)
	 * */
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
