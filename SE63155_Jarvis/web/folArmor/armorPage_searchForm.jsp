<%-- 
    Document   : armorPage_searchForm
    Created on : Jul 2, 2018, 10:57:19 AM
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
        <s:form id="form-search" action="SearchAction" theme="simple">
            <input name="searchValue" placeholder="Search armor ?">
            <s:hidden name="key" value="armorUser" />
            <s:submit value="Search" cssClass="form-submit"/>
        </s:form>
    </body>
</html>
