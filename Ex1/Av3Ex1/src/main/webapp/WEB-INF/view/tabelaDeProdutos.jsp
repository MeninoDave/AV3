<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList,models.Produtos"%>
<c:url value="/homepage" var="Autenticador"/>  

<table style="width:100%">
  <tr>
    <th>Produto</th>
    <th>Valor</th>
    <th>Estado</th>
    <th>Dias</th>
    <th>Frete</th>
    <th>Total</th>
  </tr>
  
  
    <c:forEach items="${lista}" var="produto">
    	<tr>
    		<td>${produto.produto}</td>
    		<td>${produto.valor}</td>
    		<td>${produto.estado}</td>
    		<td>${produto.dias}</td>
    		<td>${produto.frete}</td>
    		<td>${produto.total}</td>
    	</tr>
    </c:forEach>
  
</table>