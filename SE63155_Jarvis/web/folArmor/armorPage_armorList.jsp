<%-- 
    Document   : armorPage_armorList
    Created on : Jul 2, 2018, 10:58:05 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:if test="%{armorsData !=null}" >
    <s:if test="%{armorsData.size() >0 }" >
        <s:iterator value="%{armorsData}" var="dto">
            <li>
                <s:url var="viewLink" action="ViewAction" >
                    <s:param name="armorCode" value="%{#dto.code}"></s:param>
                    <s:param name="key">armorUser</s:param>
                </s:url>
                <s:a href="%{viewLink}" > <s:property value="%{#dto.name}" /> </s:a>
                </li>
        </s:iterator>
    </s:if>
    <s:else>
        <p>No data !</p>
    </s:else>


</s:if>



