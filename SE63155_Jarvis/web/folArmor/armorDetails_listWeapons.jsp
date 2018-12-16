<%-- 
    Document   : armorDetails_listWeapons
    Created on : Jul 2, 2018, 4:22:52 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <s:if test="%{#session.AllWeapons !=null}">
            <s:iterator value="%{#session.AllWeapons}" var="allDTO" >
            <li>
                <a>
                    <s:property value="%{#allDTO.name}" />
                    <span>
                        <s:set var="check" value="0" />
                        <s:iterator value="%{armorDTO.weapons}" var="weapon" >
                            <s:if test='#allDTO.id.equals(#weapon.id)'>
                                <s:set var="check" value="1" />
                            </s:if>
                        </s:iterator>
                        <s:if test='#check == 1'>
                            <input type="checkbox"  checked name="weapons" value="<s:property value="%{#allDTO.id}"/>">
                        </s:if>
                        <s:else>
                            <input type="checkbox"  name="weapons" value="<s:property value="%{#allDTO.id}"/>">
                        </s:else>
                    </span>
                </a>
            </li>
        </s:iterator>    
    </s:if>
</body>
</html>
