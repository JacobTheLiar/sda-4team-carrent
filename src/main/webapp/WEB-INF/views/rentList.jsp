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
<h2 class="w3-bar w3-border w3-center w3-theme">bieżąca lista wypożyczonych samochodów</h2>

<!-- dodatkowe opcje i szukanie -->
<div class="w3-bar w3-light-grey w3-border">

    <a href="${pageContext.request.contextPath}/rent/borrow" class="w3-bar-item w3-button w3-green">wypożycz</a>
    <c:if test="${isFiltered}">
        <a href="${pageContext.request.contextPath}/rent/" class="w3-bar-item w3-button w3-theme-l2 w3-right w3-margin-left">usuń filtr</a>
    </c:if>
    <form>
        <input type="submit" class="3-bar-item w3-button w3-theme w3-right w3-margin-left" value="szukaj">
        <input type="text" class="w3-bar-item w3-input w3-border w3-right w3-margin-left" placeholder="szukaj..." name="searchWhat" value="${param.searchWhat}">
        <select class="w3-bar-item w3-select w3-border w3-right" name="searchBy">
            <c:forEach var="option" items="${searchByOptions}">
                <option value="${option.name()}" ${option.name()==param.searchBy ? ' selected' : ''}>${option.description}</option>
            </c:forEach>
        </select>
    </form>
</div>

​<!-- dane -->
<table class="w3-table w3-bordered w3-striped">
    <tr class="w3-theme-d4">
        <th>samochód</th>
        <th>klient</th>
        <th>promocja</th>
        <th>punkt wypożyczenia</th>
        <th>pracownik wypożyczający</th>
        <th>data i czas wypożyczenia</th>
        <th>stan licznika podczas wypożyczenia</th>
        <th>uwagi</th>
        <th>opcje</th>
    </tr>
    <c:forEach var="rent" items="${rents}">
        <tr class="w3-center">
            <td>${rent.car}</td>
            <td>${rent.client.name}</td>
            <td>${rent.promotion.name}</td>
            <td>${rent.rentPointStart.name}</td>
            <td>${rent.employeeStart.username}</td>
            <td>${rent.rentTimeStart}</td>
            <td>${rent.counterStateStart}</td>
            <td>${rent.notes}</td>

            <td><a href="${pageContext.request.contextPath}/rent/${rent.id}" class="w3-button w3-theme w3-tiny">edytuj</a>
                <a href="${pageContext.request.contextPath}/rent/return/${rent.id}" class="w3-button w3-theme w3-tiny">oddaj samochód</a>
            </td>
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