<%-- 
    Document   : error
    Created on : Jun 28, 2018, 5:02:02 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="/SE63155_Jarvis/css2/error.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>404 Error Page </h1>
        <p class="zoom-area"><b>Oops</b>, The Page You're Looking For Was Not Found.</p>
        <section class="error-container">
            <span>4</span>
            <span><span class="screen-reader-text">0</span></span>
            <span>4</span>
        </section>
        <div class="link-container">
            <s:a action="LoginAction" cssClass="more-link">Back to the Home page ?</s:a>
        </div>
    </body>
</html>
