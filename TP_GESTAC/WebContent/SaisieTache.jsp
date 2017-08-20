
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Saisie Tache</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="container col-md-8 col-md-offset-2 col-xs-12">
		<div class="panel panel-primary">
			<div class=" panel panel-heading">SAISIE TACHE</div>
			<div class="panel panel-body">
				<form action="SaveTache.do" method="post">

					<div class="form-group">
						<label class="control-label">Nom Tache:</label> <input type="text"
							name="nom" value="" class="form-control"
							required="required"> <span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Description:</label>
						<textarea class="form-control" rows="3" name="description"></textarea>
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
						<label class="control-label">Assigner tache a membre</label> 
						<select class="form-control" name="mem_fk">

							<c:forEach items="${model.membre}" var="m">
								<option value="${m.id}">${m.nom}</option>
							</c:forEach>
						</select>
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