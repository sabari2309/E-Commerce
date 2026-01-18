<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
.login-box {
    width: 350px;
    margin: 100px auto;
    padding: 25px;
    border: 1px solid #ddd;
    border-radius: 8px;
    background-color: #f9f9f9;
}
.login-box input {
    margin-bottom: 10px;
}
</style>
</head>

<body>

<div class="login-box">
    <c:if test="${not empty dbMessage}">
        <div class="alert alert-danger">
            ${dbMessage}
        </div>
    </c:if>

    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="email" name="email" class="form-control"
               placeholder="Email" required />

        <input type="password" name="password" class="form-control"
               placeholder="Password" required />

        <button type="submit" class="btn btn-primary btn-block">
            Login
        </button>
    </form>

    <hr>

    <div class="text-center">
        <a href="<c:url value='/'/>">Create Account</a>
    </div>

</div>

</body>
</html>
