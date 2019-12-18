<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Expression language jest włączony--%>
<%@ page isELIgnored="false" %>
<%--JSTL jest włączony--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<!-- source A4 page css https://codepen.io/rafaelcastrocouto/pen/LFAes -->
<head>
    <title>podgląd faktury - ${invoice.invoiceNumber}</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/invoice.css">
</head>

<body>

    <page size="A4">

        <div class="cr-invoice-nr">
            <h1>FAKTURA nr <b>${invoice.invoiceNumber}</b></h1>
        </div>

        <div class="cr-invoice-place">
            ${invoice.invoiceCity}, ${invoice.invoiceDate}
        </div>


        <div class="cr-company-seller">
            <b>sprzedający</b><br />
            ${invoice.sellerName}<br />
            ${invoice.sellerAddress}<br />
            ${invoice.sellerPostCode} ${invoice.sellerCity}<br /><br />
            <b>NIP:</b> ${invoice.sellerTaxNumber}

        </div>
        <div class="cr-company-buyer">
            <b>kupujący</b><br />
            ${invoice.clientName}<br />
            ${invoice.clientAddress}<br />
            ${invoice.clientPostCode} ${invoice.clientCity}<br /><br />
            <b>NIP:</b> ${invoice.clientTaxNumber}

        </div>

        <div>
            termin płatności: <b>${invoice.paymentDate}</b><br />
            metoda płatności: <b>${invoice.paymentMethod}</b><br />
            przelew na rachunek: <b>${invoice.paymentAccount}</b>
        </div>

        <div class="ct-table-div">
            <table class="cr-table">
                <tr class="cr-center-text">
                    <th class="cr-table-cell-rest">wypożyczony samochód</th>
                    <th class="cr-table-cell-2">dystans</th>
                    <th class="cr-table-cell-1">ilość dni</th>
                    <th class="cr-table-cell-3 ">zastosowana promocja</th>
                    <th class="cr-table-cell-2 ">wartość</th>
                </tr>

                <c:forEach var="item" items="${items}">

                <tr>
                    <td class="cr-left-text">${item.car}</td>
                    <td class="cr-right-text">${item.distance}</td>
                    <td class="cr-center-text">${item.rentDays}</td>
                    <td class="cr-left-text">${item.promotionName}</td>
                    <td class="cr-right-text">${item.value}</td>
                </tr>

                </c:forEach>
            </table>
        </div>

        <div>razem do zapłaty: <b>${invoice.paymentValue}</b><br /><br /></div>

        <div class="cr-seller-sign">podpis wystawcy</div>

        <div>podpis kupującego</div>

    </page>

</body>

</html>