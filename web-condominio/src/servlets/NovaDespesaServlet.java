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

import dao.FornecedorDao;
import dao.PeriodicidadeDao;
import dao.TipoDespesaDao;
import model.Fornecedor;
import model.Periodicidade;
import model.TipoDespesa;

@WebServlet(value="/nova-despesa")
public class NovaDespesaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 8551857249275063093L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			FornecedorDao fDao = new FornecedorDao();
			TipoDespesaDao tdDao = new TipoDespesaDao();
			PeriodicidadeDao pDao = new PeriodicidadeDao();
			
			List<Fornecedor> fornecedores = fDao.listar();
			List<TipoDespesa> tipos = tdDao.listar();
			List<Periodicidade> periodicidades = pDao.listar();
			
			RequestDispatcher rd = request.getRequestDispatcher("cadastro-despesa-novo.jsp");
			
			request.setAttribute("fornecedores", fornecedores);
			request.setAttribute("tipos", tipos);
			request.setAttribute("periodicidades", periodicidades);
			
			rd.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
