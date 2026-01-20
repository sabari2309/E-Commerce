<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html metacharset="UTF-8">
<head>
<title>${categoryName}</title>
<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>

<body>
<div class="container">
<div class="row">
        <div class="col-sm-8">
            <h3>
                Welcome <b>${user.firstName}</b><br>
                ${subcategory.name} Products
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
<c:forEach var="p" items="${products}">
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-body text-center">

                <img src="<c:url value='/images/products/${p.image}'/>"
                     width="150" height="150"/>

                <h4>${p.name}</h4>
                <p>₹ ${p.price}</p>
                <a href="<c:url value='/categories/${category.id}/subcategories/${subcategory.id}/products/${p.id}/details'/>"
                   class="btn btn-primary">
                   View Details
                </a>

            </div>
        </div>
    </div>
</c:forEach>
</div>

</div>
</body>
</html>
