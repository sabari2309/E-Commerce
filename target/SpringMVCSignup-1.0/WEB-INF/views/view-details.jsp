<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Confirm Product & Quantity</title>

<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
.product-card {
    margin-top: 40px;
    padding: 25px;
    border: 1px solid #ddd;
    border-radius: 10px;
    background-color: #fff;
}
.product-img {
    width: 100%;
    max-height: 280px;
    object-fit: contain;
}
.price {
    font-size: 22px;
    color: #d9534f;
    font-weight: bold;
}
.total {
    font-size: 24px;
    color: #5cb85c;
    font-weight: bold;
}
</style>
</head>

<body>

<div class="container">

    <h3 class="text-center">Confirm Product & Quantity</h3>
    <hr>

    <div class="row product-card">

        <!-- PRODUCT IMAGE -->
        <div class="col-sm-5 text-center">
            <img src="${pageContext.request.contextPath}/images/products/${product.image}"
                 class="product-img"
                 alt="${product.name}">
        </div>

        <!-- PRODUCT DETAILS -->
        <div class="col-sm-7">

            <h3>${product.name}</h3>

            <p class="price">
                Price: ₹ <span id="unitPrice">${product.price}</span>
            </p>

            <p>
                <b>Description:</b><br>
                ${product.description}
            </p>

            <hr>

            <p class="total">
                Total: ₹ <span id="totalPrice">${product.price}</span>
            </p>

            <hr>
            <form action="<c:url value='/cart/items/add'/>" method="post">

                <input type="hidden" name="productId" value="${product.id}">
                <div class="form-group">
                    <label>Quantity</label>
                    <input type="number"
                           id="quantity"
                           name="quantity"
                           class="form-control"
                           min="1"
                           value="1"
                           style="width:120px"
                           required
                           oninput="updateTotal()">
                </div>

                <br>

                <button type="submit" class="btn btn-success">
                    Confirm & Add to Cart
                </button>

                <a href="javascript:history.back()" class="btn btn-default">
                    Cancel
                </a>

            </form>

        </div>
    </div>

</div>

<script>
function updateTotal() {
    var qty = parseInt(document.getElementById("quantity").value || 1);
    var price = parseFloat(document.getElementById("unitPrice").innerText);
    document.getElementById("totalPrice").innerText = qty * price;
}
</script>

</body>
</html>
