<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users management</title>
</head>
<body>
<h2>List of Users</h2>
				
				<div class="card-body">
					<form:form action="users/hello" method="POST">
						<ul class="list-group">
							 <c:forEach items="${requestScope.Users}" var="u">
						     <input type="checkbox" id="delete" name="delete" value="${u.username}">				
                             <label for="delete"> 
                             <c:out value="${u.username}"/></label><br>
							</c:forEach>
                       	</ul>
                      <button class="btn" type="submit">Submit</button>
					</form:form>
				</div>
</body>
</html>