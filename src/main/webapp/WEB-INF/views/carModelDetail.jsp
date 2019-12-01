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
<h2 class="w3-bar w3-border w3-center w3-theme">dodanie/edycja modelu samochodu</h2>

<!-- dodatkowe opcje i szukanie -->
<div class="w3-bar w3-light-grey w3-border">

    <a href="${pageContext.request.contextPath}/car/model/" class="w3-bar-item w3-button w3-green">anuluj</a>

</div>

​<!-- dane -->
<!-- właściwa treść -->
<p>widok pozwala na edycję i dodanie nowego modelu</p>
​
<table class="w3-table w3-bordered w3-striped">
    <tr class="w3-theme-d4">
        <th>Marka</th>
        <th>Model</th>
        <th>Segment</th>
        <th>Typ</th>
        <th>Rok produkcji</th>
        <th>Przegląd co ile km</th>
        <th>opcje</th>
    </tr>


    <c:if test="${!update}">
        <tr>
            <form method="post" action="${pageContext.request.contextPath}/car/model/save" modelAttribute="carModel">
                <td><input type="text" name="mark" placeholder="wpisz markę"></td>
                <td><input type="text" name="model" placeholder="wpisz model"></td>
                <td><input type="text" name="segment" placeholder="wpisz segment"></td>
                <td><input type="text" name="type" placeholder="wpisz typ"></td>
                <td><input type="text" name="productionYear" placeholder="wpisz rok produkcji"></td>
                <td><input type="text" name="reviewInterval" placeholder="wpisz co ile km wymagany przegląd"></td>
                <td>
                    <input type="submit" value="zapisz" class="w4-button w3-theme"/>
                </td>
            </form>
        </tr>
    </c:if>

    <c:if test="${update}">
        <tr>
            <form method="post" action="${pageContext.request.contextPath}/car/model/save" modelAttribute="carModel">
                <input type="hidden" name="id" value="${carModel.id}">
                <td><input type="text" name="mark" value="${carModel.mark}"></td>
                <td><input type="text" name="model" value="${carModel.model}"></td>
                <td><input type="text" name="segment" value="${carModel.segment}"></td>
                <td><input type="text" name="type" value="${carModel.type}"></td>
                <td><input type="number" name="productionYear" value="${carModel.productionYear}"></td>
                <td><input type="number" name="reviewInterval" value="${carModel.reviewInterval}"></td>
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