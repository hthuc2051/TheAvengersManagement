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
                <th>StartDate</th>
                <th>EndDate</th>
                <th>Status</th>
            </tr>
            <s:if test="armorUseHistory !=null">
                <s:if test="armorUseHistory.size() > 0" >
                    <s:iterator value="armorUseHistory" var="dto" status="counter">
                        <tr>
                            <td class="cell-center">
                                <s:property value="%{#counter.count}" ></s:property>
                                </td>
                                <td><s:property value="%{#dto.username}" ></s:property></td>
                            <td><s:property value="%{#dto.armorName}" ></s:property></td>
                            <td><s:property value="%{#dto.startDate}" ></s:property></td>
                            <td><s:property value="%{#dto.endDate}" ></s:property></td>
                            <td><s:property value="%{#dto.status}" ></s:property></td>
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
