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

	<div class="w3-container w3-margin w3-card w3-border w3-theme-l4">
        <!-- tytuł -->
        <div class="w3-container w3-theme w3-margin-top w3-center w3-margin-bottom">
            <h2>strona główna</h2>
        </div>

        <!-- dane -->
        <div class="w3-row-padding w3-margin-bottom w3-cell-row">
            <div class="w3-quarter w3-container w3-cell">
                <div class="w3-card  w3-theme-light">
                    <header class="w3-container w3-theme">
                      <h1>samochody</h1>
                    </header>

                    <div class="w3-container">
                      <p>wyświetl listę dostępnych samochodów i umożliwia jego wypożyczenie lub zwrot</p>
                    </div>

                    <footer class="w3-container w3-theme w3-padding w3-cell-row">
                        <div class="w3-cell w3-padding">
                            <a href="${pageContext.request.contextPath}/borrow" class="w3-button w3-theme-dark">wypożycz</a>
                        </div>
                        <div class="w3-cell w3-padding">
                            <a href="${pageContext.request.contextPath}/return" class="w3-button w3-theme-dark">zwrot</a>
                        </div>
                    </footer>
                </div>
            </div>
            <div class="w3-quarter w3-container w3-cell">
                <div class="w3-card  w3-theme-light">
                    <header class="w3-container w3-theme">
                      <h1>klienci</h1>
                    </header>

                    <div class="w3-container">
                      <p>wyświetl listę naszych klientów i faktur, które zostały wystawione na danego klienta</p>
                    </div>

                    <footer class="w3-container w3-theme w3-padding w3-cell-row">
                        <div class="w3-cell w3-padding">
                            <a href="${pageContext.request.contextPath}/client" class="w3-button w3-theme-dark">klienci</a>
                        </div>
                        <div class="w3-cell w3-padding">
                            <a href="${pageContext.request.contextPath}/invoice" class="w3-button w3-theme-dark">faktury</a>
                        </div>
                    </footer>
                </div>
            </div>
            <div class="w3-quarter w3-container w3-cell">
                <div class="w3-card  w3-theme-light">
                    <header class="w3-container w3-theme">
                      <h1>serwis</h1>
                    </header>

                    <div class="w3-container">
                      <p>umożliwia zarządzanie modelami samochodów oraz samochadami i ich przeglądami</p>
                    </div>

                    <footer class="w3-container w3-theme w3-padding w3-cell-row">
                        <div class="w3-cell w3-padding">
                            <a href="${pageContext.request.contextPath}/car" class="w3-button w3-theme-dark">samochody</a>
                        </div>
                        <div class="w3-cell w3-padding">
                            <a href="${pageContext.request.contextPath}/car/model" class="w3-button w3-theme-dark">modele</a>
                        </div>
                    </footer>
                </div>
            </div>
            <div class="w3-quarter w3-container w3-cell">
                <div class="w3-card  w3-theme-light">
                    <header class="w3-container w3-theme">
                      <h1>pracownicy</h1>
                    </header>

                    <div class="w3-container">
                      <p>umożliwia zarządzanie pracownikami i punktami wypożyczeń</p>
                    </div>

                    <footer class="w3-container w3-theme w3-padding w3-cell-row">
                        <div class="w3-cell w3-padding">
                            <a href="${pageContext.request.contextPath}/employee" class="w3-button w3-theme-dark">pracownicy</a>
                        </div>
                        <div class="w3-cell w3-padding">
                            <a href="${pageContext.request.contextPath}/rentPoint" class="w3-button w3-theme-dark">punkty</a>
                        </div>
                    </footer>
                </div>
            </div>
        </div>


	</div>
        ​
        ​

    ​
<%@include file='footer.html'%>    ​
    ​
</body>

</html>
​