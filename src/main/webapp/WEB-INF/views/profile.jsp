<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<%@ page session="false" %>
<%@ page isELIgnored="false" %> <!-- 据说jsp2直接支持，更改web.xml文件可以 -->
<html>
  <head>
    <title>CMS</title>
</head>
  <body>
    <h1>Your Profile</h1>
    <jstl:out value="${users.username}" /><br/>
    <jstl:out value="${users.phone}" /><br/>
    <jstl:out value="${users.email}" />
  </body>
</html>


