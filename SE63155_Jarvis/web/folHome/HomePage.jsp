<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Home</title>
        <link href="/SE63155_Jarvis/css2/HomePage.css" rel="stylesheet" type="text/css">
        <script src="/SE63155_Jarvis/js/HomePage.js"></script>
        <script src="/SE63155_Jarvis/js/jquery-3.2.1.min.js"></script>
        <script src="/SE63155_Jarvis/js/bootstrap.min.js"></script>
        <s:if test="%{alert!=null }">
            <script>
                function loadLogin() {
                    var content = document.getElementsByClassName("insinde-content");
                    var menu_bar = document.getElementById("menu-bar");
                    var icon = document.getElementsByClassName("icon");
                    content[0].style.transform = "translateX(-1190px)";
                    menu_bar.style.backgroundColor = "rgba(0,0,0,0.8)";
                    icon[0].style.filter = "opacity(50%)";
                    icon[1].style.filter = "opacity(100%)";
                    icon[2].style.filter = "opacity(50%)";
                }
            </script>
        </s:if>  
    </head>
    <body onload="loadLogin()">
        <s:if test="%{alert!=null }">
            <p id="message-status" class="alert alert-danger alert-dismissible">   
                <s:property value="%{alert}"></s:property>
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                </p>
        </s:if>  
        <!--start home-->
        <div id="container">
            <ul id="menu-bar">
                <li onClick="loadContent(1);">
                    <img src="/SE63155_Jarvis/images/home.png" class="icon">
                </li>
                <li style="margin-right: 7px;" onClick="loadContent(2);">
                    <img src="/SE63155_Jarvis/images/login-button.png" class="icon">
                </li >
                <li onClick="loadContent(3);">
                    <img src="/SE63155_Jarvis/images/hall-users.png" class="icon">
                </li>
            </ul>
            <div class="content">
                <ul class="insinde-content">
                    <li>
                        <div id="msg">Welcome to Jarvis's world</div>
                        <p class="line1"></p>
                        <div id="dot"></div>
                        <p class="line2"></p>
                        <div id="msg-1">"Started out, J.A.R.V.I.S. was just a natural language UI. Now he runs the Iron Legion. He runs more of the business than anyone besides Pepper."</div>
                        <a onClick="loadContent(2);" id="login">Get's started !</a>
                    </li>
                    <li>
                        <div id="container-login">
                            <div id="container-intro">
                                <ul>
                                    <li id="quotes">"Until the world ends we will act like it spins on." </li>
                                    <li id="author">_Loki</li>
                                </ul>
                            </div>
                            <%@include file="home_loginForm.jsp" %>
                        </div>

                    </li>
                    <!--end register-->
                    <li>
                        <ul id="container-heroes">
                            <p id="title">Hall of Heroes</p>
                            <%@include file="home_hallOfHeroes.jsp" %>
                        </ul>
                    </li>
                </ul>
            </div>

        </div>

    </body>
</html>