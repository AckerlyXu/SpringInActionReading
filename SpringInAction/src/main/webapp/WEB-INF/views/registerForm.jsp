<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<style type="text/css">
.error{
color:red
}
</style>
</head>
<body>
<c:url value="/spitter/register" var="agc"  >
<c:param name="max" value='a'></c:param>
</c:url>


<a href='${agc }'>a</a>
<h1> <s:message code="spitter.welcome"></s:message></h1>
<sf:form method="post" commandName="spitter">
First Name:<sf:input path="firstName" /><br/>
 <sf:errors path="firstName" element="div" cssClass="error"></sf:errors> 
Last Name:<sf:input path="lastName" /><br/>
Username:<sf:input path="username"/><br/>
<sf:errors path="username" element="div" cssClass="error"></sf:errors>
<sf:label path="password" cssErrorClass="error">Password:</sf:label>
<sf:password  path="password" cssErrorClass="error" /><br/>
<sf:errors path="password" element="div" cssClass="error"></sf:errors>
<input type="submit" value="submit"><br/>
</sf:form>
</body>
</html>