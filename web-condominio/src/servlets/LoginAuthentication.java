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
			//senha criptografada vai para uma coluna especÃ­fica no SQL
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
			if(userName.equals(request.getParameter("login")) && passwrd.equals(senhaDigitada) &&
					tipoUsuario == 0){
				/*
				 * out.println("<html>");
				out.println("<head>");
				out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
				out.println("<title>Dados a serem cadastrados</title>");
				out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/menu-estilo.css\">");
				out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"libs/bootstrap-3.3.7-dist/css/bootstrap.css\">");
				out.println("<style>");
				out.println(".row{");
				out.println("text-align: center;");
				out.println("margin-top: 5%;");
				out.println("}");
				out.println(".masthead {");
				out.println("background-color: @brand-primary;");
				out.println("}");
				out.println("#menu-wrapper{"
						+ "margin-top: 8%;"
						+ "color: white;"
						+ "text-align: center;"
						+ "}");
				out.println("</style>");
				out.println("</head>");
				out.println("<body>");
				out.println("<div id=\"wrapper\">");
				out.println("<div id=\"menu-wrapper\">");
				out.println("<div id=\"menu\">");
				out.println("<ul>");
				out.println("<li><h2>Bem-Vindo(a) "+nomeUsuario+"!<h2></li>");
				out.println("</ul>");
				out.println("</div>");
				out.println("</div>");
				out.println("</div>");
				out.println("<div class=\"row\">");
				out.println("<div class=\"col-lg-8 col-lg-offset-2\">");
				out.println("<a href=\"JSP_TelaMorador.jsp\" class=\"btn btn-default\" >Clique aqui para ser redirecionado a pagina de funções de MORADOR</a>");
				out.println("</div>");
				out.println("</div>");
				out.println("<script type=\"text/javascript\">");
				out.println("history.forward()");
				out.println("</script>");
				out.println("</body>");
				out.println("</html>");*/
				
				request.setAttribute("Morador_Sindico", nomeUsuario);
				
				RequestDispatcher rd = request.getRequestDispatcher("JSP_TelaMorador.jsp");
				rd.forward(request, response);
				
			}else if (userName.equals(request.getParameter("login")) && passwrd.equals(senhaDigitada) &&
					tipoUsuario == 1){
				/*
				 * out.println("<html>");
				out.println("<head>");
				out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
				out.println("<title>Dados a serem cadastrados</title>");
				out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/menu-estilo.css\">");
				out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"libs/bootstrap-3.3.7-dist/css/bootstrap.css\">");
				out.println("<style>");
				out.println(".row{");
				out.println("text-align: center;");
				out.println("margin-top: 5%;");
				out.println("}");
				out.println(".masthead {");
				out.println("background-color: @brand-primary;");
				out.println("}");
				out.println("#menu-wrapper{"
						+ "margin-top: 8%;"
						+ "color: white;"
						+ "text-align: center;"
						+ "}");
				out.println("</style>");
				out.println("</head>");
				out.println("<body>");
				out.println("<div id=\"wrapper\">");
				out.println("<div id=\"menu-wrapper\">");
				out.println("<div id=\"menu\">");
				out.println("<ul>");
				out.println("<li><h2>Bem-Vindo(a) "+nomeUsuario+"!<h2></li>");
				out.println("</ul>");
				out.println("</div>");
				out.println("</div>");
				out.println("</div>");
				out.println("<div class=\"row\">");
				out.println("<div class=\"col-lg-8 col-lg-offset-2\">");
				out.println("<a href=\"JSP_TelaAdmin.jsp\" class=\"btn btn-default\" >Clique aqui para ser redirecionado a pagina de funções de ADMINISTRADOR</a>");
				out.println("</div>");
				out.println("</div>");
				out.println("<script type=\"text/javascript\">");
				out.println("history.forward()");
				out.println("</script>");
				out.println("</body>");
				out.println("</html>");
				*/
				request.setAttribute("Morador_Sindico", nomeUsuario);
				
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


