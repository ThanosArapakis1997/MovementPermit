<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<head>
<spring:url value="/resources/css/formpage.css" var="formpageCss"/>
<link href="${formpageCss}" rel="stylesheet"/>
<style>
body{
	background-image: url("resources/img/whitespace2.jpg");
}
</style>
<title>Movement Permit Form</title>
</head>
<body>
<!-- <nav class="navbar navbar-light fixed-top"
        style="background-color: #e3f2fd;">
        <a class="navbar-brand" href="#">Movement Permit System
        </a>
        </nav> -->
    <div class="box">
    <form:form action="menu/thankyou" method="POST" class="ui form">
                        <p>What is your name?</p>
                        <label class="form-label">Name</label><br> 
				    	<input type="text" name="username" placeholder="Name" /> <br>
                        <p>Please select your Type of Permit:</p>
                        <input type="radio" id="DAY" name="Type" value="DAY">
                        <label for="DAY">DAY</label>
                        <input type="radio" id="WEEK" name="Type" value="WEEK">
                        <label for="WEEK">WEEK</label>
                        <input type="radio" id="EMERGENCY" name="Type" value="EMERGENCY">
                        <label for="EMERGENCY">EMERGENCY</label><br>                        
                        <p> Address of your house: </p>
						<label class="form-label">Street</label><br> 
				    	<input type="text" name="street" placeholder="street" /> <br><br>
						<label class="form-label">City</label><br> 
						<input type="text" name="city" placeholder="city"/> <br><br>
						<label class="form-label">State</label><br> 
						<input type="text" name="state" placeholder="state"/> <br><br>
						<label class="form-label">Postal Code</label><br> 
						<input type="text" name="postalcode" placeholder="postalcode"/> <br><br>
						<label class="form-label">Requirement Date</label><br> 						
						<input type="date" name="ReqDate" placeholder="ReqDate"/><br><br>
				        <button class="btn" type="submit">Submit</button>
				        
    </form:form>
    </div>
   </body>
</html>