<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<spring:url value="/resources/css/conclusionpage.css" var="conclusionpageCss"/>
<link href="${conclusionpageCss}" rel="stylesheet"/>
<style>
body{
	background-image: url('resources/img/books.jpg');
}
</style>
<title>Conclusion</title>
</head>
<body>
 
					<h2>List of Forms</h2>
				
				<div class="card-body">
					<form:form action="conclusion/hello" method="POST">
						<ul class="list-group">
							 <c:forEach items="${requestScope.forms}" var="f">
						     <input type="checkbox" id="approved" name="approved" value="${f.username}">				
                             <label for="approved"> 
                             <c:out value="${f.username}"/>
                             <c:out value="${f.street}"/>
                             <c:out value="${f.type}"/> </label><br>
							</c:forEach>
                       	</ul>
                      <button class="btn" type="submit">Submit</button>
					</form:form>
				</div>
				
			
</body>
</html>