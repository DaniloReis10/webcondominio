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

import dao.LancamentoDao;
import model.Lancamento;

/**
 * Servlet implementation class relatorioMes
 */
@WebServlet("/relatorioMes")
public class relatorioMes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public relatorioMes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		Integer idDespesa = Integer.parseInt(request.getParameter("id"));
	
		LancamentoDao lancamentoDao = new LancamentoDao();
		
			
			try {
				List<Lancamento> lancamentos = lancamentoDao.lancamentoPorDespesa(idDespesa);
			
				RequestDispatcher rd = request.getRequestDispatcher("graficoDespesa.jsp");
				request.setAttribute("lancamentos", lancamentos);
				rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   
	
	}

}
