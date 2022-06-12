<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
<div class="header">
        <div class="side-bar">
            <div id="main">
                <button class="openbtn" onclick="openNav()"><img src="/images/hamburgericon.png" alt="icon" id="icon"></button>
            </div>
        </div>
        <div class="mainlogo">
            <a href="/"><img src="/images/image0.jpeg" alt="logo" id="mainlogo"></a>
        </div>
        <div class="nav-bar">
            <p>| <a href="/logout/">LOGOUT</a> |
            <img src="/images/searchicon.jpg" alt="search" id="navicon">
            <img src="/images/shoppingcart.png" alt="cart" id="navicon"></p>
        </div>
    </div>
    <div id="mySidebar" class="sidebar">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="/">HOME</a>
        <a href="/products">PRODUCTS</a>
        <a href="C:/Users/sahar/OneDrive/Desktop/Dojo_Assignments/Java/javaproject/services.html#">SERVICES</a>
        <a href="#">COURSES</a>
        <a href="#">BOOK APPOINTMENT</a>
        <a href="#">CONTACT</a>
        <a href="/dashboard">MY ACCOUNT</a>
    </div>
	<h1 class="center marg-bottom marg-top spacing">WELCOME, ${user.firstName.toUpperCase()}!</h1>
	<div class="flex sp-cent">
		<div class="marg-right">
			<div class="dash-box left-box">
				<h2 class="marg-bottom-10">MY ORDERS</h2>
				<c:if test="${userOrders == null}">
					<h3>No orders yet! <a href="/products">Check out our products!</a></h3>
				</c:if>
				<c:forEach items="${userOrders}" var="order">
					<ul>
						<li><c:out value="${order.id}"/></li>
						<li><c:out value="${order.createdAt}"/></li>
					</ul>
				</c:forEach>
			</div>
			<div class="dash-box left-box">
				<h2 class="marg-bottom-10">MY COURSES</h2>
			</div>
		</div>
		<div>
		<div class="dash-box right-box">
			<h2 class="marg-bottom-10">MY CART</h2>
			<c:if test="${currentCart == null}">
				<h3>Your cart is empty!</h3>
			</c:if>
			<c:forEach items="${currentCart.getProducts()}" var="prod">
				<ul>
					<li><c:out value="${prod.productName}"/></li>
					<li>$<c:out value="${prod.productPrice}"/></li>
				</ul>
			</c:forEach>
		</div>
		</div>
	</div>
</body>
</html>