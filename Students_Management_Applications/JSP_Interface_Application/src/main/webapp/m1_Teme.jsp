<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"
	import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tabela Teme</title>
<link href="table.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<jsp:useBean id="jb" scope="session" class="db.JavaBean" />
<jsp:setProperty name="jb" property="*" />
<body>
	<h1 align="center">Tabela Teme:</h1>
	<br />
	<p align="center">
		<a href="nou_Teme.jsp"><b>Adauga o noua tema.</b></a> <a
			href="index.html"><b>Home</b></a>
	</p>
	<%
	jb.connect();
	int aux = java.lang.Integer.parseInt(request.getParameter("primarykey"));
	ResultSet rs = jb.intoarceLinieDupaId("teme", "idteme", aux);
	rs.first();
	int punctaj;
	String Materie = request.getParameter("materie");
	String Subiect = request.getParameter("subiect");
	String Punctaj = request.getParameter("punctaj");
	rs.close();
	jb.disconnect();
	%>
	<form action="m2_Teme.jsp" method="post">
		<table align="center">
			<tr>
				<td align="right">IdTeme:</td>
				<td><input type="text" name="idteme" size="30"
					value="<%=aux%>" readonly /></td>
			</tr>
			<tr>
				<td align="right">Materie:</td>
				<td><input type="text" name="materie" size="30" value="<%=Materie%>" /></td>
			</tr>
			<tr>
				<td align="right">Subiect:</td>
				<td><input type="text" name="subiect" size="30"
					value="<%=Subiect%>" /></td>
			</tr>
			<tr>
				<td align="right">Punctaj:</td>
				<td><input type="text" name="punctaj" size="30"
					value="<%=Punctaj%>" /></td>
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