<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dados a serem cadastrados</title>
<link rel="stylesheet" type="text/css" href="css/menu-estilo.css">
<link rel="stylesheet" type="text/css" href="libs/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<%
	String CPF = request.getParameter("CPF");
	String Morador_Nome = request.getParameter("Morador_Nome");
	String Morador_Email = request.getParameter("Morador_Email");
	String Morador_DataNascimento = request.getParameter("Morador_DataNascimento");
	String Morador_Sindico = request.getParameter("TipoMorador");
	String Morador_Telefone = request.getParameter("Morador_Telefone");
	String senha = request.getParameter("Morador_Senha");
	
%>
<body>
<h1>Dados cadastrados:</h1>
<br><br>	
<table border="1" class="table table-striped">
  <thead>
    <tr>
      <th>CPF</th>
      <th>Nome</th>
      <th>Email</th>
      <th>Data de Nascimento</th>
      <th>É sindico?</th>
      <th>Telefone</th>
      <th>Senha</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><%= CPF %></td>
      <td><%= Morador_Nome %></td>
      <td><%= Morador_Email %></td>
      <td><%= Morador_DataNascimento %></td>
      <td><%= Morador_Sindico %></td>
      <td><%= Morador_Telefone %></td>
      <td><%= senha %></td>
    </tr>
  </tbody>
</table>
<br>

<input id="concluirCadastro" class="btn" type="submit" onclick="botaoConcluirCadastro" value="Concluir Cadastro" name="limparCampos"/>
<input id="alterarDados" class="btn" type="button" onclick="alterarDados()" value="Alterar dados" name="alterarDados" action="cadastroCondominos.html" />

<script src="http://code.jquery.com/jquery-latest.js"></script>

		<script src="js/bootstrap.min.js"></script>
		<script type="text/javascript">
			function alterarDados(){
				windows.history.back();
			}
			
			function botaoConcluirCadastro(){
				if (confirm('Concluir cadastro?')) {
					alert('Cadastro realizado com sucesso');
				} else {
					
				}
			}
		
		</script>
</body>
</html>