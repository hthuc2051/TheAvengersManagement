
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="/SE63155_Jarvis/js/jquery-3.2.1.min.js" ></script>
        <script src="/SE63155_Jarvis/js/jquery.validate.js" ></script>
        <script src="/SE63155_Jarvis/js/additional-methods.js" ></script>
    </head>
    <body>
        <script>
            $(function () {
                $("#form-profile").validate({
                    errorElement: 'span',
                    rules: {
                        firstName: {
                            trim:true,
                            required: true,
                            maxlength: 30
                        },
                        email: {
                            email: true,
                            maxlength: 70
                        },
                        password: {
                            trim:true,
                            maxlength: 50
                        },lastName: {
                            trim:true,
                            maxlength: 30
                        },
                        myFile: {
                            extension: "jpg|jpeg|png"
                        }
                    }
                })
            });

        </script>
        <s:form id="form-profile" method="POST" action="UpdateUserAction" enctype="multipart/form-data" theme="simple">
            Username:<s:textfield cssClass="form-attribute" name="username" value="%{userDTO.username}" readonly="true"/>
            Password:<s:password cssClass="form-attribute" name="password" value="" />
            First name:<s:textfield cssClass="form-attribute" name="firstName" value="%{userDTO.firstName}" />
            Last name:<s:textfield cssClass="form-attribute" name="lastName" value="%{userDTO.lastName}" />
            Email:<s:textfield cssClass="form-email" type="text" name="email" value="%{userDTO.email}" />
            <p class="file">
                <input class="file" type="file" name="myFile" id="file" />
                <label for="file">Upload your image</label>
            </p>
            <s:hidden name="key" value="userUpdate"/>
            <s:submit cssClass="form-submit" value="Update" />
        </s:form>
    </body>
</html>


