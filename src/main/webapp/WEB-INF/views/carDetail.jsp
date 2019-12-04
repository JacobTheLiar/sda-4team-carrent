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
<h2 class="w3-bar w3-border w3-center w3-theme">dodanie/edycja samochodu</h2>

<!-- dodatkowe opcje i szukanie -->
<div class="w3-bar w3-light-grey w3-border">

    <a href="${pageContext.request.contextPath}/car/" class="w3-bar-item w3-button w3-green">anuluj</a>

</div>

​<!-- dane -->
<table class="w3-table w3-bordered w3-striped">
    <tr class="w3-theme-d4">
        <th>model</th>
        <th>nr rejestr.</th>
        <th>data rejestracji</th>
        <th>VIN</th>
        <th>kolor</th>
        <th>stawka za dzień</th>
        <th>punkt początkowy</th>
        <th>opcje</th>
    </tr>
    <c:if test="${!update}">
        <tr>
            <form method="post" action="${pageContext.request.contextPath}/car/save" modelAttribute="car">
                <td>
                    <select class="w3-bar-item w3-input w3-right" name="carModelId">
                        <option selected="selected">wybierz model</option>
                        <c:forEach var="option" items="${carModels}">
                            <option value="${option.id}">${option}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="text" name="plateNr" placeholder="wpisz nr rejestr."></td>
                <td><input type="date" name="registrationDate" placeholder="wpisz data rejestracji"></td>
                <td><input type="text" name="vin" placeholder="wpisz VIN"></td>
                <td><input type="text" name="color" placeholder="wpisz kolor"></td>
                <td>
                    <select class="w3-bar-item w3-input w3-right" name="beginRentPoint">
                        <option selected="selected">przypisz punkt</option>
                        <c:forEach var="option" items="${rentPoints}">
                            <option value="${option.id}">${option}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="number" name="pricePerDay" placeholder="wpisz stawkę za dzień"></td>
                <td>
                    <input type="submit" value="zapisz" class="w4-button w3-theme"/>
                </td>
            </form>
        </tr>
    </c:if>
    <c:if test="${update}">
        <tr>
            <form method="post" action="${pageContext.request.contextPath}/car/save" modelAttribute="car">
                <input type="hidden" name="id" value="${car.id}">
                <td>
                    <select class="w3-bar-item w3-input w3-right" name="carModelId">
                        <option selected="selected" value="${car.carModel.id}">${car.carModel}</option>
                        <c:forEach var="option" items="${carModels}">
                            <option value="${option.id}">${option}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="text" name="plateNr" value="${car.plateNr}"></td>
                <td><input type="date" name="registrationDate" value="${car.registrationDate}"></td>
                <td><input type="text" name="vin" value="${car.vin}"></td>
                <td><input type="text" name="color" value="${car.color}"></td>
                <td>
                    <select class="w3-bar-item w3-input w3-right" name="beginRentPoint">
                        <option selected="selected" value="${car.beginRentPoint.id}">${car.beginRentPoint}</option>
                        <c:forEach var="option" items="${rentPoints}">
                            <option value="${option.id}">${option}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="number" name="pricePerDay" value="${car.pricePerDay}"></td>
                <td>
                    <input type="submit" value="zapisz" class="w4-button w3-theme"/>
                </td>
            </form>
        </tr>
    </c:if>


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