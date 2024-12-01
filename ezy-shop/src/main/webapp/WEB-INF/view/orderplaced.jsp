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
	<div class="orderplaced-successcontainer">
		<h1 class="orderplaced-h1">Hurrey! Order Placed Successfully</h1>
		<p>Your order is placed. You will receive your delivery within 2
			days.</p>

		<!-- Continue Shopping Button -->
		<div align="center">
			<a href="continueshopping" class="btn-continue">Continue Shopping</a>
		</div>

		<!-- Username displayed at the bottom-right -->
		<div class="username">${user.getUserName()}</div>
	</div>


	<!-- Footer section -->
	<footer>
		<p align="center">
			<b>: Developed By Mohd Zaid :</b>
		</p>
	</footer>

</body>
</html>
