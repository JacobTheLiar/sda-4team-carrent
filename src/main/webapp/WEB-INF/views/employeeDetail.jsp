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

	<form method="post" class="w3-container w3-margin w3-card w3-border w3-theme-l4" id="employeeform">
        <!-- tytuł -->
        <div class="w3-container w3-theme w3-margin-top w3-center">
            <h2>${empty employee.username ? 'dodaj pracownika' : 'edytuj pracownika'}</h2>
        </div>

        <!-- dane -->
        <p>
            <label><b>imię</b></label>
            <input type="text" name="firstname" placeholder="imię" class="w3-input w3-border" value="${employee.firstname}">
        </p>
        <p>
            <label><b>nazwisko</b></label>
            <input type="text" name="surname" placeholder="nazwisko" class="w3-input w3-border" value="${employee.surname}">
        </p>
        <p>
            <label><b>punkt wypożyczeń</b></label>
            <select class="w3-input w3-border" name="rentPoint" form="employeeform">
                <option selected="selected" placeholder="wybierz punkt" value="${employee.rentPoint.id}">${employee.rentPoint.name}</option>
                <c:forEach var="rentPoint" items="${rentPoints}">
                    <option value="${rentPoint.id}">${rentPoint.name}</option>
                </c:forEach>
            </select>
        </p>
        <p>
            <label><b>login</b></label>
            <input type="text" name="username" placeholder="login" class="w3-input w3-border"  value="${employee.username}">
        </p>
        <p>
            <label><b>data zatrudnienia</b></label>
            <input type="date" name="employmentDate" placeholder="data zatrudnienia" class="w3-input w3-border" value="${employee.employmentDate}">
        </p>
        <p>
            <label><b>data odejścia</b></label>
            <input type="date" name="releaseDate" placeholder="data odejścia" class="w3-input w3-border" value="${employee.releaseDate}">
        </p>
        <p>
            <label><b>funkcja</b></label>
            <select class="w3-input w3-border" name="role" form="employeeform">
                <option selected="selected" placeholder="wybierz funkcje" value="${employee.role.id}">${employee.role.authority}</option>
                <c:forEach var="role" items="${roles}">
                    <option value="${role.id}">${role.authority}</option>
                </c:forEach>
            </select>
        </p>

        <p>
            <input type="submit" class="w3-button w3-red w3-right w3-large" value="zapisz">
            <a href="${pageContext.request.contextPath}/employee" class="w3-button w3-theme-l2">anuluj</a>
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