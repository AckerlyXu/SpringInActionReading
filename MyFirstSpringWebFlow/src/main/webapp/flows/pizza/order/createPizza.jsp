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
</head>
<body>
     <sf:form commandName="pizza">
     <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey }"
     >
     
     <b>size:</b><br/>
    	  <sf:radiobutton path="size" label="Small (12-inch)" value="SMALL"/><br/>
    	  <sf:radiobutton path="size" label="MEDIUM (14-inch)" value="MEDIUM"/><br/>
    	  <sf:radiobutton path="size" label="LARGE (16-inch)" value="LARGE"/><br/>
    	      	  <sf:radiobutton path="size" label="GINORMOUS (20-inch)" value="GINORMOUS"/><br/>
    	      	  
    	      	  <br/>
    	      	  <br/>
    	      	  <b>Toppings</b><br/>
    	      	  <sf:checkboxes path="toppings" items="${toppingsList }"
    	      	  delimiter="&lt;br/&gt;" /><br/>
    	      	  
    	      	  <input type="submit" name="_eventId_addPizza" value="Cintinue">
    	 <input type="submit" name="_eventId_cancel" value="Cancel">
    	
     </sf:form>
</body>
</html>