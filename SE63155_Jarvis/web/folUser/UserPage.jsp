<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>User Page</title>
        <link href="/SE63155_Jarvis/css2/UserPage.css" rel="stylesheet" type="text/css">
        <script src="/SE63155_Jarvis/js/UserPage.js"></script>
        <link rel="stylesheet" href="/SE63155_Jarvis/css/owl.carousel.css"/>
        <link rel="stylesheet" href="/SE63155_Jarvis/css/userStyle.css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/waypoints/2.0.5/waypoints.min.js"></script>
        <script src="/SE63155_Jarvis/js/jquery-3.2.1.min.js" ></script>
        <script src="/SE63155_Jarvis/js/jquery.validate.js" ></script>
        <script src="/SE63155_Jarvis/js/additional-methods.js" ></script>
        <s:if test="%{armorRequestData != null}">
            <s:iterator value="%{armorRequestData}" var="dto" status="counter">
                <s:if test="%{#dto.endDate != null}">
                    <style>
                        .box2 ul li:nth-child(<s:property value="%{#counter.count}"/>) > span:before,.box2 ul li:nth-child(<s:property value="%{#counter.count}"/>) > span:after{
                            background:#00CC00;
                        }
                    </style>
                </s:if>
                <s:elseif test='%{#dto.status.equals("Refused")}'>
                    <style>
                        .box2 ul li:nth-child(<s:property value="%{#counter.count}"/>) > span:before,.box2 ul li:nth-child(<s:property value="%{#counter.count}"/>) > span:after{
                            background:red;
                        }
                    </style>
                </s:elseif>
            </s:iterator>          
        </s:if>

        <s:if test="%{userDTO.listMission != null}">
            <s:iterator value="%{userDTO.listMission}" var="mission" status="counter">
                <s:if test='%{#mission.status.equals("Finished")}'>
                    <style>
                        .box ul li:nth-child(<s:property value="%{#counter.count}"/>) > span:before,.box ul li:nth-child(<s:property value="%{#counter.count}"/>) > span:after{
                            background:#00CC00;
                        }
                    </style>
                </s:if>
                <s:elseif test='%{#mission.status.equalsIgnoreCase("Not finished")}'>
                    <style>
                        .box ul li:nth-child(<s:property value="%{#counter.count}"/>) > span:before,.box ul li:nth-child(<s:property value="%{#counter.count}"/>) > span:after{
                            background:white;
                        }
                    </style>
                </s:elseif>
                <s:elseif test='%{#mission.status.equalsIgnoreCase("Failed")}'>
                    <style>
                        .box ul li:nth-child(<s:property value="%{#counter.count}"/>) > span:before,.box ul li:nth-child(<s:property value="%{#counter.count}"/>) > span:after{
                            background:red;
                        }
                    </style>
                </s:elseif>
                <s:else>
                    <style>
                        .box ul li:nth-child(<s:property value="%{#counter.count}"/>) > span:before,.box ul li:nth-child(<s:property value="%{#counter.count}"/>) > span:after{
                            background:#FFCC33;
                        }
                    </style>
                </s:else>
            </s:iterator>          
        </s:if>        
    </head>
    <body >
        <s:if test="%{alert != null}">
            <p id="message-status" class="alert alert-danger alert-dismissible">   
                <s:property value="%{alert}" ></s:property>
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                </p>
        </s:if>   
        <s:a action="" id="log-out" >- Log out</s:a>
            <a id="openArmorUse" onClick="openArmorUseNav()">
                <img src="/SE63155_Jarvis/images/ironSuitPageLogo.png" style="width: 40px; height:35px">
                Armor Use
            </a>
            <button class="cn-button" id="cn-button" onClick="menuControl()">-</button>
            <div id="profileNav" class="sidenav-left">
                <p style="border-bottom: 1px solid rgba(255, 255, 255, 0.14);"></p>
       
                <img id="user-img" src="/SE63155_Jarvis/uploads/<s:property value="%{userDTO.image}" />">
            <a class="closebtn" onclick="closeProfileNav()">&times;</a>

            <%@include file="user_profileForm.jsp" %>

            <!--Preview the image-->
            <script>
                function readURL(input) {
                    if (input.files && input.files[0]) {
                        var reader = new FileReader();
                        reader.onload = function (e) {
                            $("#user-img").attr("src", e.target.result);
                        }
                        reader.readAsDataURL(input.files[0]);
                    }
                }
                $("#file").change(function () {
                    readURL(this);
                });
            </script>

            <p style="border-bottom: 1px solid rgba(255, 255, 255, 0.14);"></p>
        </div>
        <div id="missionNav" class="sidenav-right">
            <a class="closebtn" onclick="closeMissionNav()">&times;</a>
            <%@include file="user_misionSearchForm.jsp" %>
            <div class="box">
                <ul id="list-missions">
                    <%@include file="user_missionForm.jsp" %>

                </ul>     
            </div>
        </div>
        <div id="armorUseNav" class="sidenav-right">
            <a class="closebtn" onclick="closeArmorUseNav()">&times;</a>
            <%@include file="user_armorUseSearchForm.jsp" %>
            <div class="box2">
                <ul id="list-armors">
                    <%@include file="user_armorUse.jsp" %>

                </ul>     
            </div>
        </div>
        <!--session-->
        <div class="hero-slider owl-carousel">

            <div class="hs-item set-bg sp-pad" >
                <div class="hs-text">
                    <h2 class="hs-title">_Loki</h2>
                    <p class="hs-des">“Well, for one thing, I'm not Asgardian. And for another, we have the Hulk!”</p>
                </div>
            </div>
            <div class="hs-item set-bg sp-pad" >
                <div class="hs-text">
                    <h2 class="hs-title">_Tony Stark </h2>
                    <p class="hs-des">“An intelligence agency that fears intelligence? Historically, not awesome.” </p>
                </div>
            </div>
            <div class="hs-item set-bg sp-pad">
                <div class="hs-text">
                    <h2 class="hs-title">_Black Panther </h2>
                    <p class="hs-des">“Wakanda forever !” </p>
                </div>
            </div>
            <div class="hs-item set-bg sp-pad" >
                <div class="hs-text">
                    <h2 class="hs-title">_Tony Stark </h2>
                    <p class="hs-des">“I'm sorry. Earth is closed today. So pack it up, and get out of here !” </p>
                </div>
            </div>
        </div>
        <script src="/SE63155_Jarvis/js/bootstrap.min.js"></script>
        <script src="/SE63155_Jarvis/js/owl.carousel.min.js"></script>
        <script src="/SE63155_Jarvis/js/mixitup.min.js"></script>
        <script src="/SE63155_Jarvis/js/circle-progress.min.js"></script>
        <script src="/SE63155_Jarvis/js/mainUser.js"></script>
        <script src="/SE63155_Jarvis/js/waypoint.js"></script>
        <!--	end session-->
        <div class="cn-wrapper" >
            <ul id="list">
                <li onClick="openProfileNav();">
                    <a style="transform: skew(-50deg) rotate(-70deg) scale(1); border-radius: 50%; text-align: center; padding-top: 2em;">
                        <span class="icon">
                            <img src="/SE63155_Jarvis/images/job.png">
                        </span>
                    </a>
                </li>
                <li>
                    <s:url var="loadLink" action="LoadDataAction">
                        <s:param name="key">armorUser</s:param>
                    </s:url>
                    <s:a cssStyle="transform: skew(-50deg) rotate(-70deg) scale(1); border-radius: 50%; text-align: center; padding-top: 2em;" href="%{loadLink}">
                        <span class="icon">
                            <img src="/SE63155_Jarvis/images/ironSuitPageLogo.png" width="45px;" height="35px">
                        </span>
                    </s:a>
                </li>
                <li onClick="openMissionNav();">
                    <a style="transform: skew(-50deg) rotate(-70deg) scale(1); border-radius: 50%; text-align: center; padding-top: 2em;" >
                        <span class="icon" >
                            <img src="/SE63155_Jarvis/images/briefing.png" >
                        </span>
                    </a>
                </li>
            </ul>
        </div>
    </body>
    <script>
        <s:if test="%{alert != null}">
            <s:if test='%{alert.indexOf("profile") >0}'>
        openProfileNav();
            </s:if>
            <s:elseif test='%{alert.indexOf("mission")>0}'>
        openMissionNav();
            </s:elseif>
            <s:elseif test='%{alert.indexOf("armor")>0}'>
        openArmorUseNav();
            </s:elseif>
        </s:if>
        <s:if test="%{key !=null}">
            <s:if test='%{key.equals("user_ArmorUse") || key.equals("sendBack")}' >
        openArmorUseNav();
            </s:if>
            <s:elseif test='%{key.equals("user_Mission")}' >
        openMissionNav();
            </s:elseif>
        </s:if>
    </script>
</html>