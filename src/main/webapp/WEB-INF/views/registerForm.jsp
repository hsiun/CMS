<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>

<html>
<head>
<title>User</title>
</head>
<body>
<h1>Register</h1>

<form method="POST">
Username: <input type="text" name="username" /><br />
Password: <input type="password" name="password" /><br />
Phone:<input type="text" name="phone" /><br />
Email:<input type="text" name="email" /><br />
<input type="submit" value="Register" />
</form>
</body>
</html>