<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/homepage" var="Autenticador"/> 

<fieldset>
	<legend>
		Cadastro de Produtos
	</legend>
	<form action="${Autenticador}" method="post">
		 Produto <input type="text" name= "produto"/> 
		 Preço <input type="number" step ="0.01" name = "preco"/>
		 Estado para entrega 
		<select name="estado">
		  <option value="AC">AC</option>
		  <option value="AL">AL</option>
		  <option value="AM">AM</option>
		  <option value="AP">AP</option>
		  <option value="BA">BA</option>
		  <option value="CE">CE</option>
		  <option value="DF">DF</option>
		  <option value="ES">ES</option>
		  <option value="GO">GO</option>
		  <option value="MA">MA</option>
		  <option value="MT">MT</option>
		  <option value="MS">MS</option>
		  <option value="MG">MG</option>
		  <option value="PA">PA</option>
		  <option value="PB">PB</option>
		  <option value="PR">PR</option>
		  <option value="PE">PE</option>
		  <option value="PI">PI</option>
		  <option value="RJ">RJ</option>
		  <option value="RN">RN</option>
		  <option value="RS">RS</option>
		  <option value="RO">RO</option>
		  <option value="RR">RR</option>
		  <option value="SC">SC</option>
		  <option value="SP">SP</option>
		  <option value="SE">SE</option>
		  <option value="TO">TO</option>
		</select>
		<input type="hidden" name="action" value="AddProduct">
		<input type="submit"/>
	</form>
	</fieldset>