<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="model.CadastroCondominosDados" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dados a serem cadastrados</title>
<link rel="stylesheet" type="text/css" href="css/menu-estilo.css">
<link rel="stylesheet" type="text/css" href="libs/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<%
	
	/**
	
	String CPF = request.getParameter("CPF");
	String Morador_Nome = request.getParameter("Morador_Nome");
	String Morador_Email = request.getParameter("Morador_Email");
	String Morador_DataNascimento = request.getParameter("Morador_DataNascimento");
	String Morador_Sindico = request.getParameter("TipoMorador");
	String Morador_Telefone = request.getParameter("Morador_Telefone");
	String senha = request.getParameter("Morador_Senha");
	
	*/
	
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
      <th>Data de nascimento</th>
      <th>É Sindico</th>
      <th>Telefone</th>
      <th>Tipo de Morador</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>${param.CPF}</td>
      <td>${param.Morador_Nome}</td>
      <td>${param.Morador_Email}</td>
      <td>${param.Morador_DataNascimento}</td>
      <td>${param.Morador_Sindico}</td>
      <td>${param.Morador_Telefone}</td>
      <td>${param.Tipo_morador_idTipo_morador}</td>
    </tr>
  </tbody>
</table>
<br>

<a class="btn btn-primary btn-lg" href="JSP_TelaAdmin.jsp" role="button">Voltar a tela de Admin</a>
<a class="btn btn-primary btn-lg" href="cadastroCondominos.jsp" role="button">Alterar Dados</a>

</body>
</html>
