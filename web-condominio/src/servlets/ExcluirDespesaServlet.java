package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DespesaDao;
import model.Despesa;

/*
 * Classe respnsável por deletar um registro de despesa no BD a partir
 * de um id passado na request.
 * 
 * @author Caio Ponte
 * 
 * */
@WebServlet(value="/excluir-despesa")
public class ExcluirDespesaServlet extends HttpServlet {

	private static final long serialVersionUID = -3628344266397227030L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idDespesa = Integer.parseInt(request.getParameter("id"));

		Despesa despesa = new Despesa();
					
		despesa.setId(idDespesa);
		
		DespesaDao dao = new DespesaDao();
		
		List<Despesa> despesas = null;
		try {
			dao.excluir(despesa);
			despesas = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("despesas", despesas);
		
		RequestDispatcher rd = request.getRequestDispatcher("cadastro-despesa.jsp");
		rd.forward(request, response);

	}
}