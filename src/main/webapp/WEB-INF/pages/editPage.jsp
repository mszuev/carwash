<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty service.serviceName}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty service.serviceName}">
        <title>Edit</title>
    </c:if>
</head>
    <body>
    <c:if test="${empty service.serviceName}">
        <c:url value="/admin/add" var="var"/>
    </c:if>

    <c:if test="${!empty service.serviceName}">
        <c:url value="/admin/edit" var="var"/>
    </c:if>
        <form action="${var}" method="POST">
            <c:if test="${!empty service.serviceName}">
                <input type="hidden" name="id" value="${service.id}">
            </c:if>

                <label for="serviceName">Название услуги</label>
                <input type="text" name="serviceName" id="serviceName" value="${service.serviceName}">

                <label for="cost">Стоимость</label>
                <input type="text" name="cost" id="cost" value="${service.cost}">

            <c:if test="${empty service.serviceName}">
                <input type="submit" value="Добавить услугу">
            </c:if>
            <c:if test="${!empty service.serviceName}">
                <input type="submit" value="Редактировать услугу">
            </c:if>
        </form>
    </body>
</html>