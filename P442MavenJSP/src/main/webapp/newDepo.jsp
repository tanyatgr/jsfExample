<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Depo.css" />
<title>Deposit List</title>

</head>
<body>
	<%
		app.ListDepo test = new app.ListDepo();
		test.read("Depo.txt");
		java.util.ArrayList<app.DepoBase> list = test.getList();
		String depoType = request.getParameter("depoType");
		String start = request.getParameter("start");
		java.text.SimpleDateFormat dtFrm = new java.text.SimpleDateFormat(
				"dd.MM.yyyy");
		java.util.Date startD = dtFrm.parse(start);
		int dlong = Integer.valueOf(request.getParameter("days"));
		double sum = Double.valueOf(request.getParameter("sum"));
		double rate = Double.valueOf(request.getParameter("rate"));
		if (depoType.equals("simple")) {
			app.DepoSimple depo = new app.DepoSimple(startD, dlong, sum,
					rate);
			list.add(depo);
		}
		if (depoType.equals("month")) {
			app.DepoMonthCapitalize depo = new app.DepoMonthCapitalize(
					startD, dlong, sum, rate);
			list.add(depo);
		}
		test.save("Depo.txt");
		for (app.DepoBase d : list) {
			out.print("<p>" + d.getDataForWeb() + "</p> ");
		}
	%>

</body>
</html>