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
<h2 class="w3-bar w3-border w3-center w3-theme">zarządzanie samochodami</h2>

<!-- dodatkowe opcje i szukanie -->
<div class="w3-bar w3-light-grey w3-border">

    <a href="${pageContext.request.contextPath}/car/add" class="w3-bar-item w3-button w3-green">dodaj</a>
    <c:if test="${isFiltered}">
        <a href="${pageContext.request.contextPath}/car/"
           class="w3-bar-item w3-button w3-theme-l2 w3-right w3-margin-left">usuń filtr</a>
    </c:if>
    <form>
        <input type="submit" class="3-bar-item w3-button w3-theme w3-right w3-margin-left" value="szukaj">
        <input type="text" class="w3-bar-item w3-input w3-border w3-right w3-margin-left" placeholder="szukaj..."
               name="searchWhat" value="${param.searchWhat}">
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
        <th>model</th>
        <th>nr rejestr.</th>
        <th>data rejestracji</th>
        <th>VIN</th>
        <th>segment</th>
        <th>typ</th>
        <th>kolor</th>
        <th>punkt początkowy</th>
        <th>stawka za dzień</th>
        <th>czy aktywny</th>
        <th>opcje</th>
    </tr>
    <c:forEach var="car" items="${cars}">
        <tr class="w3-center">
            <td>${car.carModel}</td>
            <td>${car.plateNr}</td>
            <td>${car.registrationDate}</td>
            <td>${car.vin}</td>
            <td>${car.carModel.segment}</td>
            <td>${car.carModel.type}</td>
            <td>${car.color}</td>
            <td>${car.beginRentPoint}</td>
            <td>${car.pricePerDay}</td>
            <td>${car.active}</td>

            <td><a href="${pageContext.request.contextPath}/car/${car.id}" class="w3-button w3-theme w3-tiny">edytuj</a>
                <a href="${pageContext.request.contextPath}/carReview/add/${car.id}" class="w3-button w3-theme w3-tiny">dodaj
                    przegląd</a>
                <a href="${pageContext.request.contextPath}/carReview/${car.id}" class="w3-button w3-theme w3-tiny">Lista
                    przeglądów</a>
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