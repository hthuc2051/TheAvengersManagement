<%-- 
    Document   : user_armorUse
    Created on : Jul 4, 2018, 12:46:18 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<s:if test="%{armorRequestData !=null}" >
    <s:if test="%{armorRequestData.size() >0 }">
        <s:iterator value="%{armorRequestData}" var="dto">
            <li>
                <span></span>
                <div class="time">
                    <s:if test="%{#dto.startDate !=null}">
                        <span><s:property value="%{#dto.startDate}" /></span>
                    </s:if>
                </div>
                <div class="title"><s:property value="%{#dto.armorName}" /></div>
                <s:url var="sendBackLink" action="ArmorUseUpdateAction" >
                    <s:param name="idRequest" value="%{#dto.idRequest}" ></s:param>
                    <s:param name="key">sendBack</s:param>
                    <s:param name="armorID" value="%{#dto.armorID}" ></s:param>
                </s:url>
                <s:if test='%{#dto.endDate == null && #dto.status.equals("Allowed") }'>
                    <s:a href="%{sendBackLink}">
                        <img src="/SE63155_Jarvis/images/refresh-button.png">
                    </s:a>
                </s:if>
                <div class="time">
                    <s:if test="%{#dto.endDate !=null}">
                        <span><s:property value="%{#dto.endDate}" /></span>
                    </s:if>
                </div>
            </li> 
        </s:iterator>
    </s:if>
    <s:else>
        <li>No data !</li>
    </s:else>
</s:if>

