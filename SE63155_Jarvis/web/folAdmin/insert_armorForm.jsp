<%-- 
    Document   : insert_armorForm
    Created on : Jun 25, 2018, 10:03:20 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="/SE63155_Jarvis/js/jquery-3.2.1.min.js" ></script>
        <script src="/SE63155_Jarvis/js/jquery.validate.js" ></script>
        <script src="/SE63155_Jarvis/js/additional-methods.js" ></script>
        <script>
            $(function () {
                $("#form-armor").validate({
                    rules: {
                        code: {
                            nowhitespace:true,
                            required: true,
                            rangelength:[1,10]
                        },
                        name: {
                            trim:true,
                            required: true,
                            rangelength: [1,50]
                        },
                        description: {
                            trim:true,
                            maxlength: 8000
                        }
                    }
                })
            });
        </script>
    </head>
    <body>
        <s:form cssClass="form-armor" action="InsertArmorAction" method="POST" enctype="form-data" theme="simple" id="form-armor">
            Armor code:<s:textfield cssClass="form-attribute"  type="text" name="code" value="%{code}"/><br/>
            Armor name:<s:textfield cssClass="form-attribute"  type="text" name="name" value="%{name}"/><br/>
            Description:<br/>
            <s:textarea rows="4" cols="0" name="description" cssClass="description" value="%{description}"></s:textarea>
                <br/>
                Armor's material:
            <s:div id="material-list">
                <s:if test="%{#session.AllMaterials !=null}">
                    <s:iterator value="%{#session.AllMaterials}" var="dto">
                        <input type="radio" checked name="materials" value="<s:property value="%{#dto.id}" ></s:property>">
                        <s:label value="%{#dto.name}"/><br/>
                    </s:iterator>
                </s:if>
            </s:div>
            <br/>
            Armor's weapons:	
            <s:div id="weapons-list">
                <s:if test="%{#session.AllWeapons !=null}">
                    <s:iterator value="%{#session.AllWeapons}" var="dto">
                        <input type="checkbox" name="weapons" value="<s:property value="%{#dto.id}"/>">
                        <s:label value="%{#dto.name}"/>-
                        <s:label value="%{#dto.power}"/>
                        <br/>
                    </s:iterator>
                </s:if>
            </s:div>
            <s:submit cssClass="form-submit" value="Insert"/>
        </s:form>
    </body>
</html>
