<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<html>
<head>
<title>User</title>
</head>
<body>
<h1>Add News</h1>

<form method="POST">
Title: <input type="text" name="title" /><br />
Content:<input type="text" name="content" />
<input type="submit" value="Add" />
</form>
</body>
</html>