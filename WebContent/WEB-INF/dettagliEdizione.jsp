<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
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
<% Utente u = (Utente) session.getAttribute("user"); %>

Dettagli dell'edizione "<%= e.getDataInizio()%>": <br>

<p>

Corso: <%= e.getCorso().getTitolo() %> <br>
DataInizio: <%= e.getDataInizio() %> <br>
Durata: <%= e.getDurata() %> <br>
Aula: <%= e.getAula() %> <br>
Docente: <%= e.getDocente()%> <br>

<form action="login" method="post">
<input type='hidden' name='username' value=<%=u.getUsername() %>>
<input type='hidden'  name='password' value=<%=u.getPassword() %>>
<input type='submit' value='Vai alla Pagina Privata Amministratore'></form>


</body>
</html>