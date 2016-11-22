package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FornecedorDao;
import model.Fornecedor;

/**
 * Servlet implementation class ListaFornecedorServlet
 */
@WebServlet("/ListaFornecedor")
public class ListaFornecedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListaFornecedorServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		FornecedorDao fornecedorDao = new FornecedorDao();
		List<Fornecedor> fornecedores = null;
		
		try {
			fornecedores = fornecedorDao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fornecedores = new ArrayList<Fornecedor>(Arrays.asList(new Fornecedor("Thiago"), new Fornecedor("Andre")));
			//e.printStackTrace();
		}

		request.setAttribute("fornecedores", fornecedores);

		RequestDispatcher rd = request.getRequestDispatcher("views/listaFornecedor.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
