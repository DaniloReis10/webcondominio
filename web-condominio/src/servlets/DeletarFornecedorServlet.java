package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FornecedorDao;
import model.Fornecedor;

/**
 * Servlet implementation class DeletarFornecedor
 */
@WebServlet("/DeletarFornecedor")
public class DeletarFornecedorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet() baseAjaxServlet
     */
    public DeletarFornecedorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fornecedorId = Integer.parseInt(request.getParameter("id"));
		//int fornecedorId = Integer.parseInt(s)(request.getAttribute("id"));
		
		FornecedorDao fornecedorDao = new FornecedorDao();
		Fornecedor fornecedor;
		
		try {
			fornecedor = fornecedorDao.fornecedorPorId(fornecedorId);
			fornecedorDao.excluir(fornecedor);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/web-condominio/ListaFornecedor");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
