<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href=<c:url value="'resources/css/room.css'"/>/>

    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script type="text/javascript" src=<c:url value="'resources/js/room.js'"/>></script>
</head>
<body>
<div class="wrapper">
    <div class="content">
        <img src="resources/images/exit.png" class='exit' title="Выйти из игры. Вас не смогут больше пригласить на кофе"
             id="btn_exit"/>
        <img src="resources/images/entrance.jpg" class='exit' title="Войти в игру. Вас снова будут приглашать на кофе"
             style="display: none" title="Войти в игру" id="btn_entrance"/>

        <img src="resources/images/stick.png" class='stick'/>

        <div class='stick stick-text'>
            Не забыть выпить кофе
        </div>

        <div class='tab-all'>
            <div class='tab'>
                <svg xmlns="http://www.w3.org/2000/svg"
                     width="100%" height="50px" version='1.1'>
                    <polygon points="50 0,450 0,495 50,15 50"
                             style="fill:gray;stroke:black;stroke-width:5"/>
                </svg>
            </div>
            <div class='base tab'>
                <div class='top-panel'>
                    <div class='button-group'>
                        <div class='button-settings' value='Люблю говорить' id="setting_talk">
                            <img class="ico" src="https://img.icons8.com/windows/32/000000/voice-presentation.png"/>
                        </div>
                        <div class='button-settings' value='Люблю слушать' id="setting_listen">
                            <img class="ico"
                                 src="https://img.icons8.com/ios-filled/32/000000/assistive-listening-systems.png"/>
                        </div>
                        <div class='button-settings' value='Общаюсь на деловые темы' id="setting_work">
                            <img class="ico" src="https://img.icons8.com/ios/32/000000/permanent-job.png">
                        </div>
                        <div class='button-settings' value='Готов говорить обо всём' id="setting_other">
                            <img class="ico" src="https://img.icons8.com/ios-filled/32/000000/chat.png">
                        </div>
                    </div>
                    <div class='display'>
                        Select some settings, and START
                    </div>
                    <div>
                        <div class='drive-group button-stop'>
                            <div class="stop-ico"></div>
                        </div>
                        <div class='drive-group button-start'>
                            <div class="start-ico"></div>
                        </div>
                    </div>
                </div>
                <div class='cooler'>
                    <!--		<svg xmlns="http://www.w3.org/2000/svg" version="1.1" :xlink="http://www.w3.org/1999/xlink">
                        <defs>
                         <path id="path1" d="M20,20 a1,1 0 0,0 400,0"/>
                         <path id="path2" d="M20,30 a1,1 0 0,0 100,0"/>
                        </defs>
                        <text style="fill:red;">
                          <textPath xlink:href="#path1">Open</textPath>
                         </text>
                         <text style="fill:red;">
                          <textPath xlink:href="#path2">Coffee</textPath>
                         </text>
                      </svg>
                      -->
                </div>
                <div>
                    <div class='pip'></div>
                    <div class='pip'></div>
                </div>
                <div class="load">
                    <div class="coffee"></div>
                    <div class="coffee"></div>
                </div>
                <div class='layer-cup'>
                    <svg xmlns="http://www.w3.org/2000/svg" width="100%" height="115px" version='1.1'>
                        <defs>
                            <linearGradient id="Gradient1">
                                <stop class="stop1" offset="0%"/>
                                <stop class="stop2" offset="50%"/>
                                <stop class="stop3" offset="100%"/>
                            </linearGradient>
                        </defs>
                        <path d="M160 20 C 100 10, 100 100, 210 100 " stroke="black" stroke-width="1"
                              fill="transparent"/>
                        <path d="M160 30 C 110 10, 110 100, 210 93 " stroke="white" stroke-width="10"
                              fill="transparent"/>
                        <path d="M163 35 C 115 10, 123 100, 210 83 " stroke="black" stroke-width="1"
                              fill="transparent"/>

                        <path d="M160 0 C 160 150, 360 150, 360 0 Z" stroke="black" stroke-width="2" class="cup"/>

                    </svg>
                </div>
            </div>
            <div>
                <svg xmlns="http://www.w3.org/2000/svg"
                     width="650px" height="100px" version='1.1'>
                    <polygon points="63 0,545 0,600 50,0 50"
                             style="fill:gray;stroke:black;stroke-width:5"/>
                    <rect x="3" y="50" rx="5" ry="5"
                          width="600" height="20"
                          stroke="black" stroke-width="5"
                          style="fill:silver"/>
                </svg>
            </div>

        </div>
    </div>
    <div class="footer">

    </div>
</div>
</body>
</html>
