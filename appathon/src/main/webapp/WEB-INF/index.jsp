<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: auto;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<body>
<h2>Hello ${greeting}</h2>
<c:if test="${not empty districts}">
<label for="Districts">District:</label>
<select name="District" id="Districts">
	<c:forEach items="${districts}" var="district"> 
	<option value="${district}">${district}</option>
	</c:forEach>
</select>
</c:if>
</body>
</html>