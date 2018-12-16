
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<s:form method="post" action="LoginAction" id="login-form">
    <s:textfield name="username" cssClass="form-attribute" placeholder="User Name"/>
    <s:password name="password" cssClass="form-attribute" placeholder="Password"/>
    <s:submit value="Login" cssClass="form-submit" />
</s:form>