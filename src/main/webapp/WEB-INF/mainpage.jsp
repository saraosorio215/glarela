<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page</title>
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
        <a href="#">SERVICES</a>
        <a href="#">COURSES</a>
        <a href="#">BOOK APPOINTMENT</a>
        <a href="#">CONTACT</a>
        <a href="/dashboard">MY ACCOUNT</a>
    </div>


    <!--* Slideshow container -->
    <div class="slideshow-container">
        <!--* Full-width images with number and caption text -->
        <div class="mySlides fade">
            <img src="images/brows2.PNG" style="width:100%">
            <div class="text">Brows</div>
        </div>

        <div class="mySlides fade">
            <img src="images/lashlift2.PNG" style="width:100%">
            <div class="text">Lash Lift</div>
        </div>

        <div class="mySlides fade">
            <img src="images/lashset1.PNG" style="width:100%">
            <div class="text">Lash Set</div>
        </div>

        <div class="mySlides fade">
            <img src="images/lashset2.PNG" style="width:100%">
            <div class="text">Lash Set</div>
        </div>

        <!--* Next and previous buttons -->
        <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
        <a class="next" onclick="plusSlides(1)">&#10095;</a>
    </div>
    <br>

    <!--*The dots/circles -->
    <div style="text-align:center">
        <span class="dot" onclick="currentSlide(1)"></span>
        <span class="dot" onclick="currentSlide(2)"></span>
        <span class="dot" onclick="currentSlide(3)"></span>
        <span class="dot" onclick="currentSlide(4)"></span>
    </div>


    <script src="script.js"></script>
</body>
</html>