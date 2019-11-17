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
<%@include file='menu.html'%>

​<form method="post" class="w3-container w3-margin w3-card w3-border w3-theme-l4"  id="promotionform">
    <!-- tytuł -->
    <div class="w3-container w3-theme w3-margin-top w3-center">
        <h2>${empty promotion.name ? 'dodaj promocje' : 'edytuj promocje'}</h2>
    </div>

    <!-- dane -->
    <p>
        <label><b>Nazwa</b></label>
        <input type="text" name="name" placeholder="nazwa" class="w3-input w3-border" value="${promotion.name}">
    </p>
    <p>
        <label><b>Rabat</b></label>
        <input type="number" name="discountPercentage" placeholder="rabat" class="w3-input w3-border" value="${promotion.discountPercentage}">
    </p>
    <p>
        <label><b>Auto</b></label>

        <select name="cars" multiple form="promotionform">
        <c:forEach var="car" items="${cars}">
            <option value="${car.id}">${car}</option>
        </c:forEach>
        </select>

    </p>
    <p>
        <label><b>Klient</b></label>
        <select name="clients" multiple form="promotionform">
            <c:forEach var="client" items="${clients}">
                <option value="${client.id}">${client}</option>
            </c:forEach>
        </select>
    </p>
    <p>
        <label><b>Start Promocji</b></label>
        <input type="date" name="promoStart" placeholder="startpromocji" min="2019-10-01T00:00" class="w3-input w3-border" value="${promotion.promoStart}">
    </p>
    <p>
        <label><b>Koniec Promocji</b></label>
        <input type="date" name="promoEnd" placeholder="koniecpromocji" max="2050-10-01T00:00" class="w3-input w3-border" value="${promotion.promoEnd}">
    </p>

    <p>
        <input type="submit" class="w3-button w3-red w3-right w3-large" value="zapisz">
        <a href="${pageContext.request.contextPath}/promotion" class="w3-button w3-theme-l2">anuluj</a>
    </p>


</form>

<%@include file='footer.html'%>

</body>
</html>
