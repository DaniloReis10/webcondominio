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
 * Servlet usado para tratar informa��es vindas da pagina "JSP_AlterarDadosCadastrados.jsp".
 * Esta classe � usada exclusivamente pelo moradr logado como usuario ao inv�s de
 * logado como admin
 */
@WebServlet("/Servlet_Altera�aoDados_TelaMorador")
public class Servlet_Altera�aoDados_TelaMorador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_Altera�aoDados_TelaMorador() {
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
	
	/**
	* processamento do metodo service 
	* @request objeto requisicao do http
	* @responce objeto de retorno do http
	* @return nenhum
	*/
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//DADOS DA Pagina "cadastroMoradores.jsp (Dados Pessoais Moradores)"
		String CPF = request.getParameter("cpfTelaMorador_alerar");
		String Morador_Email = request.getParameter("emailTelaMorador_alerarl");			
		String Morador_Telefone = request.getParameter("telefoneTelaMorador_alerar");
		String Tipo_morador_idTipo_morador = request.getParameter("Tipo_morador_idTipo_morador");


		CadastroCondominosDao dao = new CadastroCondominosDao();

		try {
			
			if(Morador_Email!=null){
				dao.alterarMorador_Email(Morador_Email, CPF);
				request.setAttribute("email", Morador_Email);
			}
			if(Morador_Telefone!=null){
				dao.alterarMorador_Telefone(Morador_Telefone, CPF);
				request.setAttribute("telefone", Morador_Telefone);
			}
			
			if(Tipo_morador_idTipo_morador!=null){
				dao.alterarTipo_morador_idTipo_morador(Tipo_morador_idTipo_morador, CPF);
				request.setAttribute("Tipo_morador_idTipo_morador", Tipo_morador_idTipo_morador);
			}
			
			if(CPF!=null || Morador_Email!=null || Morador_Telefone!=null
					|| Tipo_morador_idTipo_morador!=null){
				out.print("<h1>Dado(s) alterado(s) com sucesso </h1>!!!");
				out.print("<a href=\"JSP_TelaMorador.jsp\">Voltar</a>!!!");
			}

			RequestDispatcher rd = request.getRequestDispatcher("JSP_ExibirDadosAlteradosTelaMorador.jsp");
			rd.forward(request, response);


		} catch (SQLException e) {
			out.println("<h1>Erro no cadastro. Volte a página e tente novamente.</h1>");
			e.printStackTrace();
		}
	}
}


