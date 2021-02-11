<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    


<head>
<!-- <link href="<c:url value="/resources/css/LoginForm.css" />" rel="stylesheet"> -->
<spring:url value="/resources/css/LoginForm.css" var="loginFormCss"/>
<link href="${loginFormCss}" rel="stylesheet"/>

</head>
<body>
<h2>Σύστημα Άδειας Μετακίνησης</h2>
	<div class="login-page">
		<div class="form">
			<div class="card-header">
				<h3>Sign In</h3>
			</div>
			
			
        <form:form action="${pageContext.request.contextPath}/authUser" method="POST">
        <c:if test="${param.error != null}">
                <i>Sorry! Invalid user_name/password!</i>
        </c:if>        
                        <label>User Name</label>
                        <input type="text" name="username"/> 
                        <label>Password</label>
                        <input type="password" name="password"/>
              
                <button type="submit" value="Login">Login</button>
                
        </form:form>
        <form action="signup" method="GET">
          
        <button class="btn" type="submit">Sign Up</button>
        </form> 
                    
  				</div>
			</div>

</body>