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

            <a href="${pageContext.request.contextPath}/client/add" class="w3-bar-item w3-button w3-green">dodaj</a>
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
                <th>nr faktury</th>
                <th>data faktury</th>
                <th>liczba wypożyczeń</th>
                <th>wartość wypożyczenia</th>
                <th>liczba zniżek</th>
                <th>wartość po zniżkach</th>
                <th>do zapłaty</th>
            </tr>
            <c:forEach var="invoice" items="${invoices}">
            <tr class="w3-center">
                <td>${invoice.client.name}</td>
                <td>${invoice.number}</td>
                <td>${invoice.invoiceDate}</td>
                <td>${invoice.rentCount}</td>
                <td>${invoice.rentValue}</td>
                <td>${invoice.discounts}</td>
                <td>${invoice.value}</td>
                <td>${invoice.toPay}</td>

                <td><a href="${pageContext.request.contextPath}/client/${invoice.id}" class="w3-button w3-theme w3-tiny">podgląd</a>
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