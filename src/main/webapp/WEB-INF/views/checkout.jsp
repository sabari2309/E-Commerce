<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Checkout</title>

<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
.box {
    border: 1px solid #ddd;
    padding: 20px;
    border-radius: 8px;
    margin-top: 20px;
}
.total {
    font-size: 22px;
    font-weight: bold;
    color: #5cb85c;
}
</style>
</head>

<body>

<div class="container">

    <!-- HEADER -->
    <div class="row" style="margin-top:20px;">
        <div class="col-sm-8">
            <h2>Checkout</h2>
        </div>
       <div class="col-sm-4 text-right" style="margin-top:20px;">

    <a href="<c:url value='/cart/view'/>"
          class="btn btn-primary">
          Go to Cart
    </a>
    
    <a href="<c:url value='/vieworder'/>"
          class="btn btn-primary">
          View Orders
    </a>
    
    <form action="<c:url value='/logout'/>"
          method="get"
          style="display:inline-block;">

        <button type="submit" class="btn btn-danger">
             Logout
        </button>
    </form>

</div>


    </div>

    <hr>

    <!-- ================= ORDER SUMMARY ================= -->
    <div class="box">
        <h4>Order Summary</h4>

        <c:forEach var="item" items="${items}">
            <p>
                ${item.product.name}
                × ${item.quantity}
                = ₹ ${item.product.price * item.quantity}
            </p>

            <!-- SEND SELECTED CART ITEM IDS -->
            <input type="hidden" name="cartItemIds"
                   value="${item.cartItem_id}">
        </c:forEach>

        <hr>
        <p class="total">Total: ₹ ${total}</p>
    </div>

    <!-- ================= PLACE ORDER FORM ================= -->
    <div class="box">
        <h3>Select Delivery Address</h3>

        <c:if test="${empty addresses}">
            <p class="text-warning">
                No address found. Please add a new address.
            </p>
        </c:if>

        <form action="${pageContext.request.contextPath}/order/place"
              method="post">

            <!-- CART ITEM IDS AGAIN (IMPORTANT) -->
            <c:forEach var="item" items="${items}">
                <input type="hidden" name="cartItemIds"
                       value="${item.cartItem_id}">
            </c:forEach>

            <input type="hidden" name="total"
                   value="${total}">

            <!-- ADDRESS LIST -->
            <c:forEach var="addr" items="${addresses}">
                <div class="radio">
                    <label>
                        <input type="radio"
                               name="addressId"
                               value="${addr.address_id}"
                               required>
                        <b>${addr.name}</b>, ${addr.address_line},
                        ${addr.city}, ${addr.state} - ${addr.pincode}
                    </label>
                </div>
            </c:forEach>

            <br>

            <button type="submit"
                    class="btn btn-success btn-lg">
                Place Order
            </button>

        </form>

        <hr>

        <!-- ================= ADD ADDRESS FORM ================= -->
        <button type="button"
                class="btn btn-link"
                onclick="showAddressForm()">
            + Add New Address
        </button>

        <div id="addressForm" style="display:none;">
            <h4>New Address</h4>

            <form action="${pageContext.request.contextPath}/address/add"
                  method="post">

                <input name="name"
                       class="form-control"
                       placeholder="Name"
                       required>

                <input name="phone"
                       class="form-control"
                       placeholder="Phone"
                       required>

                <textarea name="address_line"
                          class="form-control"
                          placeholder="Address"
                          required></textarea>

                <input name="city"
                       class="form-control"
                       placeholder="City"
                       required>

                <input name="state"
                       class="form-control"
                       placeholder="State"
                       required>

                <input name="pincode"
                       class="form-control"
                       placeholder="Pincode"
                       required>

                <br>

                <button class="btn btn-primary">
                    Save Address
                </button>

            </form>
        </div>

    </div>

</div>

<script>
function showAddressForm() {
    document.getElementById("addressForm").style.display = "block";
}
</script>

</body>
</html>
