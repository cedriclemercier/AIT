<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style>
.error {
	color: #ff0000;
	font-weight: bold;
}
</style>
<meta charset="ISO-8859-1">
<title>Create</title>
</head>
<body>
	<h1>Create</h1>
	<form:form method="POST" modelAttribute="employee">
	<spring:bind path="id">
    			<div>
    			Create employee for a user
    				<form:input type="text" path="id" class="form-control"
    					placeholder="User ID" autofocus="true"></form:input>
    			</div>
    		</spring:bind>
		<spring:bind path="name">
			<div>
				<form:input type="text" path="name" class="form-control"
					placeholder="Name" autofocus="true"></form:input>
			</div>
		</spring:bind>

		<Input type="submit" name="submit" value="submit">
		</td>
	</form:form>
</body>
</html>