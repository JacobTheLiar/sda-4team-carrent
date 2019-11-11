<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Expression language jest włączony--%>
<%@ page isELIgnored="false" %>
<%--JSTL jest włączony--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Car Rent</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-indigo.css">

<body class="w3-theme-light">
    <!-- ​nagłowek -->
    <header class="w3-container w3-theme-dark">
        <h1>Car rent</h1>
    </header>
    ​
    <!-- menu po lewej -->
    <div class="w3-sidebar w3-large w3-bar-block w3-theme" style="width:25%">

        <h4 class="w3-bar-item w3-theme-d3">wypożyczenie</h4>
        <a href="#" class="w3-bar-item w3-button">wypożycz</a>
        <a href="#" class="w3-bar-item w3-button">zwróć</a>
        <a href="#" class="w3-bar-item w3-button">historia wypożyczeń</a>
        <a href="#" class="w3-bar-item w3-button">klienci</a>
        <a href="#" class="w3-bar-item w3-button">faktury</a>
        <br>
        <h4 class="w3-bar-item w3-theme-d3">zarządzanie</h4>
        <a href="#" class="w3-bar-item w3-button">promocjami</a>
        <a href="#" class="w3-bar-item w3-button">samochodami</a>
        <a href="#" class="w3-bar-item w3-button w3-theme-l1">klientami</a>
        <a href="#" class="w3-bar-item w3-button">pracownikami</a>

    </div>

    <!-- właściwy widok -->
    <div class="w3-container" style="margin-left:25%">
        <!-- tytuł   -->
        <h2 class="w3-bar w3-border w3-center w3-theme">zarządzaj klientami</h2>

        <!-- dodatkowe opcje i szukanie -->
        <div class="w3-bar w3-light-grey w3-border">
            <a href="#" class="w3-bar-item w3-button w3-theme-d3">wróć</a>
            <a href="#" class="w3-bar-item w3-button w3-green">dodaj</a>
            <button class="w3-bar-item w3-button w3-theme-l2 w3-right">szukaj</button>
            <input type="text" class="w3-bar-item w3-input w3-right" placeholder="szukaj...">
        </div>

        ​
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

                <td><a href="#" class="w3-button w3-theme">popraw</a>
                    <a href="#" class="w3-button w3-theme">faktury</a></td>
            </tr>
            </c:forEach>
        </table>
        ​
        ​
    </div>
    ​
    <footer class="w3-container w3-theme-l4"
        style="margin-left:25%;">
        <h5>Made by 4team © 2019</h5>
        <p>Projekt na zakończenie naluki w Software Development Academy</p>
    </footer>
    ​
</body>

</html>
​