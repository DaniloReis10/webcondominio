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
import model.Endereco;
import model.Fornecedor;

/**
 * Servlet implementation class CadastroFornecedor
 */
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
		RequestDispatcher rd = request.getRequestDispatcher("views/cadastroFornecedor.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Opa!");
		String senha = request.getParameter("Senha");
		String confirmSenha = request.getParameter("ConfirmarSenha");
		
		if (!senha.equals(confirmSenha)) {
			request.setAttribute("mensagem", "Senhas são diferentes");
			this.doGet(request, response);
		}
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome(request.getParameter("NomeFornecedor"));
		fornecedor.setEmail(request.getParameter("Email"));
		fornecedor.setSenha(senha);
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro(request.getParameter("Logradouro"));
		endereco.setNumero(request.getParameter("Numero"));
		endereco.setCep(request.getParameter("Cep"));
		
		fornecedor.setEndereco(endereco);
		
		FornecedorDao fornecedorDao = new FornecedorDao();
		/*try {
			fornecedorDao.salvar(fornecedor);
		} catch (SQLException e) {
			request.setAttribute("mensagem", e.getMessage());
			this.doGet(request, response);
			e.printStackTrace();
		}*/
		
		RequestDispatcher rd = request.getRequestDispatcher("views/loginFornecedor.jsp");
		rd.forward(request, response);
		
		
	}

}
