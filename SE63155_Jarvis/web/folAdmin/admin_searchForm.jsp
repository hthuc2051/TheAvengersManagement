
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:if test="%{key !=null}">
            <s:form action="SearchAction" method="POST" id="search-form">
                <input type="text" name="searchValue" placeholder="Search ${param.key} ?">
                <s:hidden type="hidden" name="key" value="%{key}"/>
                <s:submit cssClass="but-search" value="Search"/>
            </s:form>
        </s:if>
    </body>

</html>
