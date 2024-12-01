
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>item insert jsp</title>
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

	<!-- User info message -->
	<div class="user-info">
		<h2>Item Added Successfully!</h2>
		<p>Add Item Again</p>
	</div>

	<!-- Page content container -->
	<div class="registrationcontainer">
		<h1 class="regcontainer-divh1">Add Item In Stock</h1>
		<hr>
		<!-- Horizontal line below the heading -->

		<!-- Item details form -->
		<form action="additem" method="post">
			<table>
				<tr>
					<td>Company Name:</td>
					<td><input type="text" name="itemBrand" required></td>
				</tr>
				<tr>
					<td>Item Name:</td>
					<td><input type="text" name="itemName" required></td>
				</tr>
				<tr>
					<td>Rupees:</td>
					<td><input type="number" name="itemCost" required></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Add Item"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
