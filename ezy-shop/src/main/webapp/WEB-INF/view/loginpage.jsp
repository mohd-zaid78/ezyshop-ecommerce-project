<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">

</head>
<body>

	<!-- Header section with silver background -->
	<header>
		<div class="top-div">
			<h1 class="top-div-h1">EzyShop</h1>
			<h5>live with good vibes</h5>
		</div>
	</header>
	<hr>

	<!-- Page content container -->
	<div class="registrationcontainer">
		<h1 class="regcontainer-divh1">Login Page</h1>
		<hr>
		<!-- Horizontal line below the heading -->

		<!-- Login form -->
		<form action="login" method="post">
			<table>
				<tr>
					<td>UserName:</td>
					<td><input type="text" name="userName" required></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Login"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
