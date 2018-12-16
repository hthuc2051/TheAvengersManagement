<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<script src="/SE63155_Jarvis/js/jquery-3.2.1.min.js" ></script>
<script src="/SE63155_Jarvis/js/jquery.validate.js" ></script>
<script src="/SE63155_Jarvis/js/additional-methods.js" ></script>
<script>
    $(function () {
        $("#form-mission").validate({
            rules: {
                missionTitle: {
                    trim:true,
                    required: true,
                    maxlength: 30
                },
                location: {
                    trim:true,
                    required: true,
                    maxlength: 50
                },
                description: {
                    trim:true,
                    maxlength: 8000
                },
                status: {
                    trim:true,
                    required: true,
                    maxlength: 50
                },
                startDate: {
                    required: true
                }
            }
        })
    });
</script>
<s:form action="UpdateMissionAction" id="form-mission" theme="simple" onsubmit="return checkDate()">
    Mission code:<s:textfield cssClass="form-attribute" name="missionCode" value="%{missionDTO.code}" readonly="true"></s:textfield><br/>
    Misstion Title:<s:textfield cssClass="form-attribute" name="missionTitle" value="%{missionDTO.title}"></s:textfield><br/>
    Location:<s:textfield cssClass="form-attribute" name="location" value="%{missionDTO.location}"></s:textfield><br/>
    Status:<s:textfield cssClass="form-attribute" name="status" value="%{missionDTO.status}"></s:textfield><br/>
    StartDate:<input onmouseout="checkDate()"  type="date" class="date" name="startDate" value="<s:property value="%{missionDTO.startDate}"/>"/>
    EndDate:<input onmouseout="checkDate()" type="date" class="date" name="endDate" value="<s:property value="%{missionDTO.endDate}"/>"/><br/>
    Description:<br/>
    <s:textarea cssClass="description" name="description" value="%{missionDTO.description}"></s:textarea><br/>
        Avengers:<br/>
    <s:div id="user-list">
        <s:if test="%{missionDTO.listUsers !=null}">
            <s:iterator value="%{missionDTO.listUsers}" var="dto">
                <s:textfield name="userDoesMission" cssClass="form-list" value="%{#dto.firstName} %{#dto.lastName}"></s:textfield>
            </s:iterator>
        </s:if>
    </s:div>
    <%@include file="mission_details_subUsersList.jsp" %>
    <s:hidden name="key" value="adminUpdate" />
    <s:submit cssClass="form-submit" value="Update"></s:submit>
</s:form>