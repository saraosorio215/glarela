<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Products</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="header">
        <div class="side-bar">
            <div id="main">
                <button class="openbtn" onclick="openNav()"><img src="images/hamburgericon.png" alt="icon" id="icon"></button>
            </div>
        </div>
        <div class="mainlogo">
            <a href="/"><img src="images/image0.jpeg" alt="logo" id="mainlogo"></a>
        </div>
        <div class="nav-bar">
	        <c:if test="${user_id == null}">
	            <p>| <a href="/register">REGISTER</a> | <a href="/login">LOGIN</a> |
	        </c:if>
	        <c:if test="${user_id != null}">
	        	<p>| <a href="/dashboard">MY ACCOUNT</a> | <a href="/logout/">LOGOUT</a> |
	        </c:if>
            <img src="images/searchicon.jpg" alt="search" id="navicon">
            <img src="images/shoppingcart.png" alt="cart" id="navicon"></p>
        </div>
    </div>
    <div id="mySidebar" class="sidebar">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="/">HOME</a>
        <a href="/products">PRODUCTS</a>
        <a href="+">SERVICES</a>
        <a href="#">COURSES</a>
        <a href="#">BOOK APPOINTMENT</a>
        <a href="#">CONTACT</a>
        <a href="/dashboard">MY ACCOUNT</a>
    </div>
    <h1 class="center spacing">PRODUCTS</h1>
    <h3 class="subtitle">LASH SPOOLIES</h3>
    <div class="flex sp-btw">
    	<c:forEach items="${allProducts}" var="prod">
    		<a href="/products/${prod.id}/"><div class="product padding center">
            	<img src="${prod.getProductImages().get(0).getFilePath()}" alt="black spoolie" onmouseover="this.src='${prod.getProductImages().get(1).getFilePath()}'" onmouseout="this.src='${prod.getProductImages().get(0).getFilePath()}'" id="products">
            <h4 class="marg-bottom-10"><c:out value="${prod.productName}"/></h4>
            <p>$<c:out value="${prod.productPrice}"/></p>
        	</div></a>
    	</c:forEach>
    </div>

</body>
</html>