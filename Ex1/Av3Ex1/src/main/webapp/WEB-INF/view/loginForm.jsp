<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/homepage" var="Autenticador"/>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exercicio 1</title>
</head>
<body>

	<form action = "${Autenticador}" method = "post">
	
		Usuario: <input type="text" name = "username"/>
		Senha: <input type="password" name = "password"/>
		<input type="hidden" name="action" value="Login">
		<input type="submit"/>
	</form>
	<br>
	
	<button onclick="window.location.href='http://localhost:8080/Av3Ex1/homepage?action=DoNovoUser';">
      	Novo Usuario
    </button>

</body>
</html>