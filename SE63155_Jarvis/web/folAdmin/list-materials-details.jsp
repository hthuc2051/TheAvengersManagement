<%-- 
    Document   : list-materials-details
    Created on : Jul 4, 2018, 10:50:53 PM
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
                <th>Materials name</th>
                <th>Description</th>
                <th></th>
                <th></th>
            </tr>
            <s:if test="materialsData !=null">
                <s:if test="materialsData.size() > 0" >
                    <s:iterator value="%{materialsData}" var="dto" status="counter">
                        <tr>
                            <s:form theme="simple" action="UpdateArmorSupportedAction" method="post">
                                <s:hidden name="materialID" value="%{#dto.id}" />
                                <s:hidden name="key" value="material" />
                                <td class="cell-center"><s:property value="%{#counter.count}" /></td>
                                <td>
                                    <s:textfield name="materialName" value="%{#dto.name}" />
                                </td>
                                <td>
                                    <s:textfield name="description" value="%{#dto.description}" />
                                </td>
                                <td class="edit-cell">
                                    <s:submit cssClass="btn" value="Update" />
                                </td>
                                <s:url action="DeleteAction" var="deleteLink" >
                                    <s:param name="key">material</s:param>
                                    <s:param name="materialID" value="%{#dto.id}" ></s:param>
                                </s:url>
                                <td class="edit-cell">
                                    <s:if test="%{#dto.id in materialsUsedID}" >
                                        <s:a cssClass="btn-delPrevent">Delete</s:a>
                                    </s:if>
                                    <s:else>
                                        <s:a cssClass="btn-del" href="%{deleteLink}">Delete</s:a>
                                    </s:else>
                                </td>
                            </s:form>
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
