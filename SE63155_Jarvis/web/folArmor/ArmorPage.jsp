<!doctype html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>

        <meta charset="utf-8">
        <title>Welcome page</title>
        <link href="/SE63155_Jarvis/css2/armorPage.css" rel="stylesheet" type="text/css">
        <script src="/SE63155_Jarvis/js/jquery-3.2.1.min.js"></script>
        <script src="/SE63155_Jarvis/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
            $(function () {
                $("#container-arrow").on("click", function () {
                    $("html, body").animate({scrollTop: 800}, 800);
                });
            });
            <s:if  test="%{#session.NewsArmor.size() > 4}">
            function display() {
                var container = document.getElementById("container");
                var arr = container.getElementsByClassName("container-item");
                <s:iterator value="%{#session.NewsArmor}" var="dto" begin="0" end="3"  status="counter" >
                arr[<s:property value="%{#counter.count}" /> - 1].style.backgroundImage = "url(/SE63155_Jarvis/uploads/<s:property value="%{#dto.image}"/>)";
                arr[<s:property value="%{#counter.count}" /> - 1].style.backgroundSize = "cover";
                </s:iterator>
            }
            </s:if>
            <s:if test="%{searchValue !=null}">
                $('html, body').animate({scrollTop: 700}, 1500);
            </s:if>
        </script>
    </head>

    <body style="margin: 0px;" onLoad="display();
            searchSuccess();" >
        <s:if test="%{alert != null and status != ''}">
            <p id="message-status" class="alert alert-danger alert-dismissible" fade show>
                <s:property value="%{alert}"></s:property>
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                </p>
        </s:if>
        <ul id="header-menu">
            <li class="logo">
                J.A.R.V.I.S
            </li>
            <li id="menu-bar">
                <ul id="user-bar">
                    <li>
                        <s:a action="LoginAction" >User</s:a>
                        </li>
                        <li>
                        <s:a action="">Log out</s:a>
                        </li>
                    </ul>
                </li>
            </ul>
            <div id="container">
                <div id="welcomeMessage">
                    Welcome !! I'm 
                </div>
                <div id="welcomeName">
                    J.A.R.V.I.S
                </div>
            <%@include file="armorPage_news.jsp" %>
            <img id="container-arrow" src="/SE63155_Jarvis/images/down-arrow.png" onClick="moveDown();">;
            <p id="container-armors-heading" >Hall of Armors</p>
            <%@include file="armorPage_searchForm.jsp" %>
            <ul id="container-armorList">
                <%@include file="armorPage_armorList.jsp" %>
            </ul>
        </div>
        <iframe src="/SE63155_Jarvis/iFrame/Footer.html"  frameborder="0" scrolling="no" id="footer" scrollbar="no" style="width: 100%; height: 300px;"></iframe>
    </body>
</html>
