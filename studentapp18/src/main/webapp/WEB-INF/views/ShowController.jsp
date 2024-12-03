<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="menu.jsp" %>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Controller</title>
</head>
<body>
<h2>Inquiries</h2>
<table>
<tr>
<th>
Name
</th>
<th>
Email
</th>
<th>
Mobile
</th>
<th>
Delete
</th>
<th>
Update
</th>
</tr>
<%
ResultSet result=(ResultSet)request.getAttribute("result");
while(result.next())
{%>
<tr>
<td>
<%= result.getString(1)%>
</td>
<td>
<%= result.getString(2)%>
</td>
<td>
<%= result.getString(3)%>
</td>
<td>
<a href="DeleteController?emailId=<%=result.getString(2)%>">delete</a>
</td>
<td>
<a href="updateController?emailId=<%=result.getString(2)%>&mobile=<%=result.getString(3)%>
">update</a>
</td>
</tr>	


<%}%>

</table>
</body>
</html>