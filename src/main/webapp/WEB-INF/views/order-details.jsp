<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Order Details</title>

<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
.order-box {
    border: 1px solid #ddd;
    padding: 20px;
    border-radius: 10px;
    margin-top: 20px;
    background: #fff;
}
.product-img {
    width: 80px;
    height: 80px;
    object-fit: contain;
}
.total-box {
    font-size: 22px;
    font-weight: bold;
    color: #5cb85c;
    text-align: right;
}
</style>
</head>

<body>

<div class="container">

    <h2 class="text-center">Order Details</h2>
    <hr>

    <!-- ===== ORDER SUMMARY ===== -->
    <div class="order-box">
        <p><b>Order ID:</b> ${order.order_id}</p>
        <p><b>Ordered Time:</b> ${order.created_at}</p>
        <p><b>Status:</b> ${order.status}</p>
        <p><b>Delivery Address:</b><br>${order.address}</p>
    </div>

    <br>

    <!-- ===== PRODUCT LIST ===== -->
    <div class="order-box">

        <h4>Items in this Order</h4>
        <hr>

        <c:forEach var="item" items="${items}">
            <div class="row" style="margin-bottom:15px;">

                <!-- IMAGE -->
                <div class="col-sm-2 text-center">
                    <img src="${pageContext.request.contextPath}/images/products/${item.image}"
                         class="product-img">
                </div>

                <!-- NAME -->
                <div class="col-sm-4">
                    <h4>${item.productName}</h4>
                </div>

                <div class="col-sm-4">
                    <h4>${item.description}</h4>
                </div>
                
                <div class="col-sm-2">
                    Qty: <b>${item.quantity}</b>
                </div>

                <!-- PRICE -->
                <div class="col-sm-2">
                    ₹ ${item.price}
                </div>

                <!-- TOTAL -->
                <div class="col-sm-2">
                    ₹ ${item.price * item.quantity}
                </div>

            </div>
            <hr>
        </c:forEach>

        <div class="total-box">
            Grand Total: ₹ ${order.total}
        </div>

    </div>

    <br>

    <div class="text-left">
        <a href="${pageContext.request.contextPath}/vieworder"
           class="btn btn-default">
            ← Back to Orders
        </a>
    </div>

</div>

</body>
</html>
