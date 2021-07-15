<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Запись на автомойку</title>
</head>
    <body>

    <h2>${userinfo.serviceName}</h2>

    <c:url value="/user/signup" var="var"/>
        <form action = "${var}" method = "POST">
            <table>
                <tr>
                    <td><label for="clientName">Ваше имя</label>
                    <input type="text" name ="clientName" id ="clientName"/></td>
                </tr>

                <tr>
                    <td><input type="hidden" name ="serviceName" id ="serviceName" value="${userinfo.serviceName}"/></td>
                </tr>

                <tr>
                    <td>Выберите время

                        <label for="time"></label>
                        <select name = "time" id ="time">
                            <option value = "9:00">9:00</option>
                            <option value = "11:00">11:00</option>
                            <option value = "13:00">13:00</option>
                            <option value = "15:00">15:00</option>
                            <option value = "17:00">17:00</option>
                            <option value = "19:00">19:00</option>
                        </select>
                    </td>
                </tr>
            </table>
                <input type="submit" value="Записаться">

        </form>
    </body>
</html>