<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Order Placed</title>
<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>

<body>
<div class="container text-center">
    <h2>🎉 Order Placed Successfully!Summary Will be sent to mail <b>${user.email}</b></h2>
    <hr>
    <h4>Your Order ID: <b>${orderId}</b></h4>

    <a href="${pageContext.request.contextPath}/categories"
       class="btn btn-primary">
        Continue Shopping
    </a>
</div>
</body>
</html>
