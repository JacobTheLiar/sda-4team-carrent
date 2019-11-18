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
​
<form method="post" class="w3-container w3-margin w3-card w3-border w3-theme-l4"
      action="${pageContext.request.contextPath}/rent/return/" id="returnForm">
    <!-- tytuł -->
    <div class="w3-container w3-theme w3-margin-top w3-center">
        <h2>oddanie samochodu</h2>
    </div>

    <!-- dane -->
    <p>
        <label><b>podaj numer rejetracyjny zwracanego samochodu</b></label>
        <input type="text" name="plateNr" class="w3-input w3-border" placeholder="wpisz numer rejestracyjny"
               form="returnForm" >
    </p>
    <p>
        <input type="submit" class="w3-button w3-red w3-right w3-large" value="zatwierdź">
        <a href="${pageContext.request.contextPath}/rent/" class="w3-button w3-theme-l2">anuluj</a>
    </p>

    ​
    <%@include file='footer.html' %>
    ​
    ​
</body>

</html>
​