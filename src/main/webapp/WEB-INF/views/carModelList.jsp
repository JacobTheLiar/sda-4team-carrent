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
<h2 class="w3-bar w3-border w3-center w3-theme">zarządzanie modelami samochodów</h2>

<!-- dodatkowe opcje i szukanie -->
<div class="w3-bar w3-light-grey w3-border">

    <a href="${pageContext.request.contextPath}/car/model/add" class="w3-bar-item w3-button w3-green">dodaj</a>
    <c:if test="${isFiltered}">
        <a href="${pageContext.request.contextPath}/car/model/" class="w3-bar-item w3-button w3-theme-l2 w3-right w3-margin-left">usuń filtr</a>
    </c:if>
    <form>
        <input type="submit" class="w3-bar-item w3-button w3-theme w3-right w3-margin-left" value="szukaj">
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
        <th>marka</th>
        <th>model</th>
        <th>segment</th>
        <th>typ</th>
        <th>rok produkcji</th>
        <th>przegląd co km</th>
        <th>opcje</th>
    </tr>

    <c:forEach items="${carModels}" var="carModel">

        <tr>
            <td>${carModel.mark}</td>
            <td>${carModel.model}</td>
            <td>${carModel.segment}</td>
            <td>${carModel.type}</td>
            <td>${carModel.productionYear}</td>
            <td>${carModel.reviewInterval}</td>
            <td>
                <a class="w3-button w3-theme w3-tiny" href="${pageContext.request.contextPath}/car/model/${carModel.id}">edytuj</a>
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