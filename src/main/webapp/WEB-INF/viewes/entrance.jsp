<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href=<c:url value="'resources/css/entrance.css'"/>/>

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script type="text/javascript" src=<c:url value="'resources/js/start.js'" />></script>
</head>
<body>


<div class="door">
    <img class="key" src='resources/images/key.png' title='Открой дверь'>
</div>

<div id="envelope" class="envelope">
    <div class="title">Открыть дверь</div>
    <div class= "wrapper-close-btn">
        <div class="close-btn"></div>
    </div>
    <table>
        <tr>
            <td>Почта</td>
            <td>
                <input id="mail"/>
            </td>
        </tr>
        <tr>
            <td>Пароль</td>
            <td>
                <input id="password" type="password"/>
            </td>
        </tr>
    </table>
    <input type="button" value="OK" style = "margin-left:45%" id="submit"/>
</div>
</body>
</html>
