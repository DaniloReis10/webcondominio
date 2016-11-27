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
 * Servlet implementation class SalvarDadosCadastrados
 */
@WebServlet("/ServletSalvarDadosCadastrados")
public class ServletSalvarDadosCadastrados extends HttpServlet {

	private static final long serialVersionUID = 4387309538907569220L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletSalvarDadosCadastrados() {
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


			CadastroCondominosDao dao = new CadastroCondominosDao();

			try {
				dao.salvar(cadastro_condominos);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ParseException e1) {

			e1.printStackTrace();
		}
	}

}
