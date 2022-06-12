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
                <button class="openbtn" onclick="openNav()"><img src="/images/hamburgericon.png" alt="icon" id="icon"></button>
            </div>
        </div>
        <div class="mainlogo">
            <a href="/"><img src="/images/image0.jpeg" alt="logo" id="mainlogo"></a>
        </div>
        <div class="nav-bar">
            <c:if test="${user_id == null}">
	            <p>| <a href="/register">REGISTER</a> | <a href="/login">LOGIN</a> |
	        </c:if>
	        <c:if test="${user_id != null}">
	        	<p>| <a href="/dashboard">MY ACCOUNT</a> | <a href="/logout/">LOGOUT</a> |
	        </c:if>
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
    <div class="flex sp-cent">
    <p><a href="/products" class="marg-bottom-10">BACK TO VIEW ALL</a></p>
        <div class="product-image marg-right">
            <div>
                <img src="/${product.getProductImages().get(0).getFilePath()}" alt="black spoolies" id="prod-image-l">
            </div>
            <div class="flex center sp-btw">
                <img src="/${product.getProductImages().get(0).getFilePath()}" alt="black spoolies" id="prod-image-s">
                <img src="/${product.getProductImages().get(1).getFilePath()}" alt="black spoolies" id="prod-image-s">
                <img src="/${product.getProductImages().get(2).getFilePath()}" alt="black spoolies" id="prod-image-s">
            </div>
        </div>
        <div class="product-options width">
            <h1 class="marg-bottom-10 marg-top">${product.productName}</h1>
            <h3 class="marg-bottom-10">$${product.productPrice}</h3>
            <input type="hidden" name="_method" value="put">
	            <select class="marg-bottom-10">
	                <option value="${products.get(0)}" label="BLACK"/>
	                <option value="${products.get(1)}" label="PINK"/>
	                <option value="${products.get(2)}" label="YELLOW"/>
	                <option value="${products.get(3)}" label="BLUE"/>
	            </select>
	            <br />
	            <select class="marg-bottom-10">
	                <option label="1" value="1"/>
	                <option label ="2" value="2"/>
	                <option label="3" value="3"/>
	                <option label="4" value="4"/>
	                <option label="5" value="5"/>
	            </select>
	            <br />
	            <button>ADD TO CART</button>
            <div class="marg-top">
                <h2 class="marg-bottom-10">DESCRIPTION</h2>
                <p>${product.description}</p>
            </div>
        </div>
    </div>
    <div>
    	<h2 class="center marg-top marg-bottom">YOU MAY ALSO LIKE</h2>
    	<div class="flex">
    		<c:forEach items="${products}" var="prod">
	    		<div>
	    			<p><c:out value="${prod.productName}"/></p>
	    			<p><img src="${prod.getProductImages().get(1).getFilePath()}" alt="product" id="small"></p>
	    			<p><c:out value="${prod.productPrice}"/></p>
	    		</div>
    		</c:forEach>
    	</div>
    </div>

</body>
</html>