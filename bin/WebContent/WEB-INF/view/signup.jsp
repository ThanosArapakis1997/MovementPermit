<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
</head>
<body>
<h3> Δημιουργία Χρήστη</h3>
<form:form action="/saveuser" method="POST">
 
<label>Create a username:</label>
<input type="text" name="username"/> <br>

<label>Create a Password</label>
<input type="password" name="password"/> <br>

<button class="btn" type="submit">Εγγραφή</button>

</form:form>
</body>
</html>