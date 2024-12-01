<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage of App</title>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">

</head>
<body>

	<!-- Header section -->
	<header>
		<div class="top-div">
			<h1 class="top-div-h1">EzyShop</h1>
			<h5>live with good vibes</h5>
		</div>
	</header>

	<hr>

	<!-- Top Navigation Bar with Logout and Cart links -->
	<div class="top-nav">
		<a href="cart">Cart</a> <b>ITEMS</b> <a href="logout">Logout</a>
	</div>

	<h3 align="right">${user.getUserName()}</h3>


	<!-- Table displaying items -->
	<table class="itemtable">
		<thead>
			<tr class="itemtable-thead-tr">
				<th class="itemtable-thead-th">Items</th>
				<th class="itemtable-thead-th">Brand</th>
				<th class="itemtable-thead-th">Cost</th>
				<th class="itemtable-thead-th">Add to Cart</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty itemsList}">
				<tr class="itemtable-tbody-tr">
					<td class="itemtable-tbody-td" colspan="4" align="center">No
						items available.</td>
				</tr>
			</c:if>
			<c:forEach var="it" items="${itemsList}">
				<tr class="itemtable-tbody-tr">
					<td class="itemtable-tbody-td">${it.getItemName()}</td>
					<td class="itemtable-tbody-td">${it.getItemBrand()}</td>
					<td class="itemtable-tbody-td">${it.getItemCost()}</td>
					<td class="itemtable-tbody-td"><a
						href="/addtocart/${it.getItemId()}">Add</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
