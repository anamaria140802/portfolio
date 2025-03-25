<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"
	import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tabela Teme</title>
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
	<form action="m1_Teme.jsp" method="post">
		<table border="1" align="center">
			<tr>
				<td><b>Mark:</b></td>
				<td><b>IdTema:</b></td>
				<td><b>Materie:</b></td>
				<td><b>Subiect:</b></td>
				<td><b>Punctaj:</b></td>
			</tr>
			<%
			jb.connect();
			ResultSet rs = jb.vedeTabela("teme");
			long x;
			while (rs.next()) {
				x = rs.getLong("idteme");
			%>
			<tr>
				<td><input type="checkbox" name="primarykey" value="<%=x%>" /></td>
				<td><%=x%></td>
				<td><%=rs.getString("materie")%></td>
				<td><%=rs.getString("subiect")%></td>
				<td><%=rs.getInt("punctaj")%></td>
				<%
				}
				%>
			</tr>
		</table>
		<br />
		<p align="center">
			<input type="submit" value="Modifica linia">
		</p>
	</form>
	<%
	jb.disconnect();
	%>
	<br />
	<p align="center">
		<a href="index.html"><b>Home</b></a> <br />
	</p>
</body>
</html>
