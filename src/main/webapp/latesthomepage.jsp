<!DOCTYPE html>

<html>

<head>

  <meta charset="UTF-8">
  <title>Homepage</title>
  <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<%@page import="com.dao.PostDao,com.dao.bean.Post,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="heading"> 
<img src="images/rakyatTogether.png" style="width:150px;">
<p class="logo">RakyatTogether</p>
</div>

<p class="greeting">Hi Shane, this is what's happening near Petaling Jaya, Selangor.</p>


	<header>
	  <p class="tabs">
	    Sort by:
	    <a href="latesthomepage.jsp">Latest</a>
	    <a href="homepage.jsp">Most Liked</a>
	  </p>
	</header>
	<a href="makepost.html" class="action-button shadow animate blue">Create Post</a>	
  
	<%
		List<Post>list=PostDao.getAllRecordsLatest();
		request.setAttribute("list", list);
	%>

	<c:forEach items="${list}" var="s">
	<div class="center">
	<div class="card card-1">
	<div class="post">
	<div class="post-tag"><a href="sortbytag.jsp">${s.getPostTag()}</a></div>
	<div class="post-content">${s.getPostContent()}</div>
	<div class="likes">
        <a class="goodbutton" href="likepost.jsp?id=${s.getId()}">Like</a>${s.getPostLike()}
        <a class="badbutton" href="dislikepost.jsp?id=${s.getId()}">Dislike</a>${s.getPostDislike()}
      </div>
    </div>
    </div>
    </div>
	</c:forEach>
</body>
</html>