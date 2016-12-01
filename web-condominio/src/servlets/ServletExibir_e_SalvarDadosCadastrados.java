/**Este Servlet Ã© responsÃ¡vel por salvar as informaÃ§Ãµes dos moradores 
 * que sÃ£o cadastradas e depois redirecionar estas informaÃ§Ãµes para serem
 * exibidas por uma pÃ¡gina jsp de nome "cadastroCondominosDadosExibidos.jsp"*/

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CadastroCondominosDados;
import model.CadastroCondominosFinanceiro;
import dao.CadastroCondominosDao;
import dao.Dao_CadastroCondominosFinanceiro;

/**
 * Servlet implementation class SalvarDadosCadastrados
 */
@WebServlet("/ServletExibir_e_SalvarDadosCadastrados")
public class ServletExibir_e_SalvarDadosCadastrados extends HttpServlet {

	private static final long serialVersionUID = 4387309538907569220L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletExibir_e_SalvarDadosCadastrados() {
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
		try{

			PrintWriter out = response.getWriter();
			//DADOS DA Pagina "cadastroMoradores.jsp (Dados Pessoais Moradores)"
			String CPF = request.getParameter("CPF");
			String Morador_Nome = request.getParameter("Morador_Nome");
			String Morador_Email = request.getParameter("Morador_Email");
			
			//request.setAttribute("morador_DataNascimento", request.getParameter("Morador_DataNascimento"));
			//Conversao do formato da data digitada pelo usuario
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Date Morador_DataNascimento = formato.parse(request.getParameter("Morador_DataNascimento"));
			java.sql.Date dateSql = new java.sql.Date(Morador_DataNascimento.getTime());
			
			int Morador_Sindico = Integer.parseInt(request.getParameter("Morador_Sindico"));
			String Morador_Telefone = request.getParameter("Morador_Telefone");
			String Tipo_morador_idTipo_morador = request.getParameter("Tipo_morador_idTipo_morador");
			
			//CRIPTOGRAFAR A SENHA
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(request.getParameter("Morador_Senha_Hash").getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
			  hexString.append(String.format("%02X", 0xFF & b));
			}
			
			//senha criptografada vai para uma coluna especÃƒÆ’Ã‚Â­fica no SQL
			String Morador_Senha_Hash = hexString.toString();
			
			CadastroCondominosDados cadastro_condominos = new CadastroCondominosDados();
			cadastro_condominos.setCPF(CPF);
			cadastro_condominos.setMorador_Nome(Morador_Nome);
			cadastro_condominos.setMorador_Email(Morador_Email);
			cadastro_condominos.setMorador_DataNascimento(dateSql);
			cadastro_condominos.setMorador_Sindico(Morador_Sindico);
			cadastro_condominos.setMorador_Telefone(Morador_Telefone);
			cadastro_condominos.setTipo_morador_idTipo_morador(Tipo_morador_idTipo_morador);
			cadastro_condominos.setMorador_Senha_Hash(Morador_Senha_Hash);

			CadastroCondominosDao dao = new CadastroCondominosDao();
			
			try {
				dao.salvar(cadastro_condominos);
				
				SimpleDateFormat dataImpressao = new SimpleDateFormat("dd-MM-yyy");
				
				request.setAttribute("cadastro_condominos", cadastro_condominos);
				
				RequestDispatcher rd = request.getRequestDispatcher("cadastroCondominosDadosExibidos.jsp");
				rd.forward(request, response);
				
				
			} catch (SQLException e) {
				out.println("<h1>Erro no cadastro. Volte a página e tente novamente.</h1>");
				e.printStackTrace();
			}

		} catch (ParseException e1) {
			PrintWriter out = null;
			out.println("<h1>Erro no cadastro. Volte a página e tente novamente.</h1>");
			e1.printStackTrace();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
