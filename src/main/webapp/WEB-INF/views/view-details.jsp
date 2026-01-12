<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${product.name}</title>

<link rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
    .product-card {
        margin-top: 30px;
        padding: 25px;
        border: 1px solid #ddd;
        border-radius: 10px;
        background-color: #ffffff;
    }
    .product-img {
        width: 100%;
        max-height: 300px;
        object-fit: contain;
        border-radius: 8px;
    }
    .price {
        color: #d9534f;
        font-size: 22px;
        font-weight: bold;
    }
</style>
</head>

<body>

<div class="container">

    <!-- HEADER ROW -->
    <div class="row" style="margin-top:20px;">
        <div class="col-sm-8">
            <h3>${product.name}</h3>
        </div>

        <div class="col-sm-4 text-right">
            <a href="<c:url value='/logout'/>" class="btn btn-danger">
                Logout
            </a>
        </div>
    </div>

    <hr>

    <div class="row product-card">

        <div class="col-sm-5 text-center">
            <img src="${pageContext.request.contextPath}/images/products/${product.image}"
                 class="product-img"
                 alt="${product.name}">
        </div>

        <div class="col-sm-7">
            <h2>${product.name}</h2>
            <p class="price">&#8377; ${product.price}</p>

            <hr>

            <h4>Description</h4>
            <p>${product.description}</p>

            <br>

            <a href="#" class="btn btn-success">Add to Cart</a>
            <a href="#" class="btn btn-primary">Buy Now</a>
        </div>

    </div>

</div>

</body>
</html>
