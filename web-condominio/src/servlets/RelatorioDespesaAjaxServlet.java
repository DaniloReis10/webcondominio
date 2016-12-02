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

import dao.LancamentoDao;
import model.DespesaViewModel;
import model.Lancamento;

/**
 * Servlet implementation class RelatorioDespesaAjaxServlet
 */
@WebServlet("/RelatorioDespesaAjaxServlet")
public class RelatorioDespesaAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelatorioDespesaAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		
		LancamentoDao dao = new LancamentoDao();
		
		List<DespesaViewModel> _despesas = new ArrayList<DespesaViewModel>();
		List<Lancamento> despesas = new ArrayList<Lancamento>();
		try {
			despesas = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Lancamento despesa : despesas) {
			_despesas.add(new DespesaViewModel(despesa.getValor(), this.getMes(despesa.getData().getMonth())));
		}
		
		
		Gson gson = new Gson();
		String json = gson.toJson(_despesas);		
		
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

	private String getMes(int mes){
		String[] meses = {"Janeiro", "Fevereiro", "Março", "Maio", "Abril", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
		return meses[mes];
	}
	
}
