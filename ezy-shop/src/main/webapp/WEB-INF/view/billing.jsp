<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
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

	<!-- Top Navigation Bar with Logout and Cart links -->
	<div class="top-nav">
		<a href="logout">Logout</a> <b>Billing</b> <b>${user.getUserName()}</b>
	</div>

	<br>
	<br>

	<!-- Table displaying items in the cart -->
	<table class="itemtable">
		<thead>
			<tr class="itemtable-thead-tr">
				<th class="itemtable-thead-th">Items</th>
				<th class="itemtable-thead-th">Cost</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="it" items="${items}">
				<tr class="itemtable-tbody-tr">
					<td class="itemtable-tbody-td">${it.getItemName() }</td>
					<td class="itemtable-tbody-td">${it.getItemCost() }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<!-- Total price -->
	<h1 class="pricing-h1">Total price: Rs. ${total}</h1>

	<!-- Buy Now button -->
	<div align="center">
		<a href="placeorder" class="placeorder">Place Order</a>
	</div>
</body>
</html>
