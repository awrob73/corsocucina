<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Corso c = (Corso) request.getAttribute("corso"); %>

Dettagli corso: <br>

<p>

<%= c.getCodice() %> <br>
<%= c.getTitolo() %> <br>
<%= c.getCategoria() %> <br>
<%= c.getMaxPartecipanti() %> <br>
<%= c.getCosto() %> <br>
<%= c.getDescrizione() %> <br>

<p>
</body>
</html>
