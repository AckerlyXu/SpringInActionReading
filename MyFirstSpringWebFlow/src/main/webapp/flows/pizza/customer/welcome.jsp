<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
   <sf:form >
   <input type="hidden" name="_flowExecutionKey"
   value="${flowExecutionKey }"
   >
   <input type="text"  name="phoneNumber" /><br/>
   <input type="submit" name="_eventId_phoneEntered">
   </sf:form>
</body>
</html>