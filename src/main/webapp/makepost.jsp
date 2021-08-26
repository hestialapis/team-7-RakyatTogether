<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import = "com.dao.PostDao" %>
<jsp:useBean id = "p" class = "com.dao.bean.Post"></jsp:useBean>
<jsp:setProperty property = "*" name = "p"/>
<% 
	int i = PostDao.save(p);
	if(i > 0){
		response.sendRedirect("homepage.jsp");
	}
	else{
		response.sendRedirect("post-error.jsp");
	}
%>