package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CadastroCondominosDados;
import dao.CadastroCondominosDao;

/**
 * Servlet implementation class Servlet_EmitirConsultarBoleto_e_StatusPagamento
 */
@WebServlet("/Servlet_AlteraçaoDados_TelaMorador")
public class Servlet_AlteraçaoDados_TelaMorador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_AlteraçaoDados_TelaMorador() {
		super();
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//DADOS DA Pagina "cadastroMoradores.jsp (Dados Pessoais Moradores)"
		String CPF = request.getParameter("cpfTelaMorador_alerar");
		String Morador_Nome = request.getParameter("nomeTelaMorador_alerar");
		String Morador_Email = request.getParameter("emailTelaMorador_alerarl");			
		String Morador_Telefone = request.getParameter("telefoneTelaMorador_alerar");


		CadastroCondominosDao dao = new CadastroCondominosDao();

		try {
			
			if(CPF!=null){
				dao.alterarCPF(CPF);
				//request.setAttribute("CPF", CPF);
			}
			if(Morador_Nome!=null){
				dao.alterarMorador_Nome(Morador_Nome, CPF);
				//request.setAttribute("nome", Morador_Nome);
			}
			if(Morador_Email!=null){
				dao.alterarMorador_Email(Morador_Email, CPF);
				//request.setAttribute("email", Morador_Email);
			}
			if(Morador_Telefone!=null){
				dao.alterarMorador_Telefone(Morador_Telefone, CPF);
				//request.setAttribute("telefone", Morador_Telefone);
			}
			
			if(CPF!=null || Morador_Nome!=null || Morador_Email!=null || Morador_Telefone!=null){
				out.print("<h1>Dado(s) alterado(s) com sucesso </h1>!!!");
				out.print("<a href=\"JSP_TelaMorador.jsp\">Voltar</a>!!!");
			}

			//RequestDispatcher rd = request.getRequestDispatcher("JSP_ExibirDadosAlterados.jspTelaMorador.jsp");
			//rd.forward(request, response);


		} catch (SQLException e) {
			out.println("<h1>Erro no cadastro. Volte a pÃ¡gina e tente novamente.</h1>");
			e.printStackTrace();
		}
	}
}


