<%@ page language="java" contentType="text/html; charset=utf-8"
  session="false"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Spittr</title>
<link rel="stylesheet"
type="text/css"
href='<c:url value="/resources/style.css"  ></c:url>'
>
</head>
<body>
     <h1>Welcome to Spittr</h1>
     <a href='<c:url value="/spittles"></c:url>'>Spittles</a>
     <a href='<c:url value="/spitter/register"></c:url>'>Register</a>
</body>
</html>