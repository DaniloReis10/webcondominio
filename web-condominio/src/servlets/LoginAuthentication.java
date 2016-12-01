/**Esta Servlet Ã© responsÃ¡vel por Autenticar o login digitado e redirecionar
 * para a pÃ¡gina com as funÃ§Ãµes de Morador ou de Administrador.
 * Pagina com as funÃ§Ãµes de Morador: JSP_TelaMorador
 * Pagina com as funÃ§Ãµes de Admin.:  JSP_TelaAdmin*/

package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

import model.CadastroCondominosDados;

/**
 * Servlet implementation class LoginAuthentication
 */
@WebServlet("/LoginAuthentication")
public class LoginAuthentication extends HttpServlet {

	private static final long serialVersionUID = -606552122265069150L;

	public LoginAuthentication() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String connectionURL = "jdbc:mysql://sql3.freemysqlhosting.net/sql3147054";
		Connection connection=null;
		ResultSet rs;
		String userName=new String("");
		String passwrd=new String("");
		String nome_Usuario = new String("");
		int tipoUsuario = 0;
		
		CadastroCondominosDados cadastro_condominos = new CadastroCondominosDados();
		
		response.setContentType("text/html");
		
		try {
			//CRIPTOGRAFAR A SENHA
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(request.getParameter("Morador_Senha_Hash").getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
			  hexString.append(String.format("%02X", 0xFF & b));
			}
			
			//senha digitada pelo usuario Ã© criptografada, para ser comparada 
			//com a senha que estÃ¡ no banco (que tambÃ©m Ã© criptografada).
			String senhaDigitada = hexString.toString();
			
			// Load the database driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Get a Connection to the database
			connection = DriverManager.getConnection(connectionURL, "sql3147054", "FtGgfm3IC6"); 
			
			//fazendo a busca dos dados para saber em qual pÃ¡gina o login serÃ¡ direcionado
			String sql = "select CPF,Morador_Senha_Hash,Morador_Nome,Morador_Sindico from tbl_morador";
			
			Statement s = connection.createStatement();
			s.executeQuery (sql);
			rs = s.getResultSet();
			
			while (rs.next ()){
				userName=rs.getString("CPF");
				passwrd=rs.getString("Morador_Senha_Hash");
				tipoUsuario = rs.getInt("Morador_Sindico");
				nome_Usuario = rs.getString("Morador_Nome");
				cadastro_condominos.setMorador_Nome(nome_Usuario);
				
				//condiÃ§ao de parada da pesquisa dentro do banco de dados
				if(userName.equals(request.getParameter("login")) && passwrd.equals(senhaDigitada) &&
				   tipoUsuario == 0 || userName.equals(request.getParameter("login")) && passwrd.equals(senhaDigitada) &&
				   tipoUsuario == 1){
					
					break;
					
				}
				
			}
			rs.close ();
			s.close ();
			
			//VerificaÃ§Ã£o dos dados do Banco de dados com os dados digitados pelos usuarios
			/*O que diz que ele Ã© admin ou nÃ£o Ã© o sindico. Se ele for sindico (tiver um valor = zero)
			 * entÃ£o nÃ£o Ã© admin. Se for 1 ele Ã© admin*/
			if(userName.equals(request.getParameter("login")) && passwrd.equals(senhaDigitada) &&
					tipoUsuario == 0){
				
				//usando getSession, para que o nome do usuario (admin ou morador) permaneÃ§a em todas
				//as paginas que correspondem ao tipo de login
				request.getSession().setAttribute("nomeUsuario", nome_Usuario);
				
				//request.setAttribute("nomeUsuario", nome_Usuario);
				
				RequestDispatcher rd = request.getRequestDispatcher("JSP_TelaMorador.jsp");
				rd.forward(request, response);
				
			}else if (userName.equals(request.getParameter("login")) && passwrd.equals(senhaDigitada) &&
					tipoUsuario == 1){
				
				request.getSession().setAttribute("nomeUsuario", nome_Usuario);
				
				RequestDispatcher rd = request.getRequestDispatcher("JSP_TelaAdmin.jsp");
				rd.forward(request, response);
				
				
			}else{
				
				out.println("Por favor, informe o login a senha corretos<br>");
				
				out.println("<a href='AuthenticLogin.jsp'><br>Tente novamente</a>");
				
			}
			
		}catch(Exception e){
			System.out.println("Exception is ;"+e);
			out.println("Erro => "+e);
			e.printStackTrace();
		}
		
	}

}
