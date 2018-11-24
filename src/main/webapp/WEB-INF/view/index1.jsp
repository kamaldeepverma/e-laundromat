<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>Laundro-Valley | home</title>

 <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
  <link rel="stylesheet" href="css/bootstrap.min.css">
 <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"> 

    <!-- Custom styles for this template -->
    <link href="css/simple-sidebar.css" rel="stylesheet">
</head>

<body>

<div role="navigation">
 		<div class="navbar navbar-inverse"> 
			<div>
			<a href="/index" class="navbar-brand">LaundroValley</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/login">Login</a></li>
					<li><a href="/register-student">New Registration</a></li>
				</ul>
			</div>
		</div>
	</div>
	</div>
<c:choose>

	<c:when test="${mode=='MODE_HOME' }">
		<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h1>Welcome to LaundroValley</h1>
					<h3>TagLine</h3>
				</div>
		</div>

	</c:when>
	
	<c:when test="${mode=='MODE_REGISTER' }">
		<div class="container text-center">
				<h3>New Registration</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="do-register-student">
					<div class="form-group">
						<label class="control-label col-md-3">ID</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="id"
								value="${stud.id }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="name"
								value="${stud.name }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">email</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="email"
								value="${stud.email }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Hostel </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="hostel"
								value="${stud.hostel }" />
						</div>
					</div>
					
				
					
					<div class="form-group">
						<label class="control-label col-md-3">roomNo </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="roomNo"
								value="${stud.roomNo }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">phone </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="phone"
								value="${stud.phone }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">session </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="session"
								value="${stud.session }" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">status </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="status"
								value="${stud.status }" />
						</div>
					
					</div>
					
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${stud.password }" />
						</div>
					</div>
					
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Register" />
					</div>
				</form>
			</div>

	</c:when>
	
	
	<c:when test="${mode=='MODE_LOGIN' }">
			<div class="container text-center">
				<h3>User Login</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/doLogin">
					<c:if test="${not empty error }">
						<div class= "alert alert-danger">
							<c:out value="${error }"></c:out>
							</div>
					</c:if>
					<div class="form-group">
						<label class="control-label col-md-3">ID</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="id"
								value="${user.id }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Login" />
					</div>
					</form>
					</div>
					</c:when>
</c:choose>

<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
 <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>	
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>