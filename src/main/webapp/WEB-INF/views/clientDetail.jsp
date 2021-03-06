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

	<form method="post" class="w3-container w3-margin w3-card w3-border w3-theme-l4">
        <!-- tytuł -->
        <div class="w3-container w3-theme w3-margin-top w3-center">
            <h2>${empty client.name ? 'dodaj klienta' : 'edytuj klienta'}</h2>
        </div>

        <!-- dane -->
        <p>
            <label><b>nazwa</b></label>
            <input type="text" name="name" placeholder="nazwa" class="w3-input w3-border" value="${client.name}">
        </p>
        <p>
            <label><b>adres</b></label>
            <input type="text" name="address" placeholder="adres" class="w3-input w3-border" value="${client.address}">
        </p>
        <p>
            <label><b>kod pocztowy</b></label>
            <input type="text" name="postCode" placeholder="kod pocztowy" class="w3-input w3-border"  value="${client.postCode}">
        </p>
        <p>
            <label><b>miasto</b></label>
            <input type="text" name="city" placeholder="miasto" class="w3-input w3-border"  value="${client.city}">
        </p>
        <p>
            <label><b>nip</b></label>
            <input type="text" name="taxNumber" placeholder="NIP" class="w3-input w3-border" value="${client.taxNumber}">
        </p>
        <p>
            <label><b>e-mail</b></label>
            <input type="text" name="email" placeholder="e-mail" class="w3-input w3-border" value="${client.email}">
        </p>
        <p>
            <label><b>nr telefonu</b></label>
            <input type="text" name="telephoneNr" placeholder="nr telefonu" class="w3-input w3-border" value="${client.telephoneNr}">
        </p>

        <p>
            <input type="submit" class="w3-button w3-red w3-right w3-large" value="zapisz">
            <a href="${pageContext.request.contextPath}/client" class="w3-button w3-theme-l2">anuluj</a>
        </p>
				
	</form>
        ​
        ​

    ​
<%@include file='footer.html'%>    ​
    ​
</body>

</html>
​