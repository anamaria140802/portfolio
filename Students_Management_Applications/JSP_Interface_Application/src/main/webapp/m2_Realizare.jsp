<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"
	import="java.lang.*,java.math.*,db.*,java.sql.*, java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tabela realizare</title>
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
	int aux = java.lang.Integer.parseInt(request.getParameter("idrealizare"));
	String Idelevi = request.getParameter("idelevi");
	String Idteme = request.getParameter("idteme");
	String Termen = request.getParameter("termen");
	String Tip = request.getParameter("tip");
	String Format = request.getParameter("format");
	String[] valori = { Idelevi, Idteme ,Termen, Tip, Format };
	String[] campuri = { "idelevi", "idteme","termen", "tip", "format" };
	jb.modificaTabela("realizare", "idrealizare", aux, campuri, valori);
	jb.disconnect();
	%>
	<h1 align="center">Modificarile au fost efectuate !</h1>
	<p align="center">
		<a href="index.html"><b>Home</b></a> <br />
</body>
</html>