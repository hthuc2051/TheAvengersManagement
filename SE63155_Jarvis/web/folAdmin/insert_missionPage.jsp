<!doctype html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert mission page</title>
        <link href="/SE63155_Jarvis/css2/insert_misionPage.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="/SE63155_Jarvis/js/bootstrap.min.js"></script>
        <script>
            function checkDate()
            {
                var x = document.getElementsByName("startDate")[0].value;
                var y = document.getElementsByName("endDate")[0].value;
                if (x > y) {
                    document.getElementById("dateStatus").style.display = "block";
                    event.preventDefault();
                } else {
                    document.getElementById("dateStatus").style.display = "none";
                }

            }
        </script>
    </head>

    <body>
        <s:if test="%{alert != null and status != ''}">
            <p id="message-status" class="alert alert-danger alert-dismissible" fade show>
                <s:property value="%{alert}"></s:property>
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                </p>
        </s:if>
        <div id="form">
            <p id="line"></p>
            <p class="form-title">Insert mission</p>
            <%@include file="insert_missionForm.jsp" %>
            <p id="dateStatus" >*Start date must > End date</p>	
            <div class="logo">J.A.R.V.I.S</div>
            <div class="fullName">Just A Rather Very<br/> Intelligent System</div>
        </div>

    </body>
</html>
