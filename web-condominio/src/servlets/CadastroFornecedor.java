package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Endereco;
import model.Fornecedor;

/**
 * Servlet implementation class CadastroFornecedor
 a*/
@WebServlet("/CadastroFornecedor")
public class CadastroFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroFornecedor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("views/cadastroFornecedor.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome(request.getParameter("NomeFornecedor"));
		fornecedor.setEmail(request.getParameter("Email"));
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro(request.getParameter("Logradouro"));
		endereco.setNumero(request.getParameter("Numero"));
		endereco.setCep(request.getParameter("Cep"));
		
		fornecedor.setEndereco(endereco);
		
		RequestDispatcher rd = request.getRequestDispatcher("views/listaFornecedor.jsp");
		rd.forward(request, response);
		
	}

}
