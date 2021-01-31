<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
    
<!DOCTYPE html>
<html>
<head>
<spring:url value="/resources/css/choicepage.css" var="choicepageCss"/>
<link href="${choicepageCss}" rel="stylesheet"/>
<style>

body{
	background-image: url('resources/img/books.jpg');
	
}
</style>
<title>Conclusion</title>
</head>
<body>
<h1>Welcome to Movement Permit System!</h1>
<h5>What action do you want to do?</h5> 
<sec:authorize access="hasAnyRole('EMPLOYEE','HEAD')">
<div class="center">
<a href="menu" class="button">Create a Permit Form</a>
</div>
</sec:authorize>
<br>
<sec:authorize access="hasAnyRole('DIRECTOR','HEAD')">
<div class="center">
<a href="d" class="button">Approve a Form</a>
</div>
</sec:authorize>
<br>
<sec:authorize access="hasRole('PERSONEL')">
<div class="center">
<a href="p" class="button">View Approved Forms</a>
</div>
</sec:authorize>
</body>
</html>