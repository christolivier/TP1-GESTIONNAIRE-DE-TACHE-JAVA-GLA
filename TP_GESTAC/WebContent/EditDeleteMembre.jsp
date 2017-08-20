
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Membre</title>
<link rel="stylesheet" type="text/css"href="css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp" %>
<div  class="container col-md-8 col-md-offset-2">
	<div class="panel panel-primary">
		<div class=" panel panel-heading">MODIFIER OU SUPRIMER UN MEMBRE</div>
		<div class="panel panel-body">
			<form action="EditDeleteMembre.do" method="get">
				<label>Mot Clé</label>
				<input type="text"name='motCle' value="${model.motcle}">
				<button type="submit" class="btn btn-primary"> Chercher</button>
			</form>
			<table class="table table-striped">
				<tr>
					<th>ID</th><th>NOM MEMBRE</th>
				</tr>
				<c:forEach items="${model.membre}" var="m">
					<tr>
						<td>${m.id} </td>
						<td>${m.nom} </td>
						<td><a href="Modifier.do?id=${m.id}">Modifier</a> </td>
						<td><a onclick="return confirm('Etes vous sûre?')" href="Supprimer.do?id=${m.id}">Supprimer</a> </td>
					</tr>
				</c:forEach>
			</table>
		
		</div>
	</div>
</div>
</body>
</html>