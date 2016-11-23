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
	String nome = request.getParameter("nome");
	String cpf = request.getParameter("cpf");
	String data_nascimento = request.getParameter("data_nascimento");
	String data_cadastro = request.getParameter("data_cadastro");
	String email = request.getParameter("email");
	String senha = request.getParameter("senha");
	String fone_celular = request.getParameter("fone_celular");
	String fone_residencial = request.getParameter("fone_residencial");
%>
<body>
<h1>Dados cadastrados:</h1>
<br><br>	
<table border="1" class="table table-striped">
  <thead>
    <tr>
      <th>Nome</th>
      <th>CPF</th>
      <th>Data de Nascimento</th>
      <th>Data de Cadastro</th>
      <th>Email</th>
      <th>Senha</th>
      <th>Fone Celular</th>
      <th>Fone Residencial</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><%= nome %></td>
      <td><%= cpf %></td>
      <td><%= data_nascimento %></td>
      <td><%= data_cadastro %></td>
      <td><%= email %></td>
      <td><%= senha %></td>
      <td><%= fone_celular %></td>
      <td><%= fone_residencial %></td>
    </tr>
  </tbody>
</table>
<br>

<input id="concluirCadastro" class="btn" type="submit" value="Concluir Cadastro" name="limparCampos"/>
<input id="alterarDados" class="btn" type="submit" value="Alterar dados" name="alterarDados" action="cadastroCondominos.html" />

<script src="http://code.jquery.com/jquery-latest.js"></script>

		<script src="js/bootstrap.min.js"></script>
</body>
</html>