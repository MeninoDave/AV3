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
<style>
table, th, td {
  border:1px solid black;
}
</style>
<body>
	<c:import url="cadastroDeProdutos.jsp" />
	<br>
	<c:import url="tabelaDeProdutos.jsp" />
	<br>
	<c:import url="logout.jsp" />
	<c:import url="reset.jsp" />
	<c:import url="getJson.jsp" />
</body>
</html>