<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dao.Dao_CadastroCondominosFinanceiro"%>
<%@page import="dao.CadastroCondominosDao"%>
<%@page import="dao.ConnectionFactory"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	String obj = (String) request.getSession().getAttribute("cpf");
	String obj2 = (String) request.getSession().getAttribute("nomeUsuario");
	CadastroCondominosDao alterar = new CadastroCondominosDao();

%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
<link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<style type="text/css">
#thTag{

text-align: right;
padding-right: 2%;

}
#tabela{
	
}
</style>
</head>
<body>
	
	<jsp:include page="JSP_TelaMorador.jsp" />
	<h3>Alterar Dados</h3>
	<div class="row">
		<div class="col-lg-8 col-lg-offset-1">
			<div class="container">
	<div id="tabela" class="table-responsive">
	<form name="cadastroCondominos" method="POST" action="Servlet_AlteraçaoDados_TelaMorador" class="form-horizontal">
<table id="minhaTabela" class="display table" width="100%" border="1" >
  <thead>
    <tr>
      <th id="thTag">Digite acima o nome do dado a ser alterado</th>      
    </tr>
  </thead>
  <tbody>
    <tr>
    	<td><div class="control-group">
				<div class="controls">
				CPF
					<input id="inputCPF" type="text" value="<%out.println(obj); %>" name="cpfTelaMorador_alerar" placeholder="Somente números" pattern="[0-9]{11}" required autofocus />
				</div>
		</td>
    </tr>
    <tr>
    	<td>
    		<div class="controls">
				Nome
					<input id="inputCPF" type="text" value="<%out.println(obj2); %> name="nomeTelaMorador_alerar" placeholder="Nome Completo" required autofocus />
				</div>
    	</td>
    </tr>
    <tr>
    	<td>
    		<div class="controls">
    			Email
				<input id="inputMorador_Email" type="email" name="emailTelaMorador_alerarl"
					placeholder="Digite o email" required autofocus />
			</div>
    	</td>
    </tr>
    
    <tr>
    	<td>
    		<div class="controls">
    		Telefone
							<input id="inputMorador_Telefone" type="text"
								name="telefoneTelaMorador_alerar" placeholder="Format: xxxx-xxxx"
								pattern="{9}" required autofocus />
			</div>
    	
    	</td>
    
   	</tr>
   	
   	<!-- <tr>
   		<td>
   		
   		</td>
   	</tr> -->
   
  </tbody>
</table>
<div class="control-group">
			<div class="controls">
				<input id="cadastrar" class="btn" type="submit" value="Cadastrar" name="cadastrar" /> 
				<input id="limpar" class="btn" type="reset" value="Limpar Campos" name="limparCampos" />
			</div>

</div>
</form>
</div>
</div>
</div>
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
