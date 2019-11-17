<%--
  Created by IntelliJ IDEA.
  User: Michał
  Date: 16.11.2019
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Expression language jest włączony--%>
<%@ page isELIgnored="false" %>
<%--JSTL jest włączony--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@include file='head.html'%>
<body class="w3-theme-light">
<!-- ​nagłowek -->
<%@include file='header.html'%>    ​
<!-- menu po lewej -->
<%@include file='menu.html'%>    ​


<!-- tytuł -->
<h2 class="w3-bar w3-border w3-center w3-theme">Promocje</h2>

<!-- dodatkowe opcje i szukanie -->
<div class="w3-bar w3-light-grey w3-border">

    <a href="${pageContext.request.contextPath}/promotion/add" class="w3-bar-item w3-button w3-green">Dodaj</a>
    <a href="${pageContext.request.contextPath}/promotion" class="w3-bar-item w3-button w3-theme-l2 w3-right w3-margin-left">Usuń filtr</a>
    <form >
        <input type="submit" class="w3-bar-item w3-button w3-theme w3-right w3-margin-left" value="Szukaj">
        <select class="w3-bar-item w3-select w3-border w3-right" name="searchBy">
            <c:forEach var="option" items="${options}">
                <option value="${option.name()}"${option.name()==param.searchBy ? ' selected' : ''}>${option}</option>
            </c:forEach>
        </select>
        <input type="text" class="w3-bar-item w3-input w3-border w3-right w3-margin-left" placeholder="szukaj..." name="searchWhat" value="${param.searchWhat}">
    </form>
</div>

​<!-- dane -->
<table class="w3-table w3-bordered w3-striped">
    <tr class="w3-theme-d4">
        <th>Nazwa</th>
        <th>Rabat %</th>
        <th>Auto</th>
        <th>Klient</th>
        <th>Start Promocji</th>
        <th>Koniec Promocji</th>
    </tr>

    <c:forEach var="promotion" items="${promotions}">
        <tr class="w3-center">
            <td>${promotion.name}</td>
            <td>${promotion.discountPercentage}</td>
            <td>${promotion.cars}</td>
            <td>${promotion.clients}</td>
            <td>${promotion.promoStart}</td>
            <td>${promotion.promoEnd}</td>

            <td><a href="${pageContext.request.contextPath}/promotion/${promotion.id}"
                   class="w3-button w3-theme w3-tiny">Edytuj</a></td>
        </tr>
    </c:forEach>
</table>
​
​

​
<%@include file='footer.html'%>    ​
​
</body>

</html>
​
