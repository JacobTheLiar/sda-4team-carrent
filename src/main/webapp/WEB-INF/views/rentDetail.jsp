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
<form method="post" class="w3-container w3-margin w3-card w3-border w3-theme-l4"
      action="${pageContext.request.contextPath}/rent/borrow" id="rentForm">
    <!-- tytuł -->
    <div class="w3-container w3-theme w3-margin-top w3-center">
        <h2>${rent.id==0 ? 'nowe wypożyczenie samochodu' : 'dokonaj zmian w danych tego wypożyczenia'}</h2>
    </div>

    <!-- dane -->
    <input type="hidden" name="id" value="${rent.id}">
    <%--    <form id="getRentForm">--%>
    <p>
        <label><b>wypożyczany samochód</b></label>
        <select class="w3-input w3-border" name="car" form="rentForm" form="getRentForm">
            <option selected="selected" placeholder="wybierz samochód" value="${rent.car.id}">${rent.car}</option>
            <c:forEach var="car" items="${cars}">
                <option value="${car.id}">${car}</option>
            </c:forEach>
        </select
    </p>
    <p>
        <label><b>komu jest wypożyczany</b></label>
        <select name="client" class="w3-input w3-border" form="rentForm" form="getRentForm">
            <option selected="selected" placeholder="wybierz klienta"
                    value="${rent.client.id}">${rent.client.name}</option>
            <c:forEach var="client" items="${clients}">
                <option value="${client.id}">${client.name}</option>
            </c:forEach>
        </select>
    </p>

    <%--        <input type="submit" class="w3-button w3-red w3-right w3-large" value="filtruj promocje">--%>
    <%--    </form>--%>

    <p>
        <label><b>promocja</b></label>
        <select class="w3-input w3-border" name="promotion" form="rentForm">
            <option selected="selected" placeholder="wybierz promocję"
                    value="${rent.promotion.id}">${rent.promotion.name}</option>
            <c:forEach var="promotion" items="${promotions}">
                <option value="${promotion.id}">${promotion.name}</option>
            </c:forEach>
        </select>
    </p>
    <p>
        <label><b>punkt wypożyczenia</b></label>
        <input type="hidden" name="rentPointStart" value="${rentPoint.id}">
        <input type="text" name="rentPointStart" class="w3-input w3-border"
               value="${rentPoint.name}" readonly form="rentForm">
    </p>
    <p>
        <label><b>identyfikator pracownika</b></label>
        <input type="text" name="employeeStart" class="w3-input w3-border"
               value="${sessionScope.employee.username}" readonly form="rentForm">
    </p>
    <p>
        <label><b>data wypożyczenia</b></label>
        <input type="date" name="rentTimeStart" placeholder="wpisz datę" class="w3-input w3-border"
               value="${rent.rentTimeStart}" min="${todayDate}" max="${maxDate}" form="rentForm">
    </p>
    <p>
        <label><b>stan licznika</b></label>
        <input type="number" name="counterStateStart" placeholder="wpisz stan licznika" class="w3-input w3-border"
               value="${rent.counterStateStart}" form="rentForm">
    </p>
    <p>
        <label><b>uwagi w momencie przekazania auta</b></label>
        <input type="text" name="notes" placeholder="wpisz uwagi" class="w3-input w3-border" value="${rent.notes}"
               form="rentForm">
    </p>
    <p>
        <input type="submit" class="w3-button w3-red w3-right w3-large" value="zatwierdź">
        <a href="${pageContext.request.contextPath}/rent/" class="w3-button w3-theme-l2">anuluj</a>
    </p>

    ​
    <%@include file='footer.html' %>
    ​
    ​
</body>

</html>
​