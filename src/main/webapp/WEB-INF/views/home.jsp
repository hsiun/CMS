<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<html>
<head>
<title>CMS Home Page</title>
<link rel="stylesheet"
      type="text/css"
      href="<c:url value="/resources/style.css" />" >
</head>
<body>
	<h1>Welcome to this CMS</h1>
	<a href="<c:url value="/" />" >CMS</a> | 
	<a href="<c:url value="/user/register" />" >Register</a>
	<a href="<c:url value="/news/add" />" >Add News</a>
	<a href="<c:url value="/news/all" />" >All News</a>
	<a href="<c:url value="/login" />" >Login</a>

</body>
</html>