<%@page import="dao.CadastroCondominosDao"%>
<%@page import="dao.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%Object obj = request.getSession().getAttribute("nomeUsuario"); %>

<html>
<head>
<title>Admin - cadastroCondominos</title>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
<link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<style>
.row {
	margin-top: auto;
}

.masthead {
	background-color: @brand-primary;
}

h3{
	text-align: center;
}

#tabela{
	width: 88%;
	margin-left: 6%;
}

</style>
</head>
<body>
<jsp:include page="JSP_TelaAdmin.jsp"></jsp:include>
	<h3>Dados moradores</h3>
	<div id="tabela" class="table-responsive">
<% CadastroCondominosDao listarContatos = new CadastroCondominosDao();
	int tamanhoListaContatos = listarContatos.listarDadosMoradores().size();
	out.print("<table id=\"minhaTabela\" class=\"display table\" width=\"100%\" border=\"1\" > ");
	out.print("<thead>");
	out.print("<tr>");
	out.print("<th>CPF</th>");
	out.print("<th>Nome</th>");
	out.print("<th>Email</th>");
	out.print("<th>Data de nascimento</th>");
	out.print("<th>É Sindico</th>");
	out.print("<th>Telefone</th>");
	out.print("<th>Tipo de Morador</th>");
	out.print("</tr>");
	out.print("</thead>");
	out.print("<tbody>");
	
	for(int i = 0; i<listarContatos.listarDadosMoradores().size(); i++){
		
		out.print("<tr>");
		out.print("<td width=\"5%\">"+listarContatos.listarDadosMoradores().get(i).getCPF()+"</td>");
		out.print("<td width=\"20%\">"+listarContatos.listarDadosMoradores().get(i).getMorador_Nome()+"</td>");
		out.print("<td width=\"15%\">"+listarContatos.listarDadosMoradores().get(i).getMorador_Email()+"</td>");
		out.print("<td width=\"8%\">"+listarContatos.listarDadosMoradores().get(i).getMorador_DataNascimento()+"</td>");
		out.print("<td width=\"7%\">"+listarContatos.listarDadosMoradores().get(i).getMorador_Sindico()+"</td>");
		out.print("<td width=\"7%\">"+listarContatos.listarDadosMoradores().get(i).getMorador_Telefone()+"</td>");
		out.print("<td width=\"8%\">"+listarContatos.listarDadosMoradores().get(i).getTipo_morador_idTipo_morador()+"</td>");
		out.print("</tr>");
		
	}

%>
</tbody>
</table>

</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
    $('#minhaTabela').dataTable();
});

</script>
</body>
</html>
