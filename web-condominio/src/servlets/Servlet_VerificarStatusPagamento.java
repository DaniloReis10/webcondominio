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
 * Servlet implementation class Servlet_VerificarStatusPagamento
 */
@WebServlet("/Servlet_VerificarStatusPagamento")
public class Servlet_VerificarStatusPagamento extends HttpServlet {

	private static final long serialVersionUID = 7815225520107622410L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_VerificarStatusPagamento() {
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

			String mes = request.getParameter("mes");
			String fk_CPF = request.getParameter("fk_CPF");
			//Conversao do formato da dataVencimento digitada pelo usuario
			SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");
			Date vencimento = formato2.parse(request.getParameter("vencimento"));
			java.sql.Date dateSql2 = new java.sql.Date(vencimento.getTime());
			String pagEfetuado = request.getParameter("pagEfetuado");
			//Conversao do formato da dataPagamento digitada pelo usuario
			SimpleDateFormat formato3 = new SimpleDateFormat("yyyy-MM-dd");
			Date dataPagamento = formato3.parse(request.getParameter("dataPagamento"));
			java.sql.Date dateSql3 = new java.sql.Date(dataPagamento.getTime());
			String boletoURL = request.getParameter("boletoURL");

			CadastroCondominosFinanceiro cadastro_condominos_financeiro = new CadastroCondominosFinanceiro();

			cadastro_condominos_financeiro.setMes(mes);
			cadastro_condominos_financeiro.setFk_CPF(fk_CPF);
			cadastro_condominos_financeiro.setVencimento(dateSql2);
			cadastro_condominos_financeiro.setPagEfetuado(pagEfetuado);
			cadastro_condominos_financeiro.setDataPagamento(dateSql3);
			cadastro_condominos_financeiro.setBoletoURL(boletoURL);

			Dao_CadastroCondominosFinanceiro daoFinanceiro = new Dao_CadastroCondominosFinanceiro();

			try {
				
				daoFinanceiro.salvar(cadastro_condominos_financeiro);

				SimpleDateFormat dataImpressao = new SimpleDateFormat("dd-MM-yyy");

				
				request.setAttribute("cadastro_condominos_financeiro", cadastro_condominos_financeiro);

				RequestDispatcher rd2 = request.getRequestDispatcher("JSP_EmitirConsultarBoleto_e_StatusPagamento.jsp");
				rd2.forward(request, response);


			} catch (SQLException e) {
				out.println("<h1>Erro no cadastro. Volte a página e tente novamente.</h1>");
				e.printStackTrace();
			}

		} catch (ParseException e1) {
			PrintWriter out = null;
			out.println("<h1>Erro no cadastro. Volte a página e tente novamente.</h1>");
			e1.printStackTrace();
		}
	}

}

