<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmation</title>
    <style>
    table, th, td {
        border: 0px;
    }
    td {
        padding: 5px 10px;
    }
    </style>
</head>
<body>
<h1>Purchase Completed!</h1>

<h3>Current Stock</h3>

<table>
<tr><th>Name</th><th>Stock</th></tr>
<c:forEach items="${products}" var="product" >
<tr>
    <td>${product.name}</td>
    <td>${product.stock}</td>
</tr>
</c:forEach>
</table>

<div>


</form:form>
</div>
</body>