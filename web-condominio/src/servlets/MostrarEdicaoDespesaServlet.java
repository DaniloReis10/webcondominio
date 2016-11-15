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
import dao.FornecedorDao;
import dao.PeriodicidadeDao;
import dao.TipoDespesaDao;
import model.Despesa;
import model.Fornecedor;
import model.Periodicidade;
import model.TipoDespesa;

@WebServlet(value="/tela-edicao-despesa")
public class MostrarEdicaoDespesaServlet extends HttpServlet {

	private static final long serialVersionUID = -3628344266397227030L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idDespesa = Integer.parseInt(request.getParameter("id"));
		
		System.out.println("editar" + idDespesa);
		System.out.println();
		
		DespesaDao dDao = new DespesaDao();
		FornecedorDao fDao = new FornecedorDao();
		TipoDespesaDao tDao = new TipoDespesaDao();
		PeriodicidadeDao pDao = new PeriodicidadeDao();
		
		try {
			Despesa despesa = dDao.despesaPorId(idDespesa);
			
			List<Fornecedor> fornecedores = fDao.listar();
			List<TipoDespesa> tipos = tDao.listar();
			List<Periodicidade> periodicidades = pDao.listar();
			
			RequestDispatcher rd = request.getRequestDispatcher("cadastro-despesa-editar.jsp");
			
			request.setAttribute("despesa", despesa);
			
			request.setAttribute("fornecedores", fornecedores);
			request.setAttribute("tipos", tipos);
			request.setAttribute("periodicidades", periodicidades);
			
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}