<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"
	import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tabela Realizare</title>
</head>
<jsp:useBean id="jb" scope="session" class="db.JavaBean" />
<jsp:setProperty name="jb" property="*" />
<body>
	<h1 align="center">Tabela Realizare:</h1>
	<br />
	<p align="center">
		<a href="nou_Realizare.jsp"><b>Adauga realizare.</b></a> <a
			href="index.html"><b>Home</b></a>
	</p>
	<form action="m1_Realizare.jsp" method="post">
		<table border="1" align="center">
			<tr>
				<td><b>Mark:</b></td>
				<td><b>IdRealizare:</b></td>
				<td><b>IdElevi:</b></td>
				<td><b>NumeElev:</b></td>
				<td><b>PrenumeElev:</b></td>
				<td><b>ClasaElev:</b></td>
				<td><b>MediaElev:</b></td>
				<td><b>IdTeme:</b></td>
				<td><b>MaterieTema:</b></td>
				<td><b>SubiectTema:</b></td>
				<td><b>PunctajTema:</b></td>
				<td><b>Termen:</b></td>
				<td><b>Tip:</b></td>
				<td><b>Format:</b></td>
			</tr>
			<%
			jb.connect();
			ResultSet rs = jb.vedeRealizare();
			long x;
			while (rs.next()) {
				x = rs.getInt("idrealizare");
			%>
			<tr>
				<td><input type="checkbox" name="primarykey" value="<%=x%>" /></td>
				<td><%=x%></td>
				<td><%=rs.getInt("idelevi_1")%></td>
				<td><%=rs.getString("numeelev")%></td>
				<td><%=rs.getString("prenumeelev")%></td>
				<td><%=rs.getString("clasaelev")%></td>
				<td><%=rs.getInt("mediaelev")%></td>
				<td><%=rs.getInt("idteme_1")%></td>
				<td><%=rs.getString("materietema")%></td>
				<td><%=rs.getString("subiecttema")%></td>
				<td><%=rs.getInt("punctajtema")%></td>
				<td><%=rs.getString("termen")%></td>
				<td><%=rs.getString("tip")%></td>
				<td><%=rs.getString("format")%></td>
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