<%-- 
    Document   : insert_weaponForm
    Created on : Jul 5, 2018, 1:38:35 PM
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
                $("#form-weapon").validate({
                    rules: {
                        weaponName: {
                            trim:true,
                            required: true,
                            rangelength: [1, 50]
                        },
                        power:{
                            number:true
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
        <s:form cssClass="form-weapon" method="post" action="InsertArmorSupportedAction" id="form-weapon" theme="simple">
            <s:textfield name="weaponName" cssClass="form-attribute" placeholder="Weapon name"/>
            <s:textfield name="description" cssClass="form-attribute" placeholder="Description"/>
            <s:textfield name="power" cssClass="form-attribute" placeholder="Power"/>
            <s:hidden name="key" value="weapon" />
            <s:submit value="Insert" cssClass="form-submit" />
        </s:form>
    </body>
</html>
