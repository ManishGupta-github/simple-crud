<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Add Student Details</h2>
<form action="addInquiry" method="post">
<pre>
Name:<input type="text" name="name"/>
Email:<input type="text" name="email"/>
Mobile:<input type="text" name="mobile"/>
<input type="submit" name="Add"/>
</pre>
</form>
<%if(request.getAttribute("message")!=null)
	{
	out.println(request.getAttribute("message"));
	
	}%>	
</body>
</html>