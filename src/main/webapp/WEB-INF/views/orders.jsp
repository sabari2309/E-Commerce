<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>My Orders</title>

<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
.order-card {
    border: 1px solid #ddd;
    border-radius: 8px;
    padding: 15px;
    margin-bottom: 15px;
    background: #fff;
}
.order-header {
    font-size: 18px;
    font-weight: bold;
}
.order-total {
    color: #5cb85c;
    font-size: 20px;
    font-weight: bold;
}
.order-status {
    font-weight: bold;
}
</style>
</head>

<body>

<div class="container">

    <h2 class="text-center">My Orders</h2>
    <hr>

    <c:if test="${empty orders}">
        <h4 class="text-center text-muted">
            You haven't placed any orders yet.
        </h4>
    </c:if>

    <c:forEach var="order" items="${orders}">
        <div class="order-card">

            <div class="row">
                <div class="col-sm-8">
                    <div class="order-header">
                        Order #${order.order_id}
                    </div>
                    <p>
                        Placed On:
                        <b>${order.created_at}</b>
                    </p>
                    <p>
                        Delivery Address:
                        ${order.address}
                    </p>
                    <p class="order-status">
                        Status:
                        <span class="label label-info">
                            ${order.status}
                        </span>
                    </p>
                </div>

                <div class="col-sm-4 text-right">
                    <p class="order-total">
                        ₹ ${order.total}
                    </p>

                    <form action="${pageContext.request.contextPath}/orders/details"
                                        method="post"style="display:inline;">
      
                       <input type="hidden" name="orderId" value="${order.order_id}">
    
                          <button type="submit" class="btn btn-primary btn-sm">
                             View Details
                          </button>
                     </form>
                </div>
            </div>

        </div>
    </c:forEach>

    <div class="text-center">
        <a href="${pageContext.request.contextPath}/categories"
           class="btn btn-default">
            Continue Shopping
        </a>
    </div>

</div>

</body>
</html>
