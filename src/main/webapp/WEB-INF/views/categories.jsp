<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Categories</title>

<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
.category-card {
    border: 1px solid #ddd;
    border-radius: 8px;
    padding: 20px;
    text-align: center;
    margin-bottom: 20px;
    cursor: pointer;
    background-color: #f9f9f9;
    transition: 0.3s;
}
.category-card:hover {
    background-color: #e6f2ff;
    transform: scale(1.05);
}
</style>
</head>

<body>

<div class="container">

   <div class="row">
        <div class="col-sm-8">
            <h3>
                Welcome <b>${user.firstName}</b><br>
                Choose your Category
            </h3>
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

<div class="row">

<c:forEach var="category" items="${categories}">
    <div class="col-sm-4">
        <a href="<c:url value='categories/${category.id}/sub-categories'/>">
            <div class="category-card">
                <img src="<c:url value='/images/products/${category.icon}'/>"
                     width="150" height="150"/>
                <h4>${category.name}</h4>
            </div>
        </a>
    </div>
</c:forEach>

</div>
</div>

</body>
</html>
