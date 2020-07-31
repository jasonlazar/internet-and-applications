<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
<meta charset="UTF-8">
<title>Appathon</title>
<link rel="stylesheet" href="/site.css" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</head>
<body>
<h2>Αυτοδιοικητικές εκλογές 2014</h2>
<div class="form">
<form id="search-form">
<c:if test="${not empty districts}">
<div class="form-row">
<label>Περιφέρεια:</label>
<select name="District" id="SelectDistrict">
	<option value="" disabled selected>ΠΕΡΙΦΕΡΕΙΑ</option>
	<c:forEach items="${districts}" var="district"> 
	<option value="${district}">${district}</option>
	</c:forEach>
</select>
</div>
<div class="form-row">
<label>Δήμος:</label>
<select name="Municipality" id="SelectMunicipality">
	<option value="" disabled selected>ΔΗΜΟΣ</option>
</select>
</div>
<button type="submit" id="btn-search">Submit</button>
</c:if>
</form>
</div>
<div id="chartContainer"></div>
<script type="text/javascript" src="main.js"></script>
</body>
</html>