<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="proj.js"></script>
</head>
<body>
	<h2 style="color: Tomato;">
		<%=(new java.util.Date()).toLocaleString()%>
	</h2>
	<h3>
		Visitor count is
		<%=session.getAttribute("count")%></h3>
	<%
		int[] arr = new int[4];
		arr[3] = 1111;
		System.out.println(arr[3]);
		out.print(arr[3]);
	%>

	<h2>This is a heading</h2>

	<p>This is a paragraph.</p>
	<p>This is another paragraph.</p>

	<button>Click me to hide paragraphs</button>


</body>
</html>