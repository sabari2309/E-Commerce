<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>My Cart</title>

<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
.cart-card {
    margin-top: 15px;
    padding: 15px;
    border: 1px solid #ddd;
    border-radius: 8px;
    background: #fff;
}
.product-img {
    width: 80px;
    height: 80px;
    object-fit: contain;
}
.qty-btn {
    padding: 2px 10px;
}
.total-box {
    font-size: 22px;
    font-weight: bold;
    text-align: right;
    color: #5cb85c;
}
.empty-cart {
    text-align: center;
    margin-top: 50px;
    color: #888;
}
</style>
</head>

<body>

<div class="container">

<h2 class="text-center">My Cart</h2>
<hr>

<c:if test="${empty cartItems}">
    <h4 class="empty-cart">Your cart is empty</h4>
</c:if>

<c:forEach var="item" items="${cartItems}">
<div class="row cart-card">

    <!-- SELECT -->
    <div class="col-sm-1 text-center">
        <input type="checkbox"
               class="cart-check"
               data-price="${item.product.price}"
               data-qty="${item.quantity}"
               value="${item.cartItem_id}"
               onchange="calculateTotal()">
    </div>

    <!-- IMAGE -->
    <div class="col-sm-2">
        <img src="${pageContext.request.contextPath}/images/products/${item.product.image}"
             class="product-img">
    </div>

    <!-- DETAILS -->
    <div class="col-sm-3">
        <h4>${item.product.name}</h4>
        <p>₹ ${item.product.price}</p>
        <p>Qty: <b>${item.quantity}</b></p>
    </div>

    <!-- UPDATE -->
    <div class="col-sm-3">
        <a href="${pageContext.request.contextPath}/cart/item/${item.cartItem_id}/edit"
           class="btn btn-warning btn-sm">
           Update
        </a>
    </div>

    <!-- REMOVE -->
    <div class="col-sm-3">
        <form action="${pageContext.request.contextPath}/cart/item/remove"
              method="post">
            <input type="hidden" name="cartItemId"
                   value="${item.cartItem_id}">
            <button class="btn btn-danger btn-sm">Remove</button>
        </form>
    </div>

</div>
</c:forEach>


<hr>

<!-- CHECKOUT -->
<form action="${pageContext.request.contextPath}/cart/checkout"
      method="post" onsubmit="return submitSelectedItems()">

    <input type="hidden" name="selectedItems" id="selectedItems">

    <div class="row">
        <div class="col-sm-12 total-box">
            Selected Total: ₹ <span id="grandTotal">0</span>
        </div>
    </div>

    <br>

    <div class="text-right">
        <button class="btn btn-success btn-lg">
            Checkout Selected Items
        </button>
    </div>

</form>

</div>

<!-- JS -->
<script>
function changeQty(id, delta) {
    let input = document.getElementById("qty-" + id);
    let qty = parseInt(input.value);
    let newQty = qty + delta;
    if (newQty < 1) return;
    input.value = newQty;
    syncQty(id);
}

function syncQty(id) {
    let input = document.getElementById("qty-" + id);
    let checkbox = document.querySelector(".cart-check[data-id='" + id + "']");
    if (checkbox) {
        checkbox.dataset.qty = input.value;
    }
    calculateTotal();
}

function calculateTotal() {
    let total = 0;
    document.querySelectorAll(".cart-check:checked").forEach(cb => {
        let price = parseFloat(cb.dataset.price);
        let qty = parseInt(cb.dataset.qty);
        total += price * qty;
    });
    document.getElementById("grandTotal").innerText = total;
}

function submitSelectedItems() {
    let ids = [];
    document.querySelectorAll(".cart-check:checked").forEach(cb => {
        ids.push(cb.value);
    });

    if (ids.length === 0) {
        alert("Please select at least one item to checkout");
        return false;
    }

    document.getElementById("selectedItems").value = ids.join(",");
    return true;
}
</script>

</body>
</html>
