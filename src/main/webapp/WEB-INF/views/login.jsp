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
    <header class="w3-container w3-theme-dark">
        <a href="/" class="w3-center w3-button w3-theme-dark w3-hover-indigo"><h1><b>Car rent</b></h1></a>
    </header>
​
<!-- menu po lewej -->
<div class="w3-sidebar w3-large w3-bar-block w3-theme" style="width:25%;top: 0px;margin-top: 90px;">


    <h4 class="w3-bar-item w3-theme-d3">sesja</h4>
    <a href="/login" class="w3-bar-item w3-button">zaloguj się</a>
</div>
<div class="w3-container" style="margin-left:25%;margin-top: -24px;">
​

<div class="w3-container w3-margin w3-card w3-border w3-theme-l4">
    <!-- tytuł -->
    <div class="w3-container w3-theme w3-margin-top w3-center w3-margin-bottom">
        <h2>strona logowania</h2>
    </div>


    <div class="w3-row-padding w3-margin-bottom w3-cell-row">

        <h3>Podaj dane do logowania</h3>
        <div class="w3-quarter w3-container w3-cell">
            <form name='loginForm'
                  action="<c:url value='/login' />" method='POST'>

                ${error ?  'Błędny użytkownik lub hasło' :''}

                <table>
                    <tr>
                        <td>Użytkownik:</td>
                        <td><input class=type='text' name='username'></td>
                    </tr>
                    <tr>
                        <td>Hasło:</td>
                        <td><input type='password' name='password'/></td>
                    </tr>
                    <tr>
                        <td colspan='2'><input name="submit" type="submit" value="zaloguj"/></td>
                    </tr>
                </table>

            </form>
        </div>
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