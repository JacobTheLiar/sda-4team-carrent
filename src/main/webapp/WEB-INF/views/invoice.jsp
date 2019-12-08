<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Expression language jest włączony--%>
<%@ page isELIgnored="false" %>
<%--JSTL jest włączony--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<!-- source A4 page css https://codepen.io/rafaelcastrocouto/pen/LFAes -->
<head>
    <title>podgląd faktury</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../invoice.css">
</head>

<body>

    <page size="A4">

        <div class="cr-invoice-nr">
            <h1>FAKTURA VAT nr <b>xxx/x</b></h1>
        </div>

        <div class="cr-invoice-place">
            Poznań, 88-88-8888
        </div>


        <div class="cr-company-seller">
            <b>sprzedający</b><br />
            mieczysław prędki<br />
            ul. Niewidoma 44 <br />
            00-000 Wygwizdajewo

        </div>
        <div class="cr-company-buyer">
            <b>kupujący</b><br />
            mieczysław prędki<br />
            ul. Niewidoma 44 <br />
            00-000 Wygwizdajewo

        </div>

        <div>
            termin płatności:<b> 88-88-8888</b><br />
            metoda płatności:<b> przelew</b><br />
            przelew na rachunek: <b>PL888888888888</b>
        </div>

        <div class="ct-table-div">
            <table class="cr-table">
                <tr class="cr-center-text">
                    <th class="cr-table-cell-1">lp.</th>
                    <th class="cr-table-cell-rest">opis</th>
                    <th class="cr-table-cell-1">zniżka</th>
                    <th class="cr-table-cell-2 ">wartość</th>
                </tr>
                <tr>
                    <td class="cr-right-text">1.</td>
                    <td class="cr-left-text">wypożyczenie Opla</td>
                    <td class="cr-center-text">30%</td>
                    <td class="cr-right-text">12.34</td>
                </tr>
            </table>
        </div>

        <div>razem do zapłaty: <b>12.23</b><br /><br /></div>

        <div class="cr-seller-sign">podpis wystawcy</div>

        <div>podpis kupującego</div>

    </page>

</body>

</html>