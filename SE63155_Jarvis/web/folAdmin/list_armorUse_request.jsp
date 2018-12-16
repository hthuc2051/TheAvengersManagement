<%-- 
    Document   : list_armorUse_request
    Created on : Jul 4, 2018, 1:42:59 PM
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
        <table class="list-table">
            <tr>
                <th>No.</th>
                <th>Username</th>
                <th>Armor</th>
                <th>Weapons</th>
                <th></th>
                <th></th>
            </tr>
            <s:if test="%{armorRequestData != null}">
                <s:if test="armorRequestData.size() > 0" >
                    <s:iterator value="armorRequestData" var="dto" status="counter">
                        <tr>
                            <td class="cell-center">
                                <s:property value="%{#counter.count}" ></s:property>
                                </td>
                                <td><s:property value="%{#dto.username}" ></s:property></td>
                            <td><s:property value="%{#dto.armorName}" ></s:property></td>
                            <td><s:property value="%{#dto.weaponRequest}" ></s:property></td>
                                <td class="details-cell">
                                <s:url action="ArmorUseUpdateAction" var="allowLink">
                                    <s:param name="key">allow</s:param>
                                    <s:param name="idRequest" value="%{#dto.idRequest}" ></s:param>
                                    <s:param name="weaponRequest" value="%{#dto.weaponRequest}" ></s:param>
                                    <s:param name="armorID" value="%{#dto.armorID}" ></s:param>
                                </s:url>
                                <s:a cssClass="btn-details" href="%{allowLink}">Allow</s:a>
                                </td>
                                <td class="details-cell">
                                <s:url action="ArmorUseUpdateAction" var="refuseLink">
                                    <s:param name="key">refuse</s:param>
                                    <s:param name="idRequest" value="%{#dto.idRequest}" ></s:param>
                                </s:url>
                                <s:a cssClass="btn-del" href="%{refuseLink}">Refuse</s:a>
                                </td>

                            </tr>
                    </s:iterator>
                </s:if>
                <s:else>
                    <h2>No data !</h2>
                </s:else>
            </s:if>
        </table>
    </body>
</html>
