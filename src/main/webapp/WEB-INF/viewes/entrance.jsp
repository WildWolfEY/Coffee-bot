<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href=<c:url value="'resources/css/entrance.css'"/>/>

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script type="text/javascript" src=<c:url value="'resources/js/start.js'"/>></script>
</head>
<body>


<div class="door">
    <img class="key" src='resources/images/key.png' title='Открой дверь'>
    <img class="node" src='resources/images/node.png' title='Запишись'>
</div>

<div id="envelope" class="envelope">
    <div class="title">Открыть дверь</div>
    <div class="wrapper-close-btn">
        <div class="close-btn"></div>
    </div>

    <table id="tbl_entrance">
        <tr>
            <td>Почта</td>
            <td>
                <input id="ent_mail"/>
            </td>
        </tr>
        <tr>
            <td>Пароль</td>
            <td>
                <input id="ent_pwd" type="password"/>
            </td>
        </tr>
    </table>


    <table id="tbl_registrate">
        <tr>
            <td>Имя</td>
            <td>
                <input id="reg_name"/>
            </td>
        </tr>
        <tr>
            <td>Почта</td>
            <td>
                <input id="reg_mail"/>
            </td>
        </tr>
        <tr>
            <td>Пароль</td>
            <td>
                <input id="reg_pwd1" type="password"/>
            </td>
        </tr>
        <tr>
            <td>Подтвердите пароль</td>
            <td>
                <input id="reg_pwd2" type="password"/>
            </td>
        </tr>
        <tr>
            <td>Пол</td>
            <td>
                <select id="reg_sex">
                    <option value="M" selected="selected">Мужской</option>
                    <option value="F">Женский</option>
                </select>
            </td>
        </tr>
        <tr style="display: none">
            <td>Кем работаете</td>
            <td>
                <input id="reg_job"/>
            </td>
        </tr>
        <tr>
            <td>Ваше местоположение</td>
            <td>
                <select type="select" id="reg_area">
                    <option value="1" selected="selected">Москва, Летниковская</option>
                    <option value="2">Москва, Котельническая</option>
                    <option value="3">Москва, Электрозаводская</option>
                    <option value="4">Саратов, Орджоникидзе</option>
                    <option value="5">Саратов, Шелковичная</option>
                    <option value="6">Новосибирск, Добролюбова</option>
                    <option value="7">Новосибирск, Кирова</option>
                    <option value="8">Казань, Лево-Булачная</option>
                    <option value="9">Екатеринбург, Толмачева</option>
                    <option value="10">Хабаровск, Амурский бульвар</option>
                    <option value="11">Ханты-Мансийск, Мира</option>
                </select>
            </td>
        </tr>
    </table>
    <input class='ok-btn' type="button" value="OK" id="submit-registrate"/>
    <input class='ok-btn' type="button" value="OK" id="submit-entrance"/>
</div>
</body>
</html>
