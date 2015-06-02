
<%@ page language="java" contentType="text/html; charset=ISO-8859-1 "
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" http://www.w3.org/TR/htm4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="depo.css" />
<title>Depo List JSP</title>
</head>
<body>
	<h1>Deposit List</h1>
	<table>
		<tr>
			<td>Start
			<td>Long
			<td>Sum
			<td>Interest Rate
		</tr>
		<%
			app.ListDepo test = new app.ListDepo();
			test.read("Depo.txt");
			java.util.ArrayList<app.DepoBase> list = test.getList();
			for (app.DepoBase d : list) {
				out.print(d.getDataForWeb());
			}
		%>
	</table>
</body>
</html>
