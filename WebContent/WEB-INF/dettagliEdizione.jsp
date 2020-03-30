<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Edizione"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% Edizione e = (Edizione) request.getAttribute("infoEdizione"); %>


Dettagli dell'edizione "<%= e.getDataInizio()%>": <br>

<p>

Corso: <%= e.getCorso().getTitolo() %> <br>
DataInizio: <%= e.getDataInizio() %> <br>
Durata: <%= e.getDurata() %> <br>
Aula: <%= e.getAula() %> <br>
Docente: <%= e.getDocente()%> <br>


</body>
</html>