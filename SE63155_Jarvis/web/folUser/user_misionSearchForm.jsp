<%-- 
    Document   : user_misionSearchForm
    Created on : Jul 10, 2018, 7:13:39 PM
    Author     : USER
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:form cssClass="search-form" action="SearchAction" theme="simple" id="searchMission-form">
            <s:textfield name="searchValue" placeholder="Search mission ?" />
            <s:hidden name="key" value="user_Mission" />
            <s:submit cssClass="" value="Search"/>
        </s:form>
    </body>
</html>
