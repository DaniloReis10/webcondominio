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
 * Classe responsável por Manter as Despesas, ou seja, exibe as despesas já cadastradas,
 * exibe as opções de editar, excluir e criar nova Despesa.
 * 
 * @author Caio Ponte
 * 
 * */
@WebServlet(value="/despesa")
public class ManterDespesaServlet extends HttpServlet {

	private static final long serialVersionUID = -2893067383364745045L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			DespesaDao dao = new DespesaDao();
			List<Despesa> despesas = dao.listar(); // listar todas as despesas
			
			// redecionar para a view responsável mostrar "manter despesa"
			RequestDispatcher rd = request.getRequestDispatcher("cadastro-despesa.jsp");
			request.setAttribute("despesas", despesas);
			rd.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
