<%@page import="dao.Dao_CadastroCondominosFinanceiro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="model.CadastroCondominosFinanceiro" %>

<% String obj = (String) request.getSession().getAttribute("cpf"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="JSP_TelaMorador.jsp"></jsp:include>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dados Financeiros Cadastrados</title>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
<link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<style type="text/css">
h1{

text-align: center;

}
#tabela{
	width: 85%;
	margin-left: 6%
}
</style>
</head>
<%
	
Dao_CadastroCondominosFinanceiro cadastroFinanceiro = new Dao_CadastroCondominosFinanceiro();

;
	
%>
<body>

<h1>Boleto Cadastrado</h1>
<br><br>
<div id="tabela" class="table-responsive">
<table id="minhaTabela" class="display table" width="100%" border="1" >
  <thead>
    <tr>
      <th>Mes</th>
      <th>Vencimento</th>
      <th>Pagamento Efetuado</th>
      <th>Data do Pgamento</th>
      <th>Boleto URL</th>
    </tr>
  </thead>
  <tbody>
  <% for(int i = 0; i<cadastroFinanceiro.listarDadosMoradores_FinanceiroTelaMorador(obj).size(); i++) {%>
    <tr>
      <td><% out.println(cadastroFinanceiro.listarDadosMoradores_FinanceiroTelaMorador(obj).get(i).getMes()); %></td>
      <td><% out.println(cadastroFinanceiro.listarDadosMoradores_FinanceiroTelaMorador(obj).get(i).getVencimento());%> </td>
      <td><% out.println(cadastroFinanceiro.listarDadosMoradores_FinanceiroTelaMorador(obj).get(i).getPagEfetuado());%> </td>
      <td><% out.println(cadastroFinanceiro.listarDadosMoradores_FinanceiroTelaMorador(obj).get(i).getDataPagamento());%> </td>
      <td><a href=<% out.println(cadastroFinanceiro.listarDadosMoradores_FinanceiroTelaMorador(obj).get(i).getBoletoURL());%>> Boleto</a> <br> <a href=<% out.println(cadastroFinanceiro.listarDadosMoradores_FinanceiroTelaMorador(obj).get(0).getBoletoURL());%>> 2a Via</a></td>
    </tr>
    <% } %>
  </tbody>
</table>
</div>
<br>
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
