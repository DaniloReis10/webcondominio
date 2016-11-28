package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.*;
import java.security.MessageDigest;
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
		String nomeUsuario = "";
		int tipoUsuario = 0;
		
		response.setContentType("text/html");
		
		
		try {
			
			//CRIPTOGRAFAR A SENHA
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(request.getParameter("Morador_Senha_Hash").getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
			  hexString.append(String.format("%02X", 0xFF & b));
			}
			//senha criptografada vai para uma coluna específica no SQL
			String senhaDigitada = hexString.toString();
			
			// Load the database driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Get a Connection to the database
			connection = DriverManager.getConnection(connectionURL, "root", "123456"); 
			
			//Add the data into the database
			String sql = "select CPF,Morador_Senha_Hash,Morador_Nome,Morador_Sindico from morador";
			Statement s = connection.createStatement();
			s.executeQuery (sql);
			rs = s.getResultSet();
			
			while (rs.next ()){
				userName=rs.getString("CPF");
				passwrd=rs.getString("Morador_Senha_Hash");
				tipoUsuario = rs.getInt("Morador_Sindico");
				nomeUsuario = rs.getString("Morador_Nome");
				
				//condiçao de parada da pesquisa dentro do banco de dados
				if(userName.equals(request.getParameter("login")) && passwrd.equals(senhaDigitada) &&
				   tipoUsuario == 0 || userName.equals(request.getParameter("login")) && passwrd.equals(senhaDigitada) &&
				   tipoUsuario == 1){
					
					break;
					
				}
				
			}
			rs.close ();
			s.close ();
			
			//Verificação dos dados do Banco de dados com os dados digitados pelos usuarios
			if(userName.equals(request.getParameter("login")) && passwrd.equals(senhaDigitada) &&
					tipoUsuario == 0){
				
				out.println("BemVindo "+nomeUsuario+"!");
				
				
			}else if (userName.equals(request.getParameter("login")) && passwrd.equals(senhaDigitada) &&
					tipoUsuario == 1){
				out.println("Bem-Vindo administrador "+nomeUsuario+"!");
				
				
			}else{
				
				out.println("Por favor, informe o login a senha corretos<br>");
				out.println("Senha digitada: "+senhaDigitada);
				out.println("<br>"+passwrd);
				out.println("<a href='AuthenticLogin.jsp'><br>Tente novamente</a>");
				
			}
			
		}catch(Exception e){
			System.out.println("Exception is ;"+e);
			out.println("Erro => "+e);
			e.printStackTrace();
		}
		
	}

}


