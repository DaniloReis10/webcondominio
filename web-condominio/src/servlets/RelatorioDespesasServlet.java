package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LancamentoDao;
import model.DespesaViewModel;
import model.Lancamento;

/**
 * Servlet implementation class relatorio_despesas
 */
@WebServlet("/RelatorioDespesasServlet")
public class RelatorioDespesasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelatorioDespesasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LancamentoDao dao = new LancamentoDao();
		
		List<Lancamento> despesas = null;
		try {
			despesas = dao.listar();
		} catch (SQLException e) {
			System.out.println("Erro ao tentar acessar lista de despesas");
		}
		request.setAttribute("lancamentos", despesas);
		
		RequestDispatcher rd = request.getRequestDispatcher("views/relatorioDespesas.jsp");
				
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
