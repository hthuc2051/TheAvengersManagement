<%-- 
    Document   : insert_userForm
    Created on : Jun 25, 2018, 10:07:30 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="/SE63155_Jarvis/js/jquery-3.2.1.min.js" ></script>
        <script src="/SE63155_Jarvis/js/jquery.validate.js" ></script>
        <script src="/SE63155_Jarvis/js/additional-methods.js" ></script>
        <script>
            $(function () {
                $("#form-profile").validate({
                    rules: {
                        username: {
                            nowhitespace:true,
                            required: true,
                            maxlength: 30
                        },
                        password: {
                            trim:true,
                            required: true,
                            maxlength: 50
                        },
                        firstName: {
                            trim:true,
                            required: true,
                            maxlength: 30
                        },
                        lastName: {
                            trim:true,
                            maxlength: 30
                        },
                        role: {
                            required: true,
                            role: true
                        },
                        email: {
                            email: true,
                            maxlength: 70
                        }
                    }
                })
            });

        </script>
    </head>
    <body>
        <s:form cssClass="form-profile" action="InsertUserAction" method="POST" enctype="form-data" theme="simple" id="form-profile">
            Username:<s:textfield cssClass="form-attribute"  type="text" name="username" value="%{username}"/><br/>
            Password:<s:password cssClass="form-attribute"  type="password" name="password" value="%{password}" /><br/>
            First name:<s:textfield cssClass="form-Username"  type="text" name="firstName" value="%{firstName}"/>
            Last name:<s:textfield cssClass="form-Username"  type="text" name="lastName" value="%{lastName}"/><br/>
            Role:<s:textfield cssClass="role"  type="text" name="role" value="%{role}"/><br/>
            Email:<s:textfield cssClass="email"  type="text" name="email" value="%{email}"/>
            <s:hidden  name="key" value="user"/>
            <s:submit cssClass="form-submit" value="Insert" onClick="myFunction()" />
        </s:form>
    </body>
</html>
