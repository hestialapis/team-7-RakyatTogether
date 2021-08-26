<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Student Data</title>
</head>
<body>
<%@ page import="com.dao.PostDao" %>
<jsp:useBean id="s" class="com.dao.bean.Post"></jsp:useBean>
<jsp:setProperty property="*" name="s"/>

<%
int i=PostDao.updateDislikes(s);
response.sendRedirect("homepage.jsp");
%>


</body>
</html>