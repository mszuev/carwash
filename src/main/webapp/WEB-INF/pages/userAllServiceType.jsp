<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Carwash Service</title>
</head>
<body>

<h2>Услуги</h2>
    <table>
        <tr>
            <th>Услуга</th>
            <th>Стоимость</th>
        </tr>
        <c:forEach var="serviceType" items="${serviceTypeList}">
            <tr>
                <td>${serviceType.serviceName}</td>
                <td>${serviceType.cost}</td>
                <td>
                    <a href="/user/signup/${serviceType.id}">Записаться</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>