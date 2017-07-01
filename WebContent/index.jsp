<%@page import="com.gmail.islaianemaia.entidades.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>tela de benvindo</title>
</head>
<body bgcolor="orange">

<c:import url="includes/manu.jsp"></c:import>

 <h1>Seja Bem vindo</h1>

<%
 Usuario  usu = (Usuario) session.getAttribute("usuLogado");
out.print(usu.getNome());
%>

</body>
</html>