<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.cts.springboot.cts2020.*" %> 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <h2 style="color:Tomato;">
     <%= (new java.util.Date( ) ).toLocaleString( ) %>
     </h2> 
    
    
     <% int[] arr = new int[4];
       arr[3] = 1111; 
     System.out.println(arr[3]); 
     out.print(arr[3]);%>
     <%Employee e = (Employee)request.getAttribute("emp"); 
     
     %>
     
    <h3> <c:out value="<%=e.getName()%>" /> </h3>
    <h3> <c:out value="<%=e.getSalary()%>"/> </h3>

</body>
</html>