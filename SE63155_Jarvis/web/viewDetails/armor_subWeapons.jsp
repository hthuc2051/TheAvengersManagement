<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<div id="weaponsOverlay" class="overlay">
    <span>Weapons list</span>
    <span class="closebtn" onclick="closeWeaponsDetails()" title="Close Overlay">×</span>
    <div class="overlay-content">
        <div class="checkbox-list">
            <s:iterator value="%{#session.AllWeapons}" var="allDTO">
                <s:set var="check" value="0"></s:set>
                <s:iterator value="%{armorDTO.weapons}" var="weapon">
                    <s:if test='%{#allDTO.id.equals(#weapon.id)}'>
                        <s:set var="check" value="1"></s:set>
                    </s:if>
                </s:iterator>
                <s:if test='%{#check == "1"}'>
                     <input type="checkbox" name="weapons" checked value="<s:property value="%{#allDTO.id}" ></s:property>">
                    <s:label value="%{#allDTO.name}"></s:label> 
                    <s:label value="%{#allDTO.power}"></s:label><br/>
                </s:if>
                <s:else>
                     <input type="checkbox" name="weapons" value="<s:property value="%{#allDTO.id}" ></s:property>">
                    <s:label value="%{#allDTO.name}"></s:label> 
                    <s:label value="%{#allDTO.power}"></s:label><br/>
                </s:else>
            </s:iterator>
        </div>
    </div>
</div>