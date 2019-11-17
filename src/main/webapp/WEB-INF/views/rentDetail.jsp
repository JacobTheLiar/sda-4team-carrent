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
<h2 class="w3-bar w3-border w3-center w3-theme">wypożycz samochód</h2>

<!-- dodatkowe opcje i szukanie -->
<div class="w3-bar w3-light-grey w3-border">

    <a href="${pageContext.request.contextPath}/rent/" class="w3-bar-item w3-button w3-green">anuluj</a>

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


        <tr>
            <form method="post" action="${pageContext.request.contextPath}/rent/borrow" modelAttribute="rent">
                <input type="hidden" name="id" value="${rent.id}">
                <td>
                    <select class="w3-bar-item w3-input w3-right" name="carId">
                        <option selected="selected" value="${rent.car.id}">${rent.car}</option>
                        <c:forEach var="option" items="${cars}">
                            <option value="${option.id}">${option}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select class="w3-bar-item w3-input w3-right" name="clientId">
                        <option selected="selected" value="${rent.client.id}">${rent.client.name}</option>
                        <c:forEach var="option" items="${clients}">
                            <option value="${option.id}">${option.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select class="w3-bar-item w3-input w3-right" name="promotionId">
                        <option selected="selected" value="${rent.promotion.id}">${rent.promotion.name}</option>
                        <c:forEach var="option" items="${promotions}">
                            <option value="${option.id}">${option.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select class="w3-bar-item w3-input w3-right" name="rentPointId">
                        <option selected="selected" value="${rent.rentPointStart.id}">${rent.rentPointStart.name}</option>
                        <c:forEach var="option" items="${rentPoints}">
                        <option value="${option.id}">${option.name}</option>
                        </c:forEach>
                </td>
                <td>
                    <select class="w3-bar-item w3-input w3-right" name="employeeId">
                        <option selected="selected" value="${rent.employeeStart.username}">${rent.employeeStart.username}</option>
                        <c:forEach var="option" items="${employees}">
                        <option value="${option.username}">${option.username}</option>
                        </c:forEach>
                </td>
                <td><input type="date" name="rentTimeStart" value="${rent.rentTimeStart}"></td>
                <td><input type="number" name="counterStateStart" value="${rent.counterStateStart}"></td>
                <td><input type="text" name="notes" value="${rent.notes}"></td>
                <td>
                    <input type="submit" value="zatwierdź" class="w4-button w3-theme"/>
                </td>
            </form>
        </tr>



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