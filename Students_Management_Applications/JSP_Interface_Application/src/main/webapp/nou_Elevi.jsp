<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"
	import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adauga Elevi</title>
</head>
<jsp:useBean id="jb" scope="session" class="db.JavaBean" />
<jsp:setProperty name="jb" property="*" />
<body>
	<%
	String Nume = request.getParameter("nume");
	String Prenume = request.getParameter("prenume");
	String Clasa = request.getParameter("clasa");
	String Media = request.getParameter("media");
	if (Nume != null) {
		jb.connect();
		jb.adaugaElev(Nume, Prenume,Clasa, java.lang.Integer.parseInt(Media));
		jb.disconnect();
	%>
	<p>Datele au fost adaugate.</p>
	<%
	} else {
	%>
	<h1>Suntem in tabela Elevi.</h1>
	<form action="nou_Elevi.jsp" method="post">
		<table>
			<tr>
				<td align="right">Nume Elevi:</td>
				<td><input type="text" name="nume" size="40" /></td>
			</tr>
			<tr>
				<td align="right">Prenume Elevi:</td>
				<td><input type="text" name="prenume" size="30" /></td>
			</tr>
			<tr>
				<td align="right">Clasa:</td>
				<td><input type="text" name="clasa" size="30" /></td>
			</tr>
			<tr>
				<td align="right">Media:</td>
				<td><input type="text" name="media" size="30" /></td>
			</tr>
		</table>
		<input type="submit" value="Adauga elevi" />
	</form>
	<%
	}
	%>
	<br />
	<a href="index.html"><b>Home</b></a>
	<br />
</body>
</html>