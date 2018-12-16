
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<s:if test="%{userDTO.listMission != null}">
    <s:if test="%{userDTO.listMission.size() >0 }">
        <s:iterator value="%{userDTO.listMission}" var="mission">
            <li>
                <span></span>
                <div class="time">
                    <span><s:property value="%{#mission.startDate}" /></span>
                </div>
                <div class="title"> 
                    <s:property value="%{#mission.title}"/> - Location : <s:property value="%{#mission.location}" />
                </div>
                <div class="info"> 
                    <s:property value="%{#mission.description}"/>
                </div>
                <div class="name">
                    Avengers:
                    <select> 
                        <s:iterator value="%{#mission.listUsers}" var="partner">
                            <option><s:property value="%{#partner.firstName}"/> <s:property value="%{#partner.lastName}"/></option>
                        </s:iterator>
                    </select>
                </div>
                <s:url var="doneLink" action="UpdateMissionAction">
                    <s:param name="key">submit</s:param>
                    <s:param name="doneMissionCode" value="%{#mission.code}"></s:param>
                </s:url>
                <s:if test='%{#mission.status.equalsIgnoreCase("Not finished")}'>
                    <s:a cssClass="btn-done" href="%{doneLink}">
                        <img src="/SE63155_Jarvis/images/mission-check.png">
                    </s:a>
                </s:if>
                <div class="time">
                    <span><s:property value="%{#mission.endDate}" /></span>
                </div>
            </li>
        </s:iterator>      
    </s:if>
    <s:else>
        <li>No data !</li>
    </s:else>

</s:if>