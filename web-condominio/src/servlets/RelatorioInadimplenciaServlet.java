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

import dao.Dao_CadastroCondominosFinanceiro;
import model.CadastroCondominosFinanceiro;

/**
 * Servlet implementation class RelatorioInadimplenciaServlet
 */
@WebServlet("/RelatorioInadimplenciaServlet")
public class RelatorioInadimplenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelatorioInadimplenciaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Dao_CadastroCondominosFinanceiro dao = new Dao_CadastroCondominosFinanceiro();
		
		List<CadastroCondominosFinanceiro> condominos = new ArrayList<CadastroCondominosFinanceiro>();
		try {
			condominos = dao.listarDadosMoradores_Financeiro();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<CadastroCondominosFinanceiro> retorno = new ArrayList<CadastroCondominosFinanceiro>();
		
		for (CadastroCondominosFinanceiro cond : condominos) {
			if(cond.getPagEfetuado().toLowerCase().equals("sim")){
				retorno.add(cond);
			}
		}
		
		request.setAttribute("inadimplentes", retorno);
		
		RequestDispatcher rd = request.getRequestDispatcher("views/relatorioInadimplencia.jsp");
				
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
