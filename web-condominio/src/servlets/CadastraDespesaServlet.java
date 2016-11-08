package servlets;

import java.io.IOException;
import java.sql.SQLException;

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

@WebServlet(value="/cadastrar-despesa")
public class CadastraDespesaServlet extends HttpServlet {

	private static final long serialVersionUID = -3628344266397227030L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String nome = request.getParameter("nomeDespesa");
			Integer idFornecedor = Integer.parseInt(request.getParameter("idFornecedor"));
			Integer idTipo = Integer.parseInt(request.getParameter("idTipo"));
			Integer idPeriodicidade = Integer.parseInt(request.getParameter("idPeriodicidade"));
			
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
			
			despesa.setNome(nome);
			despesa.setFornecedor(fornecedor);
			despesa.setTipo(tipo);
			despesa.setPeriodicidade(periodicidade);
			
			DespesaDao dao = new DespesaDao();
			
			try {
				dao.salvar(despesa);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
}
