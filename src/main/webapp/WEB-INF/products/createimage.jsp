<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Product Image</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<h1>New Product Image</h1>
	<br />
	<form:form action="/create/image/" method="post" modelAttribute="newImage">
		<form:label path="name">Product Image Name:</form:label>
		<form:errors path="name"/>
		<form:input path="name"/>
		<br />
		<br />
		<form:label path="filePath">File Path:</form:label>
		<form:errors path="filePath"/>
		<form:input path="filePath"/>
		<input type="submit" value="Create">
	</form:form>
</body>
</html>