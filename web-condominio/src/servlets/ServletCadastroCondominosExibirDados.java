package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CadastroCondominosDados;
import dao.CadastroCondominosDao;

/**
 * Servlet implementation class ServletCadastroCondomino
 */
@WebServlet("/ServletCadastroCondominosExibirDados")
public class ServletCadastroCondominosExibirDados extends HttpServlet {

	private static final long serialVersionUID = 3353053274545243617L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCadastroCondominosExibirDados() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{
			
			PrintWriter out = response.getWriter();
			//String apertarBotaoConcluiCadastro = request.getParameter("apertarBotaoConcluiCadastro");
			String CPF = request.getParameter("CPF");
			String Morador_Nome = request.getParameter("Morador_Nome");
			String Morador_Email = request.getParameter("Morador_Email");
			
			//request.setAttribute("morador_DataNascimento", request.getParameter("Morador_DataNascimento"));
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Date Morador_DataNascimento = formato.parse(request.getParameter("Morador_DataNascimento"));
			java.sql.Date dateSql = new java.sql.Date(Morador_DataNascimento.getTime());
			
			int Morador_Sindico = Integer.parseInt(request.getParameter("Morador_Sindico"));
			String Morador_Telefone = request.getParameter("Morador_Telefone");
			String Tipo_morador_idTipo_morador = request.getParameter("Tipo_morador_idTipo_morador");
			String Morador_Senha = request.getParameter("Morador_Senha");

			CadastroCondominosDados cadastro_condominos = new CadastroCondominosDados();
			cadastro_condominos.setCPF(CPF);
			cadastro_condominos.setMorador_Nome(Morador_Nome);
			cadastro_condominos.setMorador_Email(Morador_Email);
			cadastro_condominos.setMorador_DataNascimento(dateSql);
			cadastro_condominos.setMorador_Sindico(Morador_Sindico);
			cadastro_condominos.setMorador_Telefone(Morador_Telefone);
			cadastro_condominos.setTipo_morador_idTipo_morador(Tipo_morador_idTipo_morador);
			cadastro_condominos.setSenha(Morador_Senha);
			
			SimpleDateFormat dataImpressao = new SimpleDateFormat("dd-MM-yyy");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
			out.println("<title>Dados a serem cadastrados</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/menu-estilo.css\">");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"libs/bootstrap-3.3.7-dist/css/bootstrap.css\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Dados cadastrados:</h1>");
			out.println("<br><br>");
			out.println("<table border=\"1\" class=\"table table-striped\">");
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th>CPF</th>");
			out.println("<th>Morador</th>");
			out.println("<th>Email</th>");
			out.println("<th>Data Nascimento</th>");
			out.println("<th>É sindico?</th>");
			out.println("<th>Telefone</th>");
			out.println("<th>Locatario ou Proprietario</th>");
			out.println("<th>Senha</th>");
			out.println("</th>");
			out.println("</thead>");
			out.println("<tbody>");
			out.println("<tbody>");
			out.println("<tr>");
			out.println("<td>"+CPF+"</td>");
			out.println("<td>"+Morador_Nome+"</td>");
			out.println("<td>"+Morador_Email+"</td>");
			out.println("<td>"+dataImpressao.format(Morador_DataNascimento)+"</td>");
			out.println("<td>"+Morador_Sindico+"</td>");
			out.println("<td>"+Morador_Telefone+"</td>");
			out.println("<td>"+Tipo_morador_idTipo_morador+"</td>");
			out.println("<td>"+Morador_Senha+"</td>");
			out.println("</tr>");
			out.println("</tbody>");
			out.println("</table>");
			out.println("<br>");
			out.println("<div class=\"control-group\">"
					+ "<div class=\"controls\">"
					+ "<input id=\"concluirCadastro\" class=\"btn\" type=\"submit\" action=\"botaoConcluirCadastro\" value=\"Concluir\" />"
					+ "<input id=\"alterarDados\" class=\"btn\" type=\"button\" onclick=\"alterarDados()\" value=\"Alterar dados\" name=\"alterarDados\" action=\"cadastroCondominos.html\" />"
					+ "</div>"
					+ "</div>"
					+ "<script src=\"http://code.jquery.com/jquery-latest.js\"></script>"
					+ "<script src=\"http://code.jquery.com/jquery-latest.js\"></script>"
					+ "<script src=\"js/bootstrap.min.js\"></script>"
					+ "<script type=\"text/javascript\">"
					+ "function alterarDados(){"
					+ "windows.history.back();"
					+ "}"
					+ "function botaoConcluirCadastro(){"
					+ "if (confirm('Concluir cadastro?')) {"
					+ "alert('Cadastro realizado com sucesso');"
					+ "} else {"
					+ "}"
					+ "}"
					+ "</script>");
			out.println("</body>");
			out.println("</html>");
			
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}

	}

}
