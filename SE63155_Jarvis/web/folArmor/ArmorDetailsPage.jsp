<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html class="no-js" lang="en">
    <head>

        <!--- basic page needs
        ================================================== -->
        <meta charset="utf-8">
        <title>Armor <s:property value="%{armorDTO.name}"/></title>
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- mobile specific metas
        ================================================== -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- CSS
        ================================================== -->
        <link rel="stylesheet" href="/SE63155_Jarvis/css/base.css">
        <link rel="stylesheet" href="/SE63155_Jarvis/css/vendor.css">
        <link rel="stylesheet" href="/SE63155_Jarvis/css/armorDetailsPage.css">

        <style type="text/css" media="screen">
            .s-styles { 
                background: white;
                padding-top: 15rem;
                padding-bottom: 12rem;
            }
        </style>

        <!-- script
        ================================================== -->
        <script src="/SE63155_Jarvis/js/modernizr.js"></script>
        <script src="/SE63155_Jarvis/js/pace.min.js"></script>

        <!-- favicons
        ================================================== -->
        <link rel="shortcut icon" href="/SE63155_Jarvis/favicon.ico" type="image/x-icon">
        <link rel="icon" href="/SE63155_Jarvis/favicon.ico" type="image/x-icon">

    </head>

    <body id="top">
        <header class="s-header">
            <div class="header-logo">
                <a class="site-logo">
                    <img src="/SE63155_Jarvis/images/logoArmorDetails.png" alt="Armor's-User Details">
                </a>
            </div> <!-- end header-logo -->
        </header> <!-- end s-header -->


        <!-- home
        ================================================== -->
        <s:form theme="simple" action="RequestUseArmorAction" >
            <section id="home" class="s-home target-section" data-parallax="scroll" data-image-src="/SE63155_Jarvis/uploads/<s:property value="%{armorDTO.image}" />" data-natural-width="1666" data-natural-height="1166" data-position-y="top">
                <div class="shadow-overlay"></div>

                <div class="home-content">
                    <div class="row home-content__main">
                        <h1> 
                            <s:property value="%{armorDTO.name}"  />
                        </h1>
                        <p>
                            <s:property value="%{armorDTO.description}" /><br/>
                            Made from : <s:property value="%{armorDTO.materials.name}" />
                        </p>
                    </div> <!-- end home-content__main -->

                </div> <!-- end home-content -->

                <ul class="home-sidelinks">
                    <li>
                        <a style="font-size: 17px;">Request weapons </a>
                    </li>
                    <%@include file="armorDetails_listWeapons.jsp" %>
                </ul>
                <ul class="home-social">
                    <li class="home-social-title">Control</li>
                    <li>
                        <s:a action="LoginAction" >
                            <span class="home-social-text">User Page</span>
                        </s:a>
                    </li>
                    <li>
                        <s:a action="LogOutAction" >
                            <span class="home-social-text">Log out</span>
                        </s:a>
                    </li>
                </ul> <!-- end home-social -->


                <s:hidden name="armorID" value="%{armorDTO.id}" ></s:hidden>
                <s:hidden name="username" value="%{#session.Username}"></s:hidden>
                <s:submit id="request" value="Ask for use"></s:submit>

                </section> <!-- end s-home -->
        </s:form>
        <div id="weapons" >
            <p id="weapon-title">Weapons</p>
            <ul class="weapons-list">
                <s:if test="%{#session.AllWeapons != null}" >
                    <s:iterator value="%{#session.AllWeapons}" var="weapon">
                        <li class="weapon-details">
                            <h1><s:property value="%{#weapon.name}"/>-<s:property value="%{#weapon.power}" /></h1>
                            <span><s:property value="%{#weapon.description}"/></span>
                        </li>
                    </s:iterator>
                </s:if>

            </ul>
        </div>   
        <div id="preloader">
            <div id="loader">
            </div>
        </div>

        <!-- Java Script
        ================================================== -->
        <script src="/SE63155_Jarvis/js/jquery-3.2.1.min.js"></script>
        <script src="/SE63155_Jarvis/js/plugins.js"></script>
        <script src="/SE63155_Jarvis/js/armorDetailsPage.js"></script>

    </body>

</html>