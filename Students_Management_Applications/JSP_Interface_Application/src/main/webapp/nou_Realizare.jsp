<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page language="java"
	import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adauga Realizare.</title>
</head>
<jsp:useBean id="jb" scope="session" class="db.JavaBean" />
<jsp:setProperty name="jb" property="*" />
<body>
	<%
	int idelevi, idteme;
	String id1, id2, numeelev, prenumeelev, clasaelev, mediaelev, materietema, subiecttema, punctajtema, termen, tip, format;
	id1 = request.getParameter("idelevi");
	id2 = request.getParameter("idteme");	
	termen = request.getParameter("termen");
	tip = request.getParameter("tip");
	format = request.getParameter("format");
	if (id1 != null) {
		jb.connect();
		jb.adaugaRealizare(java.lang.Integer.parseInt(id1), java.lang.Integer.parseInt(id2), termen, tip, format);
		jb.disconnect();
	%>
	<p>Datele au fost adaugate.</p>
	<%
	} else {
	jb.connect();
	ResultSet rs1 = jb.vedeTabela("elevi");
	ResultSet rs2 = jb.vedeTabela("teme");
	%>
	<h1>Suntem in tabela Realizare.</h1>
	<form action="nou_Realizare.jsp" method="post">
		<table>
			<tr>
				<td align="right">IdElevi:</td>
				<td>Selectati elev: <SELECT NAME="idelevi">
						<%
						while (rs1.next()) {
							idelevi = rs1.getInt("idelevi");
							numeelev = rs1.getString("nume");
							prenumeelev = rs1.getString("prenume");
							clasaelev = rs1.getString("clasa");
							mediaelev = rs1.getString("media");
						%>
						<OPTION VALUE="<%=idelevi%>"><%=idelevi%>,<%=numeelev%>,<%=prenumeelev%>,<%=clasaelev%>,<%=mediaelev%></OPTION>
						<%
						}
						%>
				</SELECT>

				</td>
			</tr>
			<tr>
				<td align="right">IdTeme:</td>
				<td>Selectati tema: <SELECT NAME="idteme">
						<!-- OPTION selected="yes" VALUE="iris1">Iris 1</OPTION -->
						<%
						while (rs2.next()) {
							idteme = rs2.getInt("idteme");
							materietema = rs2.getString("materie");
							subiecttema = rs2.getString("subiect");
							punctajtema = rs2.getString("punctaj");
						%>
						<OPTION VALUE="<%=idteme%>"><%=idteme%>,<%=materietema%>,<%=subiecttema%>,<%=punctajtema%></OPTION>
						<%
						}
						%>
				</SELECT>
				</td>
			</tr>
			<tr>
				<td align="right">Termen:</td>
				<td><input type="text" name="termen" size="30" /></td>
			</tr>
			<tr>
				<td align="right">Tip:</td>
				<td><input type="text" name="tip" size="30" /></td>
			</tr>
			<tr>
				<td align="right">Format:</td>
				<td><input type="text" name="format" size="30" /></td>
			</tr>
		</table>
		<input type="submit" value="Adauga realizare" />
	</form>
	<%
 }
 %>
	<br />
	<a href="index.html"><b>Home</b></a>
	<br />
</body>
</html>