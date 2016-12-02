<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% String cpf = (String) request.getSession().getAttribute("cpf"); 
String email = (String) request.getAttribute("email");
String telefone = (String) request.getAttribute("telefone");
String Tipo_morador_idTipo_morador = (String) request.getAttribute("Tipo_morador_idTipo_morador");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Morador</title>
</head>
<body>
	<% out.print(cpf+"\n"+email+"\n"+telefone+"\n"+Tipo_morador_idTipo_morador); %>
	<jsp:include page="JSP_TelaMorador.jsp" />
	
</body>
</html>