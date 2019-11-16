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
        <h2 class="w3-bar w3-border w3-center w3-theme">dodaj klienta</h2>

        <!-- dodatkowe opcje i szukanie -->
        <div class="w3-bar w3-light-grey w3-border">
            <a href=".." class="w3-bar-item w3-button w3-theme">wróć</a>
        </div>

        ​<!-- dane -->
        <table class="w3-table w3-bordered w3-striped"  width="75%">
            <tr class="w3-theme-d4">
            </tr>
			
            <tr class="w3-center">
			<form method="post">
				<tr>
                <th class="w3-theme-d4" width="25%">nazwa</th>
                <td><input type="text" name="name" placeholder="nazwa" class="w3-input"></td>
				</tr>
				<tr>
                <th class="w3-theme-d4">adres</th>
                <td><input type="text" name="address" placeholder="adres" class="w3-input"></td>
				</tr>
				<tr>
                <th class="w3-theme-d4">kod pocztowy</th>
                <td><input type="text" name="postalCode" placeholder="kod pocztowy" class="w3-input"></td>
				</tr>
				<tr>
                <th class="w3-theme-d4">miasto</th>
                <td><input type="text" name="city" placeholder="miasto" class="w3-input"></td>
				</tr>
				<tr>
                <th class="w3-theme-d4">nip</th>
                <td><input type="text" name="taxNumber" placeholder="NIP" class="w3-input"></td>
				</tr>
				<tr>
                <th class="w3-theme-d4">e-mail</th>
                <td><input type="text" name="email" placeholder="e-mail" class="w3-input"></td>
				</tr>
				<tr>
                <th class="w3-theme-d4">nr telefonu</th>
                <td><input type="text" name="telephoneNr" placeholder="nr telefonu" class="w3-input"></td>
				</tr>
				<tr>

                <td colspan="2" class="w3-theme-l2"><a href="#" class="w3-button w3-red w3-right">zapisz</a>
				</tr>
				
				</form>
            </tr>

        </table>
        ​
        ​

    ​
<%@include file='footer.html'%>    ​
    ​
</body>

</html>
​