package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.Dao_CadastroCondominosFinanceiro;
import model.CadastroCondominosFinanceiro;
import model.InadimplenciaViewModel;

/**
 * Servlet implementation class RelatorioInadimplenciaAjaxServlet
 */
@WebServlet("/RelatorioInadimplenciaAjax")
public class RelatorioInadimplenciaAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelatorioInadimplenciaAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		
		Dao_CadastroCondominosFinanceiro dao = new Dao_CadastroCondominosFinanceiro();
		
		List<CadastroCondominosFinanceiro> condominos = new ArrayList<CadastroCondominosFinanceiro>();
		try {
			condominos = dao.listarDadosMoradores_Financeiro();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<InadimplenciaViewModel> retorno = new ArrayList<InadimplenciaViewModel>();
		
		for (CadastroCondominosFinanceiro cond : condominos) {
			if(cond.getPagEfetuado().toLowerCase().equals("sim")){
				retorno.add(new InadimplenciaViewModel(cond.getMes()));
			}
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(retorno);		
		
		PrintWriter out = response.getWriter();
		
		out.print(json);
		out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
