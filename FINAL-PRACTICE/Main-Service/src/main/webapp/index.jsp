<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring Session</title>
</head>
<body>
<h1>Citizen Eligibility</h1>
<div>
<form action="/eligibility" action="GET">

	Citizen ID: <input type="text" name="citizen_id"><br>
	<input type="submit">
</form>
</div>
</body>