<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body{
	background-image: url("resources/img/whitespace2.jpg");
}
</style>
<title>Personel View</title>
</head>
<body>
<h1 style="text-align:center">Approved Forms</h1>
<table style="width:100%">
<c:forEach items="${ApprovedForms}" var="f">
<tr>
<th><c:out value="${f.username}"/></th>
<th><c:out value="${f.street}"/></th>
<th><c:out value="${f.city}"/></th>
<th><c:out value="${f.state}"/></th>
<th><c:out value="${f.type}"/></th>
</c:forEach>
</table>
</body>
</html>