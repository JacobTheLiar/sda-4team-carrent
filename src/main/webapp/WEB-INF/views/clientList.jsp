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
        <h2 class="w3-bar w3-border w3-center w3-theme">zarządzaj klientami</h2>

        <!-- dodatkowe opcje i szukanie -->
        <div class="w3-bar w3-light-grey w3-border">

            <a href="./add" class="w3-bar-item w3-button w3-green">dodaj</a>
            <a href="." class="w3-bar-item w3-button w3-theme-l2  w3-right">usuń filtr</a>
            <form >
            <input type="submit" class="w3-bar-item w3-button w3-theme w3-right" value="szukaj">
            <input type="text" class="w3-bar-item w3-input w3-right" placeholder="szukaj..." name="searchWhat">
			<select class="w3-bar-item w3-input w3-right" name="searchBy">
			    <c:forEach var="option" items="${options}">
			        <option value="${option.name()}">${option.description}</option>
			    </c:forEach>
			</select>
			</form>
        </div>

        ​<!-- dane -->
        <table class="w3-table w3-bordered w3-striped">
            <tr class="w3-theme-d4">
                <th>nazwa</th>
                <th>adres</th>
                <th>kod pocztowy</th>
                <th>miasto</th>
                <th>nip</th>
                <th>e-mail</th>
                <th>nr telefonu</th>
                <th>opcje</th>
            </tr>
            <c:forEach var="client" items="${clients}">
            <tr class="w3-center">
                <td>${client.name}</td>
                <td>${client.address}</td>
                <td>${client.postCode}</td>
                <td>${client.city}</td>
                <td>${client.taxNumber}</td>
                <td>${client.email}</td>
                <td>${client.telephoneNr}</td>

                <td><a href="#" class="w3-button w3-theme">edytuj</a>
                    <a href="#" class="w3-button w3-theme">faktury</a></td>
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