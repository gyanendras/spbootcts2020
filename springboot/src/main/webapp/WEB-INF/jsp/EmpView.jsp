<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*" %> 
     <%@ page import="com.cts.springboot.cts2020.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
for(int i=0;i<10;i++){
	
%>
<h3><%=i %></h3>
<%
	}%>

<%
List l = (List)request.getAttribute("eList");
for(Object e:l){
	Employee emp =(Employee)e;
	
%>
<h3><%=emp.getName() %></h3>
<%
	}%>	
	
</body>
</html>