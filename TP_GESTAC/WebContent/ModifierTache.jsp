
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
		<div class=" panel panel-heading">MODIFICATION DE LA TACHE </div>
		<div class="panel panel-body">
			<form action="UpdateTache.do" method="post">
			
				<div class="form-group">
					<label class="control-label">Id:</label>
					<input type="hidden" name="id" value="${tache.id }" class="form-control" required="required">
					<label>${tache.id }</label>
					<span></span>
				</div>
				<div class="form-group">
					<label class="control-label">Nom:</label>
					<input type="text" name="nom" value="${tache.nom }" class="form-control" required="required">
					<span></span>
				</div>
				
				<div class="form-group">
					<label class="control-label">Description:</label>
					<textarea class="form-control" rows="3" name="description" value="${tache.description }">${tache.description }</textarea>
					<span></span>
				</div>
				<div class="form-group">
						<label class="control-label">Statut:</label> 
						<select class="form-control" name="statut"value="statut" > 
						<option value=" nouveau"> nouveau</option>
						<option value=" en-progrès"> en-progrès</option>
						<option value=" terminé"> terminé</option>
						</select>		
						<span></span>
					</div>
				<div class="form-group">
					<label class="control-label">Membre:</label>
					<input type="hidden" name="mem_fk" value="${tache.mem_fk }" class="form-control" required="required">
					<label>${tache.mem_fk }</label>
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