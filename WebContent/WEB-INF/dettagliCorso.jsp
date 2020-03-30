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

Dettagli del corso "<%= c.getTitolo()%>": <br>

<p>

Codice: <%= c.getCodice() %> <br>
Categoria: <%= c.getCategoria().getDescrizione() %> <br>
Numero partecipanti: <%= c.getMaxPartecipanti() %> <br>
Costo: <%= c.getCosto() %> <br>
Descrizione: <%= c.getDescrizione() %> <br>

<p>
</body>
</html>
