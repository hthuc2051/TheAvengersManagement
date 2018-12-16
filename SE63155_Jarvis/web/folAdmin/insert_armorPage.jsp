<!doctype html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>Insert armor page</title>
        <link href="/SE63155_Jarvis/css2/insert_armorPage.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="/SE63155_Jarvis/js/bootstrap.min.js"></script>
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
            <p class="form-title">Insert armor</p>
            <%@include file="insert_armorForm.jsp" %>
            <div class="logo">J.A.R.V.I.S</div>
            <div class="fullName">Just A Rather Very<br/> Intelligent System</div>
        </div>
    </body>
</html>
