<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Carwash Service</title>
</head>
<body>

    <table>
        <tr>
            <th>Имя клиента</th>
            <th>Услуга</th>
            <th>Запись</th>
        </tr>
        <c:forEach var="client" items="${customerList}">
            <tr>
                <td>${client.clientName}</td>
                <td>${client.serviceName}</td>
                <td>${client.time}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>