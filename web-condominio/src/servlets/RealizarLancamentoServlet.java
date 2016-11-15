package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DespesaDao;
import dao.LancamentoDao;
import model.Despesa;
import model.Lancamento;

@WebServlet(value="/realizar-lancamento")
public class RealizarLancamentoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1569958828877359683L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String stringData = request.getParameter("data-lancamento");
			
			request.setAttribute("data", stringData);
			
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM");
			Date data = formato.parse(stringData);
			java.sql.Date dateSql = new java.sql.Date(data.getTime());
			
			DespesaDao dao = new DespesaDao();
			List<Despesa> despesas = dao.listar();
			
			Float soma = 0F;
			for (Despesa despesa : despesas) {
				
				String parametro = request.getParameter("despesa-" + despesa.getId());
				System.out.println(parametro);
				if(!parametro.equals("")){
					
					Float valor = Float.parseFloat(parametro);
					
					Lancamento item = new Lancamento();
					
					item.setData(dateSql);
					item.setDespesa(despesa);
					item.setValor(valor);
					
					LancamentoDao lDao = new LancamentoDao();
					lDao.salvar(item);
					
					soma = soma + valor;
				}
			}
			
			request.setAttribute("total", soma);
			
			RequestDispatcher rd = request.getRequestDispatcher("lancamento-sucesso.jsp");
			rd.forward(request, response);
			
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
	}
}
