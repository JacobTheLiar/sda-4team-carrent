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
        <h2 class="w3-bar w3-border w3-center w3-theme">pracownicy</h2>

        <!-- dodatkowe opcje i szukanie -->
        <div class="w3-bar w3-light-grey w3-border">

            <a href="${pageContext.request.contextPath}/employee/add" class="w3-bar-item w3-button w3-green">dodaj</a>
            <a href="${pageContext.request.contextPath}/employee" class="w3-bar-item w3-button w3-theme-l2 w3-right w3-margin-left">usuń filtr</a>
            <form >
            <input type="submit" class="w3-bar-item w3-button w3-theme w3-right w3-margin-left" value="szukaj">
			<select class="w3-bar-item w3-select w3-border w3-right" name="searchBy">
			    <c:forEach var="option" items="${options}">
			        <option value="${option.name()}"${option.name()==param.searchBy ? ' selected' : ''}>${option.description}</option>
                </c:forEach>
			</select>
            <input type="text" class="w3-bar-item w3-input w3-border w3-right w3-margin-left" placeholder="szukaj..." name="searchWhat" value="${param.searchWhat}">
			</form>
        </div>

        ​<!-- dane -->
        <table class="w3-table w3-bordered w3-striped">
            <tr class="w3-theme-d4">
                <th>imię</th>
                <th>nazwisko</th>
                <th>punkt wypożyczeń</th>
                <th>login</th>
                <th>data zatrudnienia</th>
                <th>data odejścia</th>
                <th>funkcja</th>
                <th>opcje</th>
            </tr>
            <c:forEach var="employee" items="${employees}">
            <tr class="w3-center">
                <td>${employee.firstname}</td>
                <td>${employee.surname}</td>
                <td>${employee.rentPoint.name}</td>
                <td>${employee.username}</td>
                <td>${employee.employmentDate}</td>
                <td>${employee.releaseDate}</td>
                <td>${employee.role.authority}</td>

                <td><a href="${pageContext.request.contextPath}/employee/${employee.username}" class="w3-button w3-theme w3-tiny">edytuj</a></td>
            </tr>
            </c:forEach>
        </table>
        ​
        ​

    ​
<%@include file='footer.html'%>    ​
    ​
</body>

</html>
​