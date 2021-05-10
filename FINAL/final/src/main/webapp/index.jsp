<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buy page</title>
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
<h1>Buy Page</h1>

<h3>Available Products</h3>

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
<h3>Choose a product to purchase</h3>
<form:form method="GET" action="/buy">

<table class="order">
<tr>
<td>
    <select name="product_id">
        <c:forEach items="${products}" var="product" >
        <option value="${product.id}">${product.name}</option>
        </c:forEach>
    </select>
</td>
<td>
    <select name="quantity">
        <option value="5">5</option>
        <option value="10">10</option>
        <option value="15">15</option>
        <option value="20">20</option>
    </select>
</td>
<td>
    <input type="submit" value="Submit"/>
</td>
</tr>
</table>



</form:form>
</div>
</body>