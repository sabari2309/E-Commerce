<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>

<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
.signup-box {
    width: 450px;
    margin: 60px auto;
    padding: 30px;
    border: 1px solid #ddd;
    border-radius: 10px;
    background-color: #f9f9f9;
}

.signup-box h3 {
    text-align: center;
    margin-bottom: 20px;
}

.signup-box table {
    width: 100%;
}

.signup-box td {
    padding: 8px;
}

.signup-box input {
    width: 100%;
    padding: 8px;
}

.error {
    color: red;
    font-size: 12px;
}

.db-message {
    color: red;
    text-align: center;
    margin-bottom: 10px;
}
</style>
</head>

<body>

<div class="signup-box">

    <h3>Create Account</h3>

    <c:if test="${not empty dbMessage}">
        <div class="db-message">${dbMessage}</div>
    </c:if>

    <form:form action="${pageContext.request.contextPath}/signup"
               method="post" modelAttribute="user">

        <table>
            <tr>
                <td><form:label path="firstName">First Name</form:label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr><td></td><td class="error"><form:errors path="firstName"/></td></tr>

            <tr>
                <td><form:label path="lastName">Last Name</form:label></td>
                <td><form:input path="lastName"/></td>
            </tr>

            <tr>
                <td><form:label path="email">Email</form:label></td>
                <td><form:input path="email"/></td>
            </tr>
            <tr><td></td><td class="error"><form:errors path="email"/></td></tr>

            <tr>
                <td><form:label path="password">Password</form:label></td>
                <td><form:password path="password"/></td>
            </tr>
            <tr><td></td><td class="error"><form:errors path="password"/></td></tr>

            <tr>
                <td><form:label path="mobileNumber">Mobile</form:label></td>
                <td><form:input path="mobileNumber"/></td>
            </tr>
            <tr><td></td><td class="error"><form:errors path="mobileNumber"/></td></tr>

            <tr>
                <td colspan="2" class="text-center">
                    <input type="submit" value="Sign Up"
                           class="btn btn-primary btn-block"/>
                </td>
            </tr>
        </table>

    </form:form>

    <div class="text-center" style="margin-top:15px;">
        <a href="<c:url value='/login'/>">
            Already have an account? Login
        </a>
    </div>

</div>

</body>
</html>
