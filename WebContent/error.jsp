<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error Page</title>
</head>
<body>
<%
int error_code = response.getStatus();
%>
[error.jsp - error-page] Servlet returned error code as: <b> <%=error_code%></b>
</body>
</html>