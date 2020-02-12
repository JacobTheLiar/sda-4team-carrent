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
​
<form method="get" class="w3-container w3-margin w3-card w3-border w3-theme-l4"
      action="${pageContext.request.contextPath}/rent/borrow/" id="rentForm">
    <!-- tytuł -->
    <div class="w3-container w3-theme w3-margin-top w3-center">
        <h2>nowe wypożyczenie samochodu</h2>
    </div>


    <label><b>wypożyczany samochód</b></label>
    <select class="w3-input w3-border" name="car" form="rentForm">
        <option selected="selected" placeholder="wybierz samochód" value="${rent.car.id}">${rent.car}</option>
        <c:forEach var="car" items="${cars}">
            <option value="${car.id}">${car}</option>
        </c:forEach>
    </select

    <label><b>komu jest wypożyczany</b></label>
    <select name="client" class="w3-input w3-border" form="rentForm" onchange="this.form.submit()">
        <option selected="selected" placeholder="wybierz klienta"
                value="${rent.client}">${rent.client.name}</option>
        <c:forEach var="client" items="${clients}">
            <option value="${client.id}">${client.name}</option>
        </c:forEach>
    </select>
</form>


​
<%@include file='footer.html' %>
​
​
</body>

</html>
​