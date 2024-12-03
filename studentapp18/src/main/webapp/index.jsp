<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="verifyLogin" method="post">
<pre>
Email<input type="text" name="email"/>
Password<input type="text" name="password"/>
<input type="submit" value="Login"/>
</pre>
</form>
<%
if(request.getAttribute("errorMessage")!=null)
{
	out.println(request.getAttribute("errorMessage"));
}
if(request.getAttribute("message")!=null)
{
	out.println(request.getAttribute("message"));
}
%>
</body>
</html>