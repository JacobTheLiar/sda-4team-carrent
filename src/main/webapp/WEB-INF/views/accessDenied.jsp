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

<div class="w3-container w3-margin w3-card w3-border w3-theme-l4">
    <!-- tytuł -->
    <div class="w3-container w3-orange w3-margin-top w3-center w3-margin-bottom">
        <h2>brak dostępu</h2>
    </div>


    <div class="w3-row-padding w3-margin-bottom w3-cell-row">

        <p>
            <button class="w3-button w3-light-green" onclick="goBack()">wróć na poprzednią stronę</button>
            <a href="/" class="w3-button w3-light-blue w3-right">wróć na stronę główną</a>
            <script>
                function goBack() {
                    window.history.back();
                }
            </script>
        </p>
    </div>
    <!-- dane -->


</div>
​
​

​
<%@include file='footer.html' %>
​
​
</body>

</html>
​