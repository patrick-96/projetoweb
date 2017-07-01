<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> cadastro de Usuario em JSTL</title>
</head>
<body bgcolor="silver">
 
 	
 	
	<c:import url="includes/manu.jsp"></c:import>
 	<h1>Cadastro de Usuario</h1>
 	
 	

	<form action="usucontroler" method="post" >
	
	
	
		<label>ID:</label>
		<input type="text" readonly="readonly" name="txtid" value="${requestScope.usuario.id}" size="20">
		<p>
		<label>Nome:</label>
		<input type="text" name="txtnome" value="${requestScope.usuario.nome}" size="20"/>
		<p>
		<label>Login:</label>
		<input type="text" name="txtlogin" value="${requestScope.usuario.login}" size="20">
		<p>
		<label>Senha:</label>
		<input type="password" name="txtsenha" value="${requestScope.usuario.senha}" maxlength="10">
		
		<input type="submit" value="Salvar">
	
	</form>

</body>
</html>