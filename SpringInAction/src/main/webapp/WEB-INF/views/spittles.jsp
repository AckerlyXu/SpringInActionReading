<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Spittr</title>

</head>
<body>
     <h1>Welcome to Spittr</h1>
     <ul>
     <c:forEach items="${spittleList}" var="spittle">
     <li >${spittle.message }</li>
   
     <li>
     <c:out value="${spittle.time }"></c:out>
     </li>
     </c:forEach>
     </ul>
</body>
</html>