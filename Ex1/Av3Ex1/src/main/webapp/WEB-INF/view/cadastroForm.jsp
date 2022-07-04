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
	
	<h1>Novo Usuario</h1>
	<form action="${Autenticador}" method="post">
	
		Usuario: <input type="text" name="usuario"  />
		Senha: <input type="password" name="senha"  />
		
		<input type="hidden" name="action" value="NovoUser">
		<input type="submit"/>
	</form>
	
</body>
</html>