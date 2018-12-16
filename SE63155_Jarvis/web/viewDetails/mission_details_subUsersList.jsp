<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<div id="weaponsOverlay" class="overlay">
    <span>Avengers list</span>
    <span class="closebtn" onclick="closeWeaponsDetails()" title="Close Overlay">×</span>
    <div class="overlay-content">
        <div class="checkbox-list">
            <s:if test="%{#session.AllUsers!=null}">
                <s:iterator value="%{#session.AllUsers}" var="allDTO" status="counter" >
                      <s:set var="check" value="0" ></s:set>
                    <s:iterator value="%{missionDTO.listUsers}" var="dto">
                        <s:if test='%{#allDTO.username.equals(#dto.username)}' >
                            <s:set var="check" value="1" ></s:set>
                        </s:if>
                    </s:iterator>
                    <s:if test='%{#check == "1"}'>
                        <input type="checkbox" name="usernames" checked value="<s:property value="%{#allDTO.username}" ></s:property>">
                         <s:label value="%{#allDTO.firstName}"></s:label>
                        <s:label value="%{#allDTO.lastName}"></s:label><br/>
                    </s:if>
                    <s:else>
                        <input type="checkbox" name="usernames" value="<s:property value="%{#allDTO.username}" ></s:property>">
                        <s:label value="%{#allDTO.firstName}"></s:label>
                        <s:label value="%{#allDTO.lastName}"></s:label><br/>
                    </s:else>
                </s:iterator>
            </s:if>
        </div>
        <s:a cssClass="miniform-submit" href="folAdmin/insert_userPage.jsp">News</s:a>
    </div>
</div>