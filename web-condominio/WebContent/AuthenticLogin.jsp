<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<title>Login Page</title>
	</head>
<body>
	<h1>
		Login <br>
	</h1>
	<form name=”frm” action=”/JSPMultipleForms/LoginAuthentication” method=”Post” onSubmit=”returnValidate()”>
		Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=”text”
			name=”login” value=”” /><br> Password:<input type=”password”
			name=”senha” value=”” /><br> <br>&nbsp;&nbsp;&nbsp;<input
			type=”submit” value=”Sign-In” /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
			type=”reset” value=”Reset” />
	</form>
	<script language=“Javascript”>
		function Validate(){
			var user=document.frm.login
			var pass=document.frm.senha 
			if ((user.value==null)||(user.value==””)){
				alert(“Please Enter user name”)
				user.focus()
				return false
			}
			if ((pass.value==null)||(pass.value==””)){
				alert(“Please Enter password”)
				pass.focus()
				return false
			}
		return true
		}
	</script>
</body>
</html>