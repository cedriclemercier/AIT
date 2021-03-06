<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
</head>
<body>
	<h1>Dashboard</h1>

	<h3>My details</h3>
	<table>
	<tr><th>Username</th><th>Email</th></tr>
	<tr>
	<td>${user.username}</td>
	<td>${user.email}</td>
	</tr>
	</table>

	<h3>Users</h3>
	<c:forEach var="user" items="${users}">
    		<li><c:out value="${user.username}" /><br/></li>
    	</c:forEach>

	<h3>Your roles</h3>
	<c:forEach var="role" items="${user.roles}">
		<li><c:out value="${role.name}" /><br/></li>
	</c:forEach>

	<h3>Your Addresses</h3>


    <a href="/create">Create new user</a><br>
	<a href="/logout">Logout</a>
</body>
</html>