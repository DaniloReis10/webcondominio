package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DespesaDao;
import model.Despesa;
import model.Fornecedor;
import model.Periodicidade;
import model.TipoDespesa;

/*
 * Classe respnsável por realiza a edição do registro no DB a partir dos
 * dados recebidos da view de tela de edição de despesa.
 * 
 * @author Caio Ponte
 * 
 * */
@WebServlet(value="/editar-despesa")
public class EditarDespesaServlet extends HttpServlet {

	private static final long serialVersionUID = -3628344266397227030L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer idDespesa = Integer.parseInt(request.getParameter("idDespesa"));

		String nome = request.getParameter("nomeDespesa");
		Integer idFornecedor = Integer.parseInt(request.getParameter("idFornecedor"));
		Integer idTipo = Integer.parseInt(request.getParameter("idTipo"));
		Integer idPeriodicidade = Integer.parseInt(request.getParameter("idPeriodicidade"));
		
		System.out.println(idDespesa);
		System.out.println(nome);
		System.out.println(idFornecedor);
		System.out.println(idTipo);
		System.out.println(idPeriodicidade);
		System.out.println();
		
		Despesa despesa = new Despesa();
		Fornecedor fornecedor = new Fornecedor();
		TipoDespesa tipo = new TipoDespesa();
		Periodicidade periodicidade = new Periodicidade();
					
		fornecedor.setId(idFornecedor);
		tipo.setId(idTipo);
		periodicidade.setId(idPeriodicidade);
		
		despesa.setId(idDespesa);
		despesa.setNome(nome);
		despesa.setFornecedor(fornecedor);
		despesa.setTipo(tipo);
		despesa.setPeriodicidade(periodicidade);
		
		DespesaDao dao = new DespesaDao();
		
		try {
			dao.alterar(despesa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("despesa", despesa);
		
		RequestDispatcher rd = request.getRequestDispatcher("nova-despesa-sucesso.jsp");
		rd.forward(request, response);

	}
}