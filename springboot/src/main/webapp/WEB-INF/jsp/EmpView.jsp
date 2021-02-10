<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.cts.springboot.cts2020.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
	<script src="proj.js"></script>
	 

</head>
<body>

	<c:set var="empList"
		value="<%=(List) request.getAttribute(\"eList\")%>" />
	<!--   request.getParam("Model1"); -->

	<table id="customers" class="table table-danger table-striped table-bordered" >
		<tbody>
			<tr class="thead-dark">
				<th>Name</th>
				<th>Salary</th>
				<th></th>
				<th></th>
				
			</tr>
			<c:forEach var="emp" items="${empList}">

				<tr id="${emp.name}">
					<td><c:out value="${emp.name}"></c:out></td>
					<td><c:out value="${emp.salary}"></c:out></td>
					<td><a class="btn btn-primary" href="addcart?name=${emp.name}&sal=${emp.salary}"
						target="_blank">Add to cart</a>
						 </td>
		
					<td><a class="btn btn-warning" onClick="addCartJQ('${emp.name}','${emp.salary}')">AddToCart</a></td>	
					<td><a class="btn btn-warning" onClick="addCart('${emp.name}','${emp.salary}')">Add-To-Cart</a></td>	
					
				</tr>
				<tr><td id="${emp.name}"></td><td></td><td></td><td></td></tr>
				<!-- <c:set var="emplist" value="${empList}" scope="request"/>
				<c:set var="empid" value="${emp.name}" scope="request" /> -->
			</c:forEach>
		</tbody>
	</table>


	<%
		for (int i = 0; i < 10; i++) {
	%>
	<h3><%=i%></h3>
	<%
		}
	%>

	<%
		List l = (List) request.getAttribute("eList");
		for (Object e : l) {
			Employee emp = (Employee) e;
	%>
	<h3><%=emp.getName()%></h3>
	<%
		}
	%>
<!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

</body>
</html>