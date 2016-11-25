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
		
		DespesaDao despesadao = new DespesaDao();
		
		List<Despesa> despesas = null;
		try {
			despesas = despesadao.listar();
		} catch (SQLException e) {
			System.out.println("Erro ao tentar acessar lista de despesas");
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("views/relatorioDespesas.jsp");
				
		rd.forward(request, response);
		
		response.getWriter().write("lalalalala");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
