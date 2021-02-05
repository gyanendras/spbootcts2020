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

<c:set var="empList"
		value="<%=(List)request.getAttribute(\"eList\")%>" />  <!--   request.getParam("Model1"); -->

<table id="customers">
		<tbody>
			<tr>
				<th>Name</th>
				<th>Salary</th>
			</tr>
			<c:forEach var="emp" items="${empList}">
			  
			 <tr id="${emp.name}">
			 	<td><c:out value="${emp.name}"></c:out></td>
					<td><c:out value="${emp.salary}"></c:out></td>
					<td><a href="addcart?name=${emp.name}&sal=${emp.salary}" target="_blank">Add to card</a></td>
				</tr>
							
				<!-- <c:set var="emplist" value="${empList}" scope="request"/>
				<c:set var="empid" value="${emp.name}" scope="request" /> -->
			</c:forEach>
		</tbody>
	</table>


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