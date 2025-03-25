<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"
	import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tabela Elevi</title>
<link href="table.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<jsp:useBean id="jb" scope="session" class="db.JavaBean" />
<jsp:setProperty name="jb" property="*" />
<body>
	<h1 align="center">Tabela Elevi:</h1>
	<br />
	<p align="center">
		<a href="nou_Elevi.jsp"><b>Adauga un nou elev.</b></a> <a
			href="index.html"><b>Home</b></a>
	</p>
	<%
	jb.connect();
	int aux = java.lang.Integer.parseInt(request.getParameter("primarykey"));
	ResultSet rs = jb.intoarceLinieDupaId("elevi", "idelevi", aux);
	rs.first();
	String Nume = request.getParameter("nume");
	String Prenume = request.getParameter("prenume");
	String Clasa = request.getParameter("clasa");
	String Media = request.getParameter("media");
	rs.close();
	jb.disconnect();
	%>
	<form action="m2_Elevi.jsp" method="post">
		<table align="center">
			<tr>
				<td align="right">IdElevi:</td>
				<td><input type="text" name="idelevi" size="30"
					value="<%=aux%>" readonly /></td>
			</tr>
			<tr>
				<td align="right">Nume:</td>
				<td><input type="text" name="nume" size="30" value="<%=Nume%>" /></td>
			</tr>
			<tr>
				<td align="right">Prenume:</td>
				<td><input type="text" name="prenume" size="30"
					value="<%=Prenume%>" /></td>
			</tr>
			<tr>
				<td align="right">Clasa:</td>
				<td><input type="text" name="clasa" size="30"
					value="<%=Clasa%>" /></td>
			</tr>
			<tr>
				<td align="right">Media:</td>
				<td><input type="text" name="media" size="30"
					value="<%=Media%>" /></td>
			</tr>
		</table>
		<p align="center">
			<input type="submit" value="Modifica linia">
		</p>
	</form>
	<p align="center">
		<a href="index.html"><b>Home</b></a> <br />
</body>
</html>