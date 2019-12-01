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

<form method="post" class="w3-container w3-margin w3-card w3-border w3-theme-l4"
      action="${pageContext.request.contextPath}/rent/return/${rent.id}" id="returnForm">
    <!-- tytuł -->
    <div class="w3-container w3-theme w3-margin-top w3-center">
        <h2>oddanie samochodu</h2>
    </div>

    <!-- dane -->
    <input type="hidden" name="id" value="${rent.id}">
    <p>
        <label><b>wypożyczony samochód</b></label>
        <input type="hidden" name="car" value="${rent.car.id}">
        <input type="text" name="car" class="w3-input w3-border" value="${rent.car}"
               form="returnForm" readonly>
    </p>
    <p>
        <label><b>komu jest wypożyczony</b></label>
        <input type="hidden" name="client" value="${rent.client.id}">
        <input type="text" name="client" class="w3-input w3-border" value="${rent.client.name}"
               form="returnForm" readonly>
    </p>
    <p>
        <label><b>promocja</b></label>
        <input type="hidden" name="promotion" value="${rent.promotion.id}">
        <input type="text" name="promotion" class="w3-input w3-border" value="${rent.promotion.name}"
               form="returnForm" readonly>
    </p>
    <table>
        <tr>
            <td>
                <label><b>punkt wypożyczenia</b></label>
                <input type="hidden" name="rentPointStart" value="${rent.rentPointStart.id}">
                <input type="text" name="rentPointStart" class="w3-input w3-border" value="${rent.rentPointStart.name}"
                       form="returnForm" readonly>
            </td>
            <td>
                <label><b>punkt oddania</b></label>
                <input type="hidden" name="rentPointEnd" value="${rentPoint.id}">
                <input type="text" name="rentPointEnd"  class="w3-input w3-border"
                       value="${rentPoint.name}" readonly form="returnForm">
            </td>
        </tr>
        <tr>
            <td>
                <label><b>identyfikator pracownika wydającego</b></label>
                <input type="text" name="employeeStart" class="w3-input w3-border"
                       value="${rent.employeeStart.username}"
                       form="returnForm" readonly>
            </td>
            <td>
                <label><b>identyfikator pracownika przyjmującego</b></label>
                <input type="text" name="employeeEnd" class="w3-input w3-border"
                       value="${sessionScope.employee.username}"
                       form="returnForm" readonly>
            </td>
        </tr>
        <tr>
        <td>
            <label><b>data wypożyczenia</b></label>
            <input type="date" name="rentTimeStart" class="w3-input w3-border" value="${rent.rentTimeStart}"
                   form="returnForm" readonly>
        </td>
            <td>
                <label><b>data oddania</b></label>
                <input type="date" name="rentTimeStart" placeholder="wpisz datę" class="w3-input w3-border"
                       value="${rentHistory.rentTimeEnd}" min="${todayDate}" max="${todayDate}" readonly form="returnForm">
            </td>
        </tr>
        <tr>
        <td>
            <label><b>stan licznika na moment wypożyczenia</b></label>
            <input type="number" name="counterStateStart" class="w3-input w3-border" value="${rent.counterStateStart}"
                   form="returnForm" readonly>
        </td>
            <td>
                <label><b>stan licznika w momencie oddania</b></label>
                <input type="number" name="counterStateEnd" class="w3-input w3-border" value="${rentHistory.counterStateEnd}"
                       min=${minCounter} form="returnForm" >
            </td>
        </tr>
        <tr>
        <td>
            <label><b>uwagi w momencie przekazania auta</b></label>
            <input type="text" name="notes" class="w3-input w3-border" value="${rent.notes}"
                   form="returnForm" readonly>
        </td>
            <td>
                <label><b>uwagi w momencie oddania auta</b></label>
                <input type="text" name="notesEnd" class="w3-input w3-border" value="${rentHistory.notesEnd}"
                       form="returnForm" >
            </td>
        </tr>
    </table>
    <p>
        <input type="submit" class="w3-button w3-red w3-right w3-large" value="zatwierdź">
        <a href="${pageContext.request.contextPath}/rent/" class="w3-button w3-theme-l2">anuluj</a>
    </p>
</form>
    ​
    <%@include file='footer.html' %>
    ​
    ​
</body>

</html>
​