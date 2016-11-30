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
 * Classe responsável por tratar a inserção de novas despesas
 * 
 * @author Caio Ponte
 * 
 * */
@WebServlet(value="/cadastrar-despesa")
public class CadastraDespesaServlet extends HttpServlet {

	private static final long serialVersionUID = -3628344266397227030L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			// Pega todos os dados importantes
			String nome = request.getParameter("nomeDespesa");
			Integer idFornecedor = Integer.parseInt(request.getParameter("idFornecedor"));
			Integer idTipo = Integer.parseInt(request.getParameter("idTipo"));
			Integer idPeriodicidade = Integer.parseInt(request.getParameter("idPeriodicidade"));
			
			System.out.println(nome);
			System.out.println(idFornecedor);
			System.out.println(idTipo);
			System.out.println(idPeriodicidade);
			System.out.println();
			
			// Cria os objetos Model
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
			
			// Cria objeto de acesso ao banco de despesa
			DespesaDao dao = new DespesaDao();
			
			try {
				dao.salvar(despesa); // salva a despesa
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			// repassa a despesa salva
			request.setAttribute("despesa", despesa);
			
			// redireciona para um view de cadastro com sucesso
			RequestDispatcher rd = request.getRequestDispatcher("nova-despesa-sucesso.jsp");
			rd.forward(request, response);
	}
	
}