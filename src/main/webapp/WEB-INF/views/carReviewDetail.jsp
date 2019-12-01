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

    <a href="${pageContext.request.contextPath}/car/" class="w3-bar-item w3-button w3-green">anuluj</a>

</div>

​<!-- dane -->
<table class="w3-table w3-bordered w3-striped">
    <tr class="w3-theme-d4">
        <th>samochód</th>
        <th>stan licznika</th>
        <th>data przeglądu</th>
        <th>uwagi</th>
        <th>opcje</th>
    </tr>


    <tr>
        <form method="post" action="${pageContext.request.contextPath}/carReview/save">
            <input type="hidden" name="id" value="${carReview.id}">
            <input type="hidden" name="carId" value="${car.id}">
            <td><input type="text" name="car" value="${car}"  readonly></td>
            <td><input type="number" name="counterState" value="${carReview.counterState}"
                       placeholder="wpisz stan licznika..."></td>
            <td><input type="date" name="reviewDate" value="${carReview.reviewDate}" max="${todayDate}"
                       placeholder="wpisz datę przeglądu..."></td>
            <td><input type="text" name="notes" value="${carReview.notes}"></td>
            <td>
                <input type="submit" value="zapisz" class="w4-button w3-theme"/>
            </td>
        </form>
    </tr>
</table>
​
​​
<%@include file='footer.html' %>
​​
</body>

</html>
​