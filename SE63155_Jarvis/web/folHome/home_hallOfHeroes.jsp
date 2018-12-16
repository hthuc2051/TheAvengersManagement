<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>


<s:iterator value="%{#session.AllUsers}" var="dto">
    <s:url var="imgLink" value="%{#dto.image}"></s:url>
    <li style="background-image: url(/SE63155_Jarvis/uploads/<s:property value="%{imgLink}" />);"></li>
</s:iterator>

