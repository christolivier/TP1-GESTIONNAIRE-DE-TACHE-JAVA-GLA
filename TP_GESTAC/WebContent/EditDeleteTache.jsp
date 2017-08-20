
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tache</title>
<link rel="stylesheet" type="text/css"href="css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp" %>
<div  class="container col-md-8 col-md-offset-2">
	<div class="panel panel-primary">
		<div class=" panel panel-heading">MODIFIER OU SUPRIMER UNE TACHE</div>
		<div class="panel panel-body">
			<form action="EditDeleteTache.do" method="get">
				<label>Mot Clé</label>
				<input type="text"name='motCle' value="${model.motcletache}">
				<button type="submit" class="btn btn-primary"> Chercher</button>
			</form>
			<table class="table table-striped">
				<tr>
					<th>ID</th>
					<th>NOM TACHE</th>
					<th>STATUT</th>
					<th>ID MEMBRE</th>	
				</tr>
				<c:forEach items="${model.taches}" var="t">
					<tr>
						<td>${t.id} </td>
						<td>${t.nom} </td>
						<td>${t.statut} </td>
						<td>${t.mem_fk} </td>
						<td><a href="ModifierTache.do?id=${t.id}">Modifier</a> </td>
						<td><a onclick="return confirm('Etes vous sûre?')" href="SupprimerTache.do?id=${t.id}">Supprimer</a> </td>
					</tr>
				</c:forEach>
			</table>
		
		</div>
	</div>
</div> 
</body>
</html>