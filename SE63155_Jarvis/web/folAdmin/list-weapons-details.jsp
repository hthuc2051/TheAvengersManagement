<%-- 
    Document   : list-weapons-details
    Created on : Jul 4, 2018, 11:15:54 PM
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
        <table class="list-weapons-material">
            <tr>
                <th>No.</th>
                <th>Weapon name</th>
                <th>Description</th>
                <th style="width: 50px;"  >Power</th>
                <th></th>
                <th></th>
            </tr>
        </tr>
        <s:if test="weaponsData !=null">
            <s:if test="weaponsData.size() > 0" >
                <s:iterator value="%{weaponsData}" var="dto" status="counter">
                    <tr>
                        <s:form theme="simple" action="UpdateArmorSupportedAction" >
                            <s:hidden name="weaponID" value="%{#dto.id}" />
                            <s:hidden name="key" value="weapon" />
                            <td class="cell-center"><s:property value="%{#counter.count}" /></td>
                            <td>
                                <s:textfield name="weaponName" value="%{#dto.name}" />
                            </td>
                            <td>
                                <s:textfield name="description" value="%{#dto.description}" />
                            </td>
                            <td><s:textfield name="power" value="%{#dto.power}" /></td>
                            <td class="edit-cell">
                                <s:submit cssClass="btn" value="Update" />
                            </td>
                        </s:form>
                        <s:url action="DeleteAction" var="deleteLink" >
                            <s:param name="key">weapon</s:param>
                            <s:param name="weaponID" value="%{#dto.id}" ></s:param>
                        </s:url>
                        <td class="edit-cell">
                            <s:a cssClass="btn-del" href="%{deleteLink}">Delete</s:a>
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
