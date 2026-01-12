<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${category.name} - Sub Categories</title>

<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
    .sub-card {
        border: 1px solid #ddd;
        border-radius: 8px;
        padding: 20px;
        text-align: center;
        margin-bottom: 20px;
        background-color: #f9f9f9;
        transition: 0.3s;
    }
    .sub-card:hover {
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
                ${category.name} - Sub Categories
            </h3>
        </div>

        <div class="col-sm-4 text-right" style="margin-top:20px;">
            <form action="<c:url value='/logout'/>" method="get">
                <button type="submit" class="btn btn-danger">
                    Logout
                </button>
            </form>
        </div>
    </div>
    <hr>

    <div class="row">

        <c:forEach var="sub" items="${subCategories}">
            <div class="col-sm-4">
                <a href="<c:url value='/categories/${category.id}/subcategories/${sub.id}/products'/>"
                   style="text-decoration:none;color:black;">

                    <div class="sub-card">
                        <h4>${sub.name}</h4>
                    </div>

                </a>
            </div>
        </c:forEach>

    </div>

</div>

</body>
</html>
