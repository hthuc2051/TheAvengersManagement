<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<table class="list-table">
    <tr>
        <th>No.</th>
        <th>Code</th>
        <th>Title</th>
        <th>Location</th>
        <th>Status</th>
        <th></th>
        <th></th>
    </tr>
    <s:if test="%{missionsData != null}">
        <s:if test="missionsData.size() > 0" >
            <s:iterator var="dto" value="%{missionsData}" status="counter">
                <tr>
                    <td>
                        <s:property value="%{#counter.count}" ></s:property>
                        </td>
                        <td>
                        <s:property value="%{#dto.code}" ></s:property>
                        </td>
                        <td>
                        <s:property value="%{#dto.title}" ></s:property>
                        </td>
                        <td>
                        <s:property value="%{#dto.location}" ></s:property>
                        </td>
                        <td>
                        <s:property value="%{#dto.status}" ></s:property>
                        </td>
                        <td class="details-cell">
                        <s:url action="ViewAction" var="viewLink">
                            <s:param name="key">mission</s:param>
                            <s:param name="searchValue" value="%{searchValue}"></s:param>
                            <s:param name="missionCode" value="%{#dto.code}"></s:param>
                        </s:url>
                        <s:a cssClass="btn-details" href="%{viewLink}">Details</s:a>
                        </td>
                        <td class="details-cell">
                        <s:url action="DeleteAction" var="deleteLink">
                            <s:param name="searchValue" value="%{searchValue}"></s:param>
                            <s:param name="missionCode" value="%{#dto.code}"></s:param>
                            <s:param name="key">mission</s:param>
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