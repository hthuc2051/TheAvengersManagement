<%-- 
    Document   : insert_missionForm
    Created on : Jun 25, 2018, 10:05:47 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="/SE63155_Jarvis/js/jquery-3.2.1.min.js" ></script>
        <script src="/SE63155_Jarvis/js/jquery.validate.js" ></script>
        <script src="/SE63155_Jarvis/js/additional-methods.js" ></script>

        <script>
            $(function () {
                $("#form-mission").validate({
                    rules: {
                        code: {
                            nowhitespace:true,
                            required: true,
                            rangelength: [1, 10]
                        },
                        title: {
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
                        startDate:{
                            required:true
                        }
                    }
                })
            });
        </script>
    </head>
    <body>
        <s:form cssClass="form-mission" action="InsertMissionAction" method="POST" enctype="form-data" theme="simple" id="form-mission" onsubmit="return checkDate()">
            Mission code:<s:textfield cssClass="form-attribute"  type="text" name="code" value="%{code}"/>
            <br/>
            Misstion Title:<s:textfield cssClass="form-attribute"  type="text" name="title" value="%{title}" />
            <br/>
            Location:<s:textfield cssClass="form-attribute"  type="text" name="location" value="%{location}" />
            <br/>	
            StartDate:<input class="date"  type="date" name="startDate" value="" onMouseOut="checkDate()" />
            EndDate:<input class="date"  type="date" name="endDate" value="" onMouseOut="checkDate()" />
            <br/>		
            Description:<br/>
            <s:textarea rows="4" cols="0" name="description" cssClass="description" value="%{description}"/><br/>
            Avengers:<br/>
            <s:div id="user_list">
                <s:if test="%{#session.AllUsers != null}">
                    <s:iterator value="%{#session.AllUsers}" var="dto">                
                        <input type="checkbox" name="users" value="<s:property value="%{#dto.username}"/>"/>
                        <s:label value="%{#dto.firstName}"/>
                        <s:label value="%{#dto.lastName}"/>
                        <br/>
                    </s:iterator>
                </s:if>
            </s:div>
            <s:submit cssClass="form-submit" value="Insert" />
        </s:form>
    </body>
</html>
