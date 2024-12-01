<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
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
	<div class="registrationcontainer ">
		<h1 class="regcontainer-divh1">Registration</h1>
		<hr>
		<!-- Horizontal line below the heading -->

		<!-- Registration form -->
		<form action="registration" method="post">
			<table>
				<tr>
					<td>UserName:</td>
					<td><input type="text" name="userName"
						placeholder="Enter your username" required></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"
						placeholder="Enter your password" required></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email"
						placeholder="Enter your email" required></td>
				</tr>
				<tr>
					<td>Mobile Number:</td>
					<td><input type="text" name="mobileNumber"
						placeholder="Enter your mobile number" required></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Register"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
