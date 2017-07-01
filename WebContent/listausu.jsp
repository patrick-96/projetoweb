<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listando com JSTL</title>


<script type="text/javascript">

function comfirmaExclusao(id){
	
	if(window.confirm("tem certeza que deseja excluir o registro "+id)){
	location.href="usucontroler?acao=excluir&id="+id;
	}
}

function comfirmaAltera(id){
	if(window.confirm("tem certeza que deseja excluir o registro"+id)){
		location.href="usucontroler?acao=alterar&id="+id;
	}
}
</script>
</head>
<body>

<c:import url="includes/manu.jsp"></c:import>
	<h1>Lista de Usuario</h1>
	
	<table border="2">
		<tr bgcolor="green">
			<th>ID</th> <th>Nome</th> <th>Ligin</th> <th>Senha</th> <th>Acao</th> 
		</tr>



<c:forEach items="${requestScope.lista}" var="u">	
	<tr>
		<td>${u.id}</td>
		<td>${u.nome}</td>
		<td>${u.login}</td>
		<td>${u.senha}</td>
		
		<td>
	
	    <a href="javascript:comfirmaExclusao(${u.id})">Excluir</a>
		|
		<a href="javascript:comfirmaAltera(${u.id})">Alterar</a>
		
		</td>
		
		
	</tr>
	
</c:forEach>

	</table>
</body>
</html>