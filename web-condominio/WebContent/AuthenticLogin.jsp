<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" %>
<html>
	<head>
		<title>Login</title>
		<link rel="stylesheet" type="text/css" href="css/menu-estilo.css">
		<link rel="stylesheet" type="text/css" href="libs/bootstrap-3.3.7-dist/css/bootstrap.css">
		
		<style>
			.row{
				margin-top: auto;
				
			}
			
			.masthead {
  				background-color: @brand-primary;
			}
		</style>
		<meta charset="utf-8">
	</head>
<body>
	
	<div class="row">
			<div class="col-lg-8 col-lg-offset-4">
				<h1>Condominio Morada da Lagoa</h1>
			</div>
			
		</div>		
		
		<div class="row">
			
			<div class="col-lg-9 col-lg-offset-5">
			 
			<form class="form-login" name="frm" action="LoginAuthentication" method="Post" onSubmit="returnValidate()">
			  <h3 class="form-login-heading">Login</h3>

			  <div class="control-group">
			    <label class="control-label" for="inputLogin">Login(Informe CPF)</label>
			    <div class="controls">
			      <input id="inputLogin" name="login" value="" placeholder="Sem os digitos" required autofocus />
			    </div>
			  </div>
			  
			  <div class="control-group">
			    <label class="control-label" for="inputSenha"><br>Senha</label>
			    <div class="controls">
			      <input id="inputSenha" type="password" name="senha" value="" placeholder="Digite a sua senha..." required autofocus />
			    </div>
			  </div>

			  <div class="control-group">
			    <div class="controls">
			      Lembrar senha <input type="checkbox" />
			      <br><br>	
			      <input id="acessar" class="btn btn-small btn-primary" type="submit" />
			      <input id="cancelar" class="btn btn-danger" type="reset" />
			      
			    </div>

			  </div>
			  
			</form>
			<br>
 			<a href="localhost:8080/web-condominio/cadastroCondominos.html" class="btn btn-default" >Novo Morador?<br>Realize seu cadastro</a>
			
		</div>
	</div>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	
	<script language=“Javascript” type="text/javascript">
		function Validate(){
			var user=document.frm.login
			var pass=document.frm.senha 
			if ((user.value==null)||(user.value=="")){
				alert("Por favor, informe o login")
				user.focus()
				return false
			}
			if ((pass.value==null)||(pass.value=="")){
				alert("Por favor, digite a senha")
				pass.focus()
				return false
			}
		return true
		}
	</script>
</body>
</html>