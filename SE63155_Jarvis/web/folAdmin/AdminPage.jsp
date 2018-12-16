<!doctype html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>Admin Page</title>

        <link href="/SE63155_Jarvis/css2/AdminPage.css" rel="stylesheet" type="text/css" >
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="/SE63155_Jarvis/js/jquery-3.2.1.min.js"></script>
        <script src="/SE63155_Jarvis/js/bootstrap.min.js"></script>
        <script>
            function openSearch() {
                document.getElementById("myOverlay").style.display = "block";
            }
            function closeSearch() {
                document.getElementById("myOverlay").style.display = "none";
            }
            function openMaterialsOverlay() {
                document.getElementById("materialsOverlay").style.display = "block";
            }
            function closeMaterialsOverlay() {
                document.getElementById("materialsOverlay").style.display = "none";
            }
            function openWeaponOverlay() {
                document.getElementById("weaponOverlay").style.display = "block";
            }
            function closeWeaponOverlay() {
                document.getElementById("weaponOverlay").style.display = "none";
            }


            $(document).ready(function () {
                $(".super-menu").click(function () {
                    $(this).parent().find("ul").slideToggle(200);
                    $(this).toggleClass("menu-item-opened");
                    return false;
                });
            });

        </script>


    </head>
    <body>

        <s:if test="%{alert != null and status != ''}">
            <p id="message-status" class="alert alert-danger alert-dismissible" fade show>
                <s:property value="%{alert}"></s:property>
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                </p>
        </s:if>

        <div id="header">
            <img src="/SE63155_Jarvis/images/avengerlogo.png" id="header-img">
            <s:a action="" id="admin-control">Log out
                <img class="log-out" src="/SE63155_Jarvis/images/logout.png">
            </s:a>
        </div>
        <div class="user-details">
            <p><s:property value="%{#session.Username.toUpperCase()}" /></p><br/>
            <p id="user-status">
                <i class="fa fa-circle text-success"></i>    "Online"
            </p>
            <a class="user-image-2" style="background-image: url(/SE63155_Jarvis/images/adminImage.jpg);"></a>
        </div>
        <div id="container">
            <ul id="user-menu">
                <li id="user-controls">
                    <ul id="controls-menu">
                        <li class="control-submenu" >
                            <img src="/SE63155_Jarvis/images/iron-page.png">
                            <a class="super-menu" >Admin Control
                                <span class="plus">+</span>
                            </a>
                            <s:url action="ViewAction" var="viewLink">
                                <s:param name="key">user</s:param>
                                <s:param name="username"><s:property value="%{#session.Username}"/></s:param>
                            </s:url>
                            <s:url var="loadRequestArmorLink" action="LoadDataAction" >
                                <s:param name="key">requestArmor</s:param>
                            </s:url>
                            <s:url var="loadRequestArmorHistoryLink" action="LoadDataAction" >
                                <s:param name="key">requestArmorHistory</s:param>
                            </s:url>
                            <s:url var="loadRequestArmorHistoryLink" action="LoadDataAction" >
                                <s:param name="key">requestArmorHistory</s:param>
                            </s:url>
                            <ul>
                                <li><s:a href="%{viewLink}">Your's Profile</s:a></li>
                                <li><s:a href="%{loadRequestArmorLink}">Requests list</s:a></li>
                                <li><s:a href="%{loadRequestArmorHistoryLink}">Armor's used history</s:a></li>
                                </ul>
                            </li>

                            <li class="control-submenu" >
                                <img src="/SE63155_Jarvis/images/avengers.png">
                                <a class="super-menu" href="loadUser"> Users Controller
                                    <span class="plus">+</span>
                                </a>

                                <ul>
                                    <li><a href="/SE63155_Jarvis/folAdmin/insert_userPage.jsp">New User</a></li>
                                    <s:url var="loadUserLink" action="LoadDataAction" >
                                        <s:param name="key">user</s:param>
                                </s:url>
                                <li><s:a href="%{loadUserLink}">User list</s:a></li>
                                </ul>
                            </li>

                            <li class="control-submenu" >
                                <img style="width: 28px;margin-left: -3px;" src="/SE63155_Jarvis/images/iron-man.png">
                                <a class="super-menu" >Armors Controller
                                    <span class="plus">+</span>
                                </a>

                                <ul>
                                    <li><a href="/SE63155_Jarvis/folAdmin/insert_armorPage.jsp">New Armor</a></li>
                                    <li><a onclick="openMaterialsOverlay()" >New Material</a></li>
                                    <li><a onclick="openWeaponOverlay()">New Weapons</a></li>

                                <s:url var="loadArmorLink" action="LoadDataAction" >
                                    <s:param name="key">armor</s:param>
                                </s:url>
                                <s:url var="loadMaterialsLink" action="LoadDataAction" >
                                    <s:param name="key">material</s:param>
                                </s:url>
                                <s:url var="loadWeaponsLink" action="LoadDataAction" >
                                    <s:param name="key">weapon</s:param>
                                </s:url>
                                <li>
                                    <s:a href="%{loadArmorLink}"> Armors list</s:a>
                                    </li>
                                    <li>
                                    <s:a href="%{loadMaterialsLink}"> Materials list</s:a>
                                    </li>
                                    <li>
                                    <s:a href="%{loadWeaponsLink}"> Weapons list</s:a>
                                    </li>
                                </ul>
                            </li>

                            <li class="control-submenu" >
                                <img src="/SE63155_Jarvis/images/list.png">
                                <a class="super-menu" >Mission Controller
                                    <span class="plus">+</span>
                                </a>
                                <ul>
                                    <li><a href="/SE63155_Jarvis/folAdmin/insert_missionPage.jsp">New mission</a></li>
                                    <s:url var="loadMissionLink" action="LoadDataAction" >
                                        <s:param name="key">mission</s:param>
                                </s:url>
                                <li><s:a href="%{loadMissionLink}">Missions list</s:a></li>
                                </ul>
                            </li>

                        </ul>
                    </li>
                </ul>
                <div class="openBtn" onclick="openSearch()">
                    <img src="/SE63155_Jarvis/images/search.png" id="search-image">
                </div>
                <div id="myOverlay" class="overlay">
                    <span class="closebtn" onclick="closeSearch()" title="Close Overlay">×</span>
                    <div class="overlay-content">

                    <%@include file="admin_searchForm.jsp" %>
                </div>
            </div>
            <div id="materialsOverlay" class="overlay">
                <span class="closebtn" onclick="closeMaterialsOverlay()" title="Close Overlay">×</span>
                <h2>New material</h2>
                <%@include file="insert_materialForm.jsp" %>
            </div>
            <div id="weaponOverlay" class="overlay">
                <span class="closebtn" onclick="closeWeaponOverlay()" title="Close Overlay">×</span>
                <h2>New weapon</h2>
                <div class="overlay-content">
                    <%@include file="insert_weaponForm.jsp" %>
                </div>
            </div>
            <ul id="control-details">
                <s:if test="%{key == 'user'}">
                    <%@include file="list-user-details.jsp" %>
                </s:if>
                <s:elseif test="%{key == 'armor'}">
                    <%@include file="list-armor-details.jsp" %>
                </s:elseif>
                <s:elseif test="key == 'mission'">
                    <%@include file="list-mission-details.jsp" %>
                </s:elseif>
                <s:elseif test="key == 'requestArmor'">
                    <%@include file="list_armorUse_request.jsp" %>
                </s:elseif>
                <s:elseif test="key == 'requestArmorHistory'">
                    <%@include file="list_armorUse_history.jsp" %>
                </s:elseif>
                <s:elseif test="key == 'material'">
                    <%@include file="list-materials-details.jsp" %>
                </s:elseif>
                <s:elseif test="key == 'weapon'">
                    <%@include file="list-weapons-details.jsp" %>
                </s:elseif>
            </ul>
        </div>
        <iframe src="/SE63155_Jarvis/iFrame/Footer.html"  frameborder="0" scrolling="no" id="footer" scrollbar="no" style="width: 100%; height: 300px; margin-top: -16px;"></iframe>
    </body>
</html>

