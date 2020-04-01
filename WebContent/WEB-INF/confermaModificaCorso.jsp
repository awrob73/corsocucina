<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@page import="java.util.List"%>
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
	<%Utente a = (Utente)session.getAttribute("user"); %>
	<% Corso c = (Corso) request.getAttribute("corso"); %>
	la modifica del corso <%= c.getTitolo() %> è avvenuta con successo
	<form action="ServletListaCorso" method="post">
	<input type="hidden" name="username" value=<%=a.getUsername()%>>
	<input type="submit" value="Visualizza la lista dei corsi">
	</form>
<p>
</body>
</html>