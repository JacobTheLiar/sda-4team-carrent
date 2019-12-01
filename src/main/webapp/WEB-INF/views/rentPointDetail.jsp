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


<!-- tytuł -->
<h2 class="w3-bar w3-border w3-center w3-theme">dodanie/edycja punktu wypożyczalni</h2>

<!-- dodatkowe opcje i szukanie -->
<div class="w3-bar w3-light-grey w3-border">

    <a href="${pageContext.request.contextPath}/rentPoint/" class="w3-bar-item w3-button w3-green">anuluj</a>

</div>

​<!-- dane -->
<table class="w3-table w3-bordered w3-striped">
    <tr class="w3-theme-d4">
        <th>nazwa</th>
        <th>address</th>
        <th>kod pocztowy</th>
        <th>miasto</th>
        <th>opcje</th>
    </tr>


    <tr>
        <form method="post" action="${pageContext.request.contextPath}/rentPoint/save">
            <input type="hidden" name="id" value="${rentPoint.id}">
            <td><input type="text" name="name" value="${rentPoint.name}" placeholder="wpisz nazwę..."></td>
            <td><input type="text" name="address" value="${rentPoint.address}" placeholder="wpisz adres..."></td>
            <td><input type="text" name="postCode" value="${rentPoint.postCode}" placeholder="wpisz kod pocztowy..."></td>
            <td><input type="text" name="city" value="${rentPoint.city}" placeholder="wpisz miasto..."></td>
            <td>
                <input type="submit" value="zapisz" class="w4-button w3-theme"/>
            </td>
        </form>
    </tr>
  </table>
​
​​
<%@include file='footer.html' %>
​​
</body>

</html>
​