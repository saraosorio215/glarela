<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Product</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<h1>New Product</h1>
	<br />
	<form:form action="/create/product/" method="post" modelAttribute="newProduct">
		<form:label path="productName">Product Name:</form:label>
		<form:errors path="productName"/>
		<form:input path="productName"/>
		<br />
		<br />
		<form:label path="productPrice">Product Price:</form:label>
		<form:errors path="productPrice"/>
		<form:input path="productPrice"/>
				<br />
		<br />
		<form:label path="description">Product Description:</form:label>
		<form:errors path="description"/>
		<form:input path="description"/>
		<input type="submit" value="Create">
	</form:form>
</body>
</html>