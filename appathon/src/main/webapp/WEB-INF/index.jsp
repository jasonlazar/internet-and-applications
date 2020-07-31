<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
<meta charset="UTF-8">
<title>Appathon</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
</head>
<body>
<h2>Hello ${greeting}</h2>
<form id="search-form">
<c:if test="${not empty districts}">
<label>Περιφέρεια:</label>
<select name="District" id="SelectDistrict">
	<option value="" disabled selected>ΠΕΡΙΦΕΡΕΙΑ</option>
	<c:forEach items="${districts}" var="district"> 
	<option value="${district}">${district}</option>
	</c:forEach>
</select>
<br>
<label>Δήμος:</label>
<select name="Municipality" id="SelectMunicipality">
	<option value="" disabled selected>ΔΗΜΟΣ</option>
</select>
<br>
<button type="submit" id="btn-search">Submit</button>
</c:if>
</form>
<div id="result"></div>
<script type="text/javascript" src="main.js"></script>
</body>
</html>