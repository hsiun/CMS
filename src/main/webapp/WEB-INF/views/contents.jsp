<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<%@ page isELIgnored="false" %> <!-- 据说jsp2直接支持，更改web.xml文件可以 -->

<html>
<head>
<title>Content List</title>
</head>
<body>
<c:forEach items="${news}" var="new_value" >
	<li id="new_<c:out value="new_value.id" />">
		<div class="contentMessage">
			<c:out value="${new_value.title}" />
		</div>
			<c:out value="${new_value.content}" />
		<div>
		</div>
	</li>
</c:forEach>
</body>
</html>