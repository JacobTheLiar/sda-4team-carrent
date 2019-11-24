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