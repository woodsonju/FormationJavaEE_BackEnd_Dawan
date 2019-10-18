<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student</title>
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<div class="container col-md-10 col-xs-12 col-sm-12s col-md-offset-1 spacer">
		<div class="panel panel-primary">
			<div class="panel-heading">Confirmation</div>
			<div class="panel-body">
				<div class="form-group">
					<label>Name :</label>
					<label>${student.name}</label>
				</div>
				<div class="form-group">
					<label>Age :</label>
					<label>${student.age}</label>
				</div>
				<div class="form-group">
					<label>Faculty :</label>
					<label>${student.faculty}</label>
				</div>
			</div>
		</div>
	</div>
</body>
</html>