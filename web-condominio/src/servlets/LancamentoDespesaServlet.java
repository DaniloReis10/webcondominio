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
 * Classe respnsável por passar os dados de despesa para a a view que irá montar a 
 * tela de lançamento de despesa.
 * 
 * @author Caio Ponte
 * 
 * */
@WebServlet(value="/lancamento")
public class LancamentoDespesaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1569958828877359683L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			DespesaDao dao = new DespesaDao();
			List<Despesa> despesas = dao.listar();
			RequestDispatcher rd = request.getRequestDispatcher("lancamento-despesa.jsp");
			request.setAttribute("despesas", despesas);
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
