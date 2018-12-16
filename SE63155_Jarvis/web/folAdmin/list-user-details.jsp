<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<table class="list-table">
    <tr>
        <th>No.</th>
        <th>Username</th>
        <th>Full name</th>
        <th>Role</th>
        <th></th>
        <th></th>
    </tr>
    <s:if test="usersData !=null">
        <s:if test="usersData.size() > 0" >
            <s:iterator value="usersData" var="dto" status="counter">
                <tr>
                    <td class="cell-center">
                        <s:property value="%{#counter.count}" ></s:property>
                        </td>
                        <td><s:property value="%{#dto.username}" ></s:property></td>
                        <td>
                        <s:property value="%{#dto.firstName}" ></s:property>
                        <s:property value="%{#dto.lastName}" ></s:property>
                        </td>
                        <td><s:property value="%{#dto.role}" ></s:property></td>
                        <td class="details-cell">
                        <s:url action="ViewAction" var="viewLink">
                            <s:param name="key">user</s:param>
                            <s:param name="searchValue" value="%{searchValue}"></s:param>
                            <s:param name="username" value="%{#dto.username}"></s:param>
                        </s:url>
                        <s:a cssClass="btn-details" href="%{viewLink}">Details</s:a>
                        </td>
                        <td class="details-cell">
                        <s:url action="DeleteAction" var="deleteLink">
                            <s:param name="key">user</s:param>
                            <s:param name="searchValue" value="%{searchValue}"></s:param>
                            <s:param name="username" value="%{#dto.username}"></s:param>
                        </s:url>
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