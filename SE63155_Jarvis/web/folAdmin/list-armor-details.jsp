<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<table class="list-table">
    <tr>
        <th>No.</th>
        <th>Code</th>
        <th>Armor name</th>
        <th>Description</th>
        <th>Available</th>
        <th></th>
        <th></th>
    </tr>
    <s:if test="armorsData != null">
        <s:if test="armorsData.size() > 0" >
            <s:iterator var="dto" value="armorsData" status="counter">
                <tr>
                    <td>
                        <s:property value="%{#counter.count}" ></s:property>
                        </td>
                        <td>
                        <s:property value="%{#dto.code}" ></s:property>
                        </td>
                        <td>
                        <s:property value="%{#dto.name}" ></s:property>
                        </td>
                        <td>
                        <s:property value="%{#dto.description}" ></s:property>
                        </td>
                        <td>
                        <s:if test="%{#dto.available}">
                            Yes
                        </s:if>
                        <s:else>
                            No
                        </s:else>
                    </td>
                    <td class="details-cell">
                        <s:url action="ViewAction" var="viewLink">
                            <s:param name="key">armor</s:param>
                            <s:param name="searchValue" value="%{searchValue}"></s:param>
                            <s:param name="armorCode" value="%{#dto.code}"></s:param>
                        </s:url>
                        <s:a cssClass="btn-details" href="%{viewLink}">Details</s:a>
                        </td>
                        <td class="details-cell">
                        <s:url action="DeleteAction" var="deleteLink">
                            <s:param name="key">armor</s:param>
                            <s:param name="searchValue" value="%{searchValue}"></s:param>
                            <s:param name="armorCode" value="%{#dto.code}"></s:param>
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