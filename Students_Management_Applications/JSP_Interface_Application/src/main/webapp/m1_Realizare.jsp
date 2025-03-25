<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"
	import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tabela Realizare</title>
<link href="table.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<jsp:useBean id="jb" scope="session" class="db.JavaBean" />
<jsp:setProperty name="jb" property="*" />
<body>
	<h1 align="center">Tabela Realizare:</h1>
	<br />
	<p align="center">
		<a href="nou_Realizare.jsp"><b>Adauga Realizare.</b></a> <a
			href="index.html"><b>Home</b></a>
	</p>
	<%
	jb.connect();
	int mediaelev,punctajtema;
	String  numeelev, prenumeelev, clasaelev, materietema, subiecttema, termen, tip, format;
	int aux = java.lang.Integer.parseInt(request.getParameter("primarykey"));
	ResultSet rs = jb.intoarceRealizareId(aux);
	rs.first();
	int id1 = rs.getInt("idelevi_1");
	int id2 = rs.getInt("idteme_1");
	numeelev = rs.getString("numeelev");
	prenumeelev = rs.getString("prenumeelev");
	clasaelev = rs.getString("clasaelev");
	mediaelev = rs.getInt("mediaelev");
	materietema = rs.getString("materietema");
	subiecttema = rs.getString("subiecttema");
	punctajtema = rs.getInt("punctajtema");
	termen = rs.getString("termen");
	tip = rs.getString("tip");
	format = rs.getString("format");
	ResultSet rs1 = jb.vedeTabela("elevi");
	ResultSet rs2 = jb.vedeTabela("teme");
	int idelevi, idteme;
	%>
	<form action="m2_Realizare.jsp" method="post">
		<table align="center">
			<tr>
				<td align="right">IdRealizare:</td>
				<td><input type="text" name="idrealizare" size="30"
					value="<%=aux%>" readonly /></td>
			</tr>
			<tr>
				<td align="right">idelevi:</td>
				<td><SELECT NAME="idelevi">
						<%
						while (rs1.next()) {
							idelevi = rs1.getInt("idelevi");
							numeelev = rs1.getString("nume");
							prenumeelev = rs1.getString("prenume");
							clasaelev = rs1.getString("clasa");
							mediaelev = rs1.getInt("media");
							if (idelevi != id1) {
						%>
						<OPTION VALUE="<%=idelevi%>"><%=idelevi%>,
							<%=numeelev%>,
							<%=prenumeelev%>,
							<%=clasaelev%>,
							<%=mediaelev%></OPTION>
						<%
						} else {
						%>
						<OPTION selected="yes" VALUE="<%=idelevi%>"><%=idelevi%>,
							<%=numeelev%>,
							<%=prenumeelev%>,
							<%=clasaelev%>,
							<%=mediaelev%></OPTION>
						<%
						}
						}
						%>
				</SELECT></td>
			</tr>
			<tr>
				<td align="right">idteme:</td>
				<td><SELECT NAME="idteme">
						<%
						while (rs2.next()) {
							idteme = rs2.getInt("idteme");
							materietema = rs2.getString("materie");
							subiecttema = rs2.getString("subiect");
							punctajtema = rs2.getInt("punctaj");
							if (idteme != id2) {
						%>
						<OPTION VALUE="<%=idteme%>"><%=idteme%>,
							<%=materietema%>,
							<%=subiecttema%>,
							<%=punctajtema%></OPTION>
						<%
						} else {
						%>
						<OPTION selected="yes" VALUE="<%=idteme%>"><%=idteme%>,
							<%=materietema%>,
							<%=subiecttema%>,
							<%=punctajtema%></OPTION>
						<%
						}
						}
						%>
				</SELECT></td>
			</tr>
			<tr>
				<td align="right">Termen:</td>
				<td><input type="text" name="termen" size="30"
					value="<%=termen%>" /></td>
			</tr>
			<tr>
				<td align="right">Tip:</td>
				<td><input type="text" name="tip" size="30"
					value="<%=tip%>" /></td>
			</tr>
			<tr>
				<td align="right">Format:</td>
				<td><input type="text" name="format" size="30"
					value="<%=format%>" /></td>
			</tr>
		</table>
		<p align="center">
			<input type="submit" value="Modifica linia">
		</p>
	</form>
	<p align="center">
		<a href="index.html"><b>Home</b></a> <br />
</body>
<%
 rs.close();
 rs1.close();
 rs2.close();
 jb.disconnect();
 %>
</html>