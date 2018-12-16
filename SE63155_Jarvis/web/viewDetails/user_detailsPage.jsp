<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>User Page</title>
        <link href="/SE63155_Jarvis/css2/user_detailsPage.css" rel="stylesheet" type="text/css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    </head>
    <body>
        <s:if test="%{#request.STATUS!=null }">
            <p id="message-status" class="alert alert-danger alert-dismissible">   
                <s:property value="%{#request.STATUS}"></s:property>
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                </p>
        </s:if>   
        <img id="user-img" src="/SE63155_Jarvis/uploads/<s:property value="%{userDTO.image}" />">
        <div id="form">
            <p id="line1"></p>
            <p class="form-title">Profile's details</p>
            <%@include file="user_detailsForm.jsp" %>
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
            <p id="line2"></p>
        </div>
    </body>
</html>
