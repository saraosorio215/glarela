<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Register</title>
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
            <p>| <a href="/register">REGISTER</a> | <a href="/login">LOGIN</a> |
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
	<h1 class="center marg-bottom">WELCOME TO GLARE</h1>
		<div class="center">
		<h2 class="marg-bottom-10">REGISTER</h2>
			<form:form action="/register/" method="post" modelAttribute="newUser">
				<form:label path="firstName">FIRST NAME: </form:label>
				<form:errors path="firstName"/>
				<form:input path="firstName"/>
				<br />
				<br />
				<form:label path="lastName">LAST NAME: </form:label>
				<form:errors path="lastName"/>
				<form:input path="lastName"/>
				<br />
				<br />
				<form:label path="email">EMAIL: </form:label>
				<form:errors path="email"/>
				<form:input path="email"/>
				<br />
				<br />
				<form:label path="password">PASSWORD: </form:label>
				<form:errors path="password"/>
				<form:input type="password" path="password"/>
				<br />
				<br />
				<form:label path="confirm">CONFIRM PW: </form:label>
				<form:errors path="confirm"/>
				<form:input type="password" path="confirm"/>
				<br />
				<br />
				<input type="submit" value="REGISTER">
			</form:form>
			<h3>ALREADY HAVE AN ACCOUNT? <a href="/login">CLICK HERE</a></h3>
		</div>
</body>
</html>