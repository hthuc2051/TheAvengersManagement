<%-- 
    Document   : armorPage_news
    Created on : Jul 2, 2018, 10:56:33 AM
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
        <s:if  test="%{#session.NewsArmor.size() > 4}">
            <s:iterator value="%{#session.NewsArmor}" var="dto" begin="0" end="3">
                <ul class ="container-item">
                    <li class="item-details">
                        <p><s:property value="%{#dto.name}" /></p>
                        <s:url var="loadLink" action="ViewAction">
                            <s:param name="armorCode" value="%{#dto.code}"></s:param>
                            <s:param name="key">armorUser</s:param>
                        </s:url>
                        <s:a href="%{loadLink}">Click to see details</s:a>
                        </li>
                    </ul>
            </s:iterator>
        </s:if>




    </body>
</html>
