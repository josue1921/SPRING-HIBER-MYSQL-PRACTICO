<%@include file="include.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<%@include file="libStyles/libs.jsp" %>	
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">
						<h5 class="card-title text-center">Sign In</h5>
						<form:form id="loginForm" method="post" action="login" modelAttribute="loginBean" class="form-signin">
							<div class="form-label-group">
								<input type="text" id="username" name="username" class="form-control" placeholder="Username" required path="" />
								<label for="username">Username</label>
							</div>
							<div class="form-label-group">
								<input type="password" id="password" name="password" class="form-control" placeholder="Password" required path="" />
								<label for="password">Password</label>
							</div>
							<hr class="my-4">
							<button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sing in</button>
							<hr class="my-4">
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>