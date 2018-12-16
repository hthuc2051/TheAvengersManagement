<%-- 
    Document   : user_armorUseSearchForm
    Created on : Jul 10, 2018, 7:14:01 PM
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
        <s:form cssClass="search-form" action="SearchAction" theme="simple" id="searchArmorUse-form">
            <s:textfield name="searchValue" placeholder="Search armor ?"/>
            <s:hidden name="key" value="user_ArmorUse" />
            <s:submit cssClass="" value="Search"/>
        </s:form>
    </body>
</html>
