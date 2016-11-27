package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * Servlet implementation class LoginAuthentication
 */
@WebServlet("/LoginAuthentication")
public class LoginAuthentication extends HttpServlet {

	private static final long serialVersionUID = -606552122265069150L;
	private ServletConfig config;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAuthentication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config)
			throws ServletException{
		this.config=config;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String connectionURL = "jdbc:mysql://localhost/bdcondominio";
		Connection connection=null;
		ResultSet rs;
		String userName=new String("");
		String passwrd=new String("");
		response.setContentType("text/html");
		try {
			// Load the database driver
			Class.forName("com.mysql.jdbc.Driver");
			// Get a Connection to the database
			connection = DriverManager.getConnection(connectionURL, "root", "123456"); 
			//Add the data into the database
			String sql = "select CPF,senha from bdcondominio";
			Statement s = connection.createStatement();
			s.executeQuery (sql);
			rs = s.getResultSet();
			while (rs.next ()){
				userName=rs.getString("CPF");
				passwrd=rs.getString("senha");
			}
			rs.close ();
			s.close ();
		}catch(Exception e){
			System.out.println("Exception is ;"+e);
		}
		if(userName.equals(request.getParameter("login"))
				&& passwrd.equals(request.getParameter("senha"))){
			out.println("WELCOME "+userName);
		}
		else{
			out.println("Please enter correct username and password");
			out.println("<a href='AuthenticLogin.jsp'><br>Login again</a>");
		}
	}

}


