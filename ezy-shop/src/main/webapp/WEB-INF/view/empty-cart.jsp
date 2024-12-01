<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Success</title>
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

	<!-- Success Message Container -->
	<div class="emptycart-successcontainer">
		<h1 class="emptycart-h1">Your EzyShop Cart is empty!</h1>

		<!-- Continue Shopping Button -->
		<div align="center">
			<a href="continueshopping" class="btn-continue">Continue Shopping</a>
		</div>

		<!-- Username displayed at the bottom-right -->
		<div class="username">${user.getUserName()}</div>
	</div>

</body>
</html>
