<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<script src="/SE63155_Jarvis/js/jquery-3.2.1.min.js" ></script>
<script src="/SE63155_Jarvis/js/jquery.validate.js" ></script>
<script src="/SE63155_Jarvis/js/additional-methods.js" ></script>
<script>
    $(function () {
        $("#form-armor").validate({
            errorElement: 'span',
            rules: {
                armorName: {
                    trim:true,
                    required: true,
                    rangelength: [1, 50]
                },
                description: {
                    trim:true,
                    maxlength: 8000
                },
                myFile: {
                    extension: "jpg|jpeg|png"
                }
            }
        })
    });
</script>


<s:form id="form-armor" action="UpdateArmorAction" method="POST" enctype="multipart/form-data" theme="simple">
    Armor code:<s:textfield cssClass="form-attribute" name="armorCode" readonly="true" value="%{armorDTO.code}"></s:textfield><br/>
    Armor name:<s:textfield cssClass="form-attribute" name="armorName"  value="%{armorDTO.name}"></s:textfield>
        <br/>Armor's material:<br/>
    <s:div id="material-list">
        <s:iterator value="%{#session.AllMaterials}" var="allDTO" >
            <s:if test='#allDTO.id.equals(armorDTO.materials.id)'>
                <input type="radio" checked name="materialID" value="<s:property value="%{#allDTO.id}"/>">
                <s:label value="%{#allDTO.name}"/>
            </s:if>
            <s:else>
                <input type="radio" name="materialID" value="<s:property value="%{#allDTO.id}" />">
                <s:label value="%{#allDTO.name}"/>
            </s:else>
        </s:iterator>
    </s:div>
    Available:
    <s:if test="%{armorDTO.available}">
        <s:textfield cssClass="form-list" name="available" value="Yes" readonly="true" />
    </s:if>
    <s:else>
        <s:textfield cssClass="form-list" name="available" value="No" readonly="true" />
    </s:else>
    <br/>Description:<br/>
    <s:textarea rows="4" cols="0" name="description" cssClass="description" value="%{armorDTO.description}"></s:textarea>
        <br/>
        Armor's weapons:<br/>	
    <s:div id="weapons-list">
        <s:iterator value="%{armorDTO.weapons}" var="dto"> 
            <s:textfield cssClass="form-list" value="%{#dto.name}" readonly="true"></s:textfield><br/>
        </s:iterator>
    </s:div>
    <%@include file="armor_subWeapons.jsp" %>
    <p class="file">
        <input type="file" name="myFile" id="file" accept="image/*" />
        <label for="file">Upload armor image</label>
    </p>
    <s:submit cssClass="form-submit" value="Update"></s:submit>
</s:form>