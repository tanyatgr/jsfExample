<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		if (request.getParameter("password").equals("123456")) {
			out.println("<h1>HELLO " + request.getParameter("login")
					+ "</h1>");
		} else {
			out.println("Wrong login or password");

		}
	%>

</body>
</html>