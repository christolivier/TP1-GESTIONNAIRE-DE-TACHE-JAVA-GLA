<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saisie membre</title>
<link rel="stylesheet" type="text/css"href="css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp" %>
<div  class="container col-md-8 col-md-offset-2 col-xs-12">
	<div class="panel panel-primary">
		<div class=" panel panel-heading">SAISIE MEMBRE </div>
		<div class="panel panel-body">
			<form action="SaveMembre.do" method="post">
				<div class="form-group">
					<label class="control-label">Nom:</label>
					<input type="text" name="nom" value="" class="form-control" required="required">
					<span></span>
				</div>
				<div>
					<button type="submit" class="btn btn-primary">Save</button>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>