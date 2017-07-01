<%@page import="com.gmail.islaianemaia.entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuarios</title>
</head>
<body>

	<h1>Lista de Usuario</h1>
	
	<table border="2">
		<tr bgcolor="green">
			<th>ID</th> <th>Nome</th> <th>Ligin</th> <th>Senha</th> <th>Acao</th> 
		</tr>

<%
 List<Usuario> lista = (List<Usuario>)  request.getAttribute("lista");

	for(Usuario u: lista){
%>
	<tr>
		<td><% out.print(u.getId()); %></td>
		<td><% out.print(u.getNome()); %></td>
		<td><% out.print(u.getLogin()); %></td>
		<td><% out.print(u.getSenha()); %></td>
		
		<td>
	
	    <a href="usucontroler?acao=excluir&id=<% out.print(u.getId()); %>">Excluir</a>
		|
		<a href="usucontroler?acao=alterar&id=<% out.print(u.getId()); %>">Alterar</a>
		
		</td>
		
		
	</tr>
	
<%} %>

	</table>
</body>
</html>