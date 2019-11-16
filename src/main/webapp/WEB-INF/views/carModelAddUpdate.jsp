<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Expression language jest włączony--%>
<%@ page isELIgnored="false" %>
<%--JSTL jest włączony--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>Car Rent Application</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-indigo.css">

<!-- źródło 
    https://www.w3schools.com/w3css/default.asp
-->

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
    <a href="${pageContext.request.contextPath}/car/model/" class="w3-bar-item w3-button">modelami samochodów</a>
    <a href="#" class="w3-bar-item w3-button">klientami</a>
    <a href="#" class="w3-bar-item w3-button">pracownikami</a>

</div>

<!-- właściwy widok -->
<div class="w3-container" style="margin-left:25%">
    <!-- tytuł   -->
    <h2 class="w3-bar w3-border w3-center w3-theme">Car Model View</h2>

    <!-- dodatkowe opcje i szukanie -->
    <div class="w3-bar w3-light-grey w3-border">
        <a href="${pageContext.request.contextPath}/car/model/" class="w3-bar-item w3-button w3-theme-d3">wróć</a>


    </div>

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
                    <td><input type="text" name="productionYear" value="${carModel.productionYear}"></td>
                    <td><input type="text" name="reviewInterval" value="${carModel.reviewInterval}"></td>
                    <td>
                        <input type="submit" value="zapisz" class="w4-button w3-theme"/>
                    </td>
                </form>
            </tr>
        </c:if>

    </table>
    ​
    ​
</div>
​
<footer class="w3-container w3-theme-l4"
        style="margin-left:25%; position: fixed; right: 0; bottom: 0; left: 0; padding: 1rem; background-color: #efefef; text-align: center;">
    <h5>Made by 4team © 2019</h5>
    <p>Projekt na zakończenie nauki w Software Development Academy</p>
</footer>
​
</body>

</html>
​