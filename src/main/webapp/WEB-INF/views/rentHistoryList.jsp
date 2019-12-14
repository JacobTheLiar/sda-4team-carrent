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
        <h2 class="w3-bar w3-border w3-center w3-theme">historia wypożyczeń</h2>

        <!-- dodatkowe opcje i szukanie -->
        <div class="w3-bar w3-light-grey w3-border">

            <a href="${pageContext.request.contextPath}/rent/history" class="w3-bar-item w3-button w3-theme-l2 w3-right w3-margin-left">usuń filtr</a>
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
                <th>id</th>
                <th>imię klienta</th>
                <th>mail klienta</th>
                <th>marka samochodu</th>
                <th>nr rej. auta</th>
                <th>wydawał</th>
                <th>wypożyczenie</th>
                <th>odbierał</th>
                <th>zwrot</th>
                <th>nr faktury</th>

            </tr>
            <c:forEach var="rentHistory" items="${rentHistory}">
            <tr class="w3-center">
                <td>${rentHistory.id}</td>
                <td>${rentHistory.client.name}</td>
                <td>${rentHistory.client.email}</td>
                <td>${rentHistory.car.carModel.mark}</td>
                <td>${rentHistory.car.plateNr}</td>
                <td>${rentHistory.employeeStart.username}</td>
                <td>${rentHistory.rentPointStart.name}</td>
                <td>${rentHistory.employeeEnd.username}</td>
                <td>${rentHistory.rentPointEnd.name}</td>
                <td>${rentHistory.invoice.number}</td>
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