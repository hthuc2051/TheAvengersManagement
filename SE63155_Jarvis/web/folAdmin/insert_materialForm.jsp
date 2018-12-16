<%-- 
    Document   : insert_materialForm
    Created on : Jul 5, 2018, 1:34:00 PM
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
                $("#form-material").validate({
                    rules: {
                        materialName: {
                            trim:true,
                            required: true,
                            maxlength: 50
                        },
                        description: {
                            trim:true,
                            maxlength: 8000
                        }
                    }
                })


            })

        </script>
    </head>
    <body>
        <s:form cssClass="form-material" method="post" action="InsertArmorSupportedAction"  theme="simple" id="form-material">
            <s:textfield name="materialName" cssClass="form-attribute" placeholder="Material name"/>
            <s:textfield name="description" cssClass="form-attribute" placeholder="Description"/>
            <s:hidden name="key" value="material" />
            <s:submit value="Insert" cssClass="form-submit" />
        </s:form>

    </body>
</html>
