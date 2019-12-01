<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Expression language jest włączony--%>
<%@ page isELIgnored="false" %>
<%--JSTL jest włączony--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@include file='head.html' %>
<body class="w3-theme-light">
<!-- ​nagłowek -->
<%@include file='header.html' %>
​
<!-- menu po lewej -->
<%@include file='menu.html' %>
​


<!-- tytuł -->
<h2 class="w3-bar w3-border w3-center w3-theme">wykaz punktów wypożyczalni</h2>

<!-- dodatkowe opcje i szukanie -->
<div class="w3-bar w3-light-grey w3-border">

    <a href="${pageContext.request.contextPath}/rentPoint/add" class="w3-bar-item w3-button w3-green">dodaj</a>

</div>

​<!-- dane -->
<table class="w3-table w3-bordered w3-striped">
    <tr class="w3-theme-d4">
        <th>nazwa</th>
        <th>adres</th>
        <th>kod pocztowy</th>
        <th>miasto</th>
        <th>opcje</th>

    </tr>
    <c:forEach var="rentPoint" items="${rentPoints}">
        <tr class="w3-center">
            <td>${rentPoint.name}</td>
            <td>${rentPoint.address}</td>
            <td>${rentPoint.postCode}</td>
            <td>${rentPoint.city}</td>

            <td><a href="${pageContext.request.contextPath}/rentPoint/${rentPoint.id}" class="w3-button w3-theme w3-tiny">edytuj</a>

        </tr>
    </c:forEach>
</table>
​
​

​
<%@include file='footer.html' %>
​
​
</body>

</html>
​