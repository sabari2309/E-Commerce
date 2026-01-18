<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Quantity</title>

<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
.update-box {
    width: 500px;
    margin: 60px auto;
    padding: 25px;
    border: 1px solid #ddd;
    border-radius: 8px;
}
.product-img {
    width: 150px;
    height: 150px;
    object-fit: contain;
}
</style>
</head>

<body>

<div class="update-box text-center">

    <h3>Update Quantity</h3>
    <hr>

    <img src="${pageContext.request.contextPath}/images/products/${cartItem.product.image}"
         class="product-img">

    <h4>${cartItem.product.name}</h4>
    <p>Price: ₹ ${cartItem.product.price}</p>

    <form action="${pageContext.request.contextPath}/cart/item/update"
          method="post">

        <input type="hidden" name="cartItemId"
               value="${cartItem.cartItem_id}">

        <label>Quantity</label>
        <input type="number"
               name="quantity"
               class="form-control"
               value="${cartItem.quantity}"
               min="1"
               style="width:120px;margin:auto"
               required>

        <br>

        <button class="btn btn-success">
            Confirm
        </button>

        <a href="${pageContext.request.contextPath}/cart/view"
           class="btn btn-default">
           Cancel
        </a>

    </form>

</div>

</body>
</html>
