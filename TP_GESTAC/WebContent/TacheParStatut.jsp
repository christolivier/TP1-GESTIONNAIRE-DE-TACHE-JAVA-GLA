
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
		<div class=" panel panel-heading">RECHERCHE TACHE EN FONCTION DU STATUT</div>
		<div class="panel panel-body">
			<form action="TacheStatut.do" method="get">
				<label class="control-label">Membre</label> 
						<select class="form-control" name="statut" > 
						<option value=" nouveau"> nouveau</option>
						<option value=" en-progres"> en-progrès</option>
						<option value=" termine"> terminé</option>
						</select>
				<button type="submit" class="btn btn-primary"> Chercher</button>
			</form>	
			<table class="table table-striped">
				<tr>
					<th>ID</th><th>NOM TACHE </th><th>MEMBRE</th>
				</tr>
				<c:forEach items="${model2.taches}" var="t">
					<tr>
						<td>${t.id} </td>
						<td>${t.nom} </td> 
						<td>${t.membre}</td> 
						<!--<td><a href="Modifier.do?id=${m.id}">Modifier</a> </td>
						<td><a onclick="return confirm('Etes vous sûre?')" href="Supprimer.do?id=${m.id}">Supprimer</a> </td>  -->
					</tr>
				</c:forEach>
			</table>
		
		</div>
	</div>
</div>
</body>
</html>