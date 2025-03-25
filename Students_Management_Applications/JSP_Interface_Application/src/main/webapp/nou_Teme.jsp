<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"
	import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adauga Teme</title>
</head>
<jsp:useBean id="jb" scope="session" class="db.JavaBean" />
<jsp:setProperty name="jb" property="*" />
<body>
	<%
	String Materie = request.getParameter("materie");
	String Subiect = request.getParameter("subiect");
	String Punctaj = request.getParameter("punctaj");
	if (Materie != null) {
		jb.connect();
		jb.adaugaTema(Materie, Subiect, java.lang.Integer.parseInt(Punctaj));
		jb.disconnect();
	%>
	<p>Datele au fost adaugate.</p>
	<%
	} else {
	%>
	<h1>Suntem in tabela Teme.</h1>
	<form action="nou_Teme.jsp" method="post">
		<table>
			<tr>
				<td align="right">Materie:</td>
				<td><input type="text" name="materie" size="40" /></td>
			</tr>
			<tr>
				<td align="right">Subiect:</td>
				<td><input type="text" name="subiect" size="30" /></td>
			</tr>
			<tr>
				<td align="right">Punctaj:</td>
				<td><input type="text" name="punctaj" size="30" /></td>
			</tr>
		</table>
		<input type="submit" value="Adauga tema" />
	</form>
	<%
	}
	%>
	<br />
	<a href="index.html"><b>Home</b></a>
	<br />
</body>
</html>