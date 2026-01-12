<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form action="signup"
           method="post" modelAttribute="user">
<h5>${dbMessage}</h5>
<table>
    <tr>
        <td><form:label path="firstName">First Name:</form:label></td>
        <td><form:input path="firstName"/></td>
        <td><form:errors path="firstName"/></td>
    </tr>

    <tr>
        <td><form:label path="lastName">Last Name:</form:label></td>
        <td><form:input path="lastName"/></td>
    </tr>

    <tr>
        <td><form:label path="email">Email:</form:label></td>
        <td><form:input path="email"/></td>
        <td><form:errors path="email"/></td>
    </tr>

    <tr>
        <td><form:label path="password">Password:</form:label></td>
        <td><form:password path="password"/></td>
        <td><form:errors path="password"/></td>
    </tr>

    <tr>
        <td><form:label path="mobileNumber">Mobile:</form:label></td>
        <td><form:input path="mobileNumber"/></td>
        <td><form:errors path="mobileNumber"/></td>
    </tr>

    <tr>
        <td colspan="2"><input type="submit"/></td>
    </tr>
</table>

</form:form>