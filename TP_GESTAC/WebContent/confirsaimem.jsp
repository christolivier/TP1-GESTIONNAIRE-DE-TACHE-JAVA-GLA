<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation saisie membre</title>
<link rel="stylesheet" type="text/css"href="css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp" %>
<div  class="container col-md-8 col-md-offset-2 col-xs-12">
	<div class="panel panel-primary">
		<div class=" panel panel-heading">CONFIRMATION DE SAISIE</div>
		<div class="panel panel-body">
			<div class=form-group>
				<label>ID:</label>
				<label>${membre.id }</label>
			</div>
			<div class=form-group>
				<label>NOM:</label>
				<label>${membre.nom }</label>
			</div>
		</div>
	</div>
</div>
</body>
</html>