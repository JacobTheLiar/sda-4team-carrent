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
      action="${pageContext.request.contextPath}/rent/return/${rent.id}" id="returnForm">
    <!-- tytuł -->
    <div class="w3-container w3-theme w3-margin-top w3-center">
        <h2>oddanie samochodu</h2>
    </div>

    <!-- dane -->
    <input type="hidden" name="id" value="${rent.id}">
    <p>
        <label><b>wypożyczony samochód</b></label>
        <input type="text" name="car" class="w3-input w3-border" value="${rent.car}"
               form="returnForm" readonly>
    </p>
    <p>
        <label><b>komu jest wypożyczony</b></label>
        <input type="text" name="client" class="w3-input w3-border" value="${rent.client.name}"
               form="returnForm" readonly>
    </p>
    <p>
        <label><b>promocja</b></label>
        <input type="text" name="promotion" class="w3-input w3-border" value="${rent.promotion.name}"
               form="returnForm" readonly>
    </p>
    <p>
        <label><b>punkt wypożyczenia</b></label>
        <input type="text" name="rentPointStart" class="w3-input w3-border" value="${rent.rentPointStart.name}"
               form="returnForm" readonly>
    </p>
    <p>
        <label><b>identyfikator pracownika</b></label>
        <input type="text" name="employeeStart" class="w3-input w3-border" value="${rent.employeeStart.username}"
               form="returnForm" readonly>
    </p>
    <p>
        <label><b>data wypożyczenia</b></label>
        <input type="date" name="rentTimeStart" class="w3-input w3-border" value="${rent.rentTimeStart}"
               form="returnForm" readonly>
    </p>
    <p>
        <label><b>stan licznika</b></label>
        <input type="number" name="counterStateStart" class="w3-input w3-border" value="${rent.counterStateStart}"
               form="returnForm" readonly>
    </p>
    <p>
        <label><b>uwagi w momencie przekazania auta</b></label>
        <input type="text" name="notes" class="w3-input w3-border" value="${rent.notes}"
               form="returnForm" readonly>
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