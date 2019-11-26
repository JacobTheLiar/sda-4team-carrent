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
<%@include file='menu.html'%>    ​


        <!-- tytuł -->
        <h2 class="w3-bar w3-border w3-center w3-theme">klienci</h2>

        <!-- dodatkowe opcje i szukanie -->
        <div class="w3-bar w3-light-grey w3-border">

            <a href="${pageContext.request.contextPath}/client/${clientId}" class="w3-bar-item w3-button w3-green">faktury</a>
            <a href="${pageContext.request.contextPath}/client" class="w3-bar-item w3-button w3-theme-l2 w3-right w3-margin-left">usuń filtr</a>
            <form >
            <input type="submit" class="w3-bar-item w3-button w3-theme w3-right w3-margin-left" value="szukaj">
			<select class="w3-bar-item w3-select w3-border w3-right" name="searchBy">
			    <c:forEach var="option" items="${options}">
			        <option value="${option.name()}"${option.name()==param.searchBy ? ' selected' : ''}>${option.description}</option>
                </c:forEach>
			</select>
            <input type="text" class="w3-bar-item w3-input w3-border w3-right w3-margin-left" placeholder="szukaj..." name="searchWhat" value="${param.searchWhat}">
			</form>
        </div>

        ​<!-- dane -->
        <table class="w3-table w3-bordered w3-striped">
            <tr class="w3-theme-d4">
                <th>nazwa klienta</th>
                <th>wypożyczony dnia</th>
                <th>przez dni</th>
                <th>zwrócony dnia</th>
                <th>dystans</th>
                <th>zastosowana promocja</th>
                <th>samochód</th>
                <th>wartość wypożyczenia</th>
                <th>wartoś po zniżkach</th>
                <th>zaznacz</th>
            </tr>
            <c:forEach var="invoice" items="${available}">
            <tr class="w3-center">
                <td>${invoice.clientName}</td>
                <td>${invoice.rentTimeStart}</td>
                <td>${invoice.rentDays}</td>
                <td>${invoice.rentTimeEnd}</td>
                <td>${invoice.distance}</td>
                <td>${invoice.promotionName}</td>
                <td>${invoice.car}</td>
                <td>${invoice.rentValue}</td>
                <td>${invoice.value}</td>

                <td><input class="w3-check" type="checkbox" name="rentHistoryId" value="${invoice.id}">wybierz</td>
            </tr>
            </c:forEach>
        </table>
        ​
        ​

    ​
<%@include file='footer.html'%>    ​
    ​
</body>

</html>
​