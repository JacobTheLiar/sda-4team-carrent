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
        <div class="w3-container w3-amber w3-margin-top w3-center">
            <h2>błąd</h2>
        </div>

        <!-- dane -->
        <div class="w3-panel w3-khaki">
            <h4><b>${className}</b></h4>
            <p>${message}</p>
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