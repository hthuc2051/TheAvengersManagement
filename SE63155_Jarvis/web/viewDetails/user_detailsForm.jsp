<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<script src="/SE63155_Jarvis/js/jquery-3.2.1.min.js" ></script>
<script src="/SE63155_Jarvis/js/jquery.validate.js" ></script>
<script src="/SE63155_Jarvis/js/additional-methods.js" ></script>
<script>
    $(function () {
        $("#form-profile").validate({
            errorElement: 'span',
            rules: {
                firstName: {
                    trim:true,
                    required: true,
                    maxlength: 30
                },lastName: {
                    trim:true,
                    maxlength: 30
                },
                password: {
                    trim:true,
                    maxlength: 50
                },
                role: {
                    required: true,
                    role: true
                },
                email: {
                    email: true,
                    maxlength: 70
                },
                myFile: {
                    extension: "jpg|jpeg|png"
                }
            }
        })
    });

</script>

<s:form cssClass="form-profile" action="UpdateUserAction" method="POST" enctype="multipart/form-data" id="form-profile" theme="simple">
    Username: <s:textfield cssClass="form-attribute" name="username" value="%{userDTO.username}" readonly="true"></s:textfield><br/>
    Password: <s:password cssClass="form-attribute" name="password" value="" ></s:password><br/>
    First name: <s:textfield cssClass="form-attribute" name="firstName" value="%{userDTO.firstName}"  ></s:textfield><br/>
    Last name: <s:textfield cssClass="form-attribute" name="lastName" value="%{userDTO.lastName}" ></s:textfield><br/>
    <s:if test='%{userDTO.role.equals("user")}' >
        Role:<s:textfield cssClass="role" name="role" value="%{userDTO.role}" ></s:textfield><br/>
    </s:if>
    <s:else>
        <s:hidden cssClass="role" name="role" value="%{userDTO.role}" ></s:hidden>
    </s:else>
    Email:<s:textfield cssClass="email" name="email" value="%{userDTO.email}"></s:textfield><br/>
        <p class="file">
            <input type="file" name="myFile" id="file"accept="image/*" />
            <label for="file">Upload user's image</label>
        </p>
    <s:hidden name="key" value="adminUpdate" />
    <s:submit cssClass="form-submit" value="Update" ></s:submit>
</s:form>
