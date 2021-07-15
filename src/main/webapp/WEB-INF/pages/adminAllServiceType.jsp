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
                <a href="/admin/edit/${serviceType.id}">Редактировать</a>
                <a href="/admin/delete/${serviceType.id}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>

<c:url value="/admin/add" var="add"/>
<a href="${add}">Добавить новую услугу</a>

<br>
    <c:url value="/admin/calendar" var="add"/>
    <a href="${add}">Журнал записи</a>
</br>

</body>
</html>