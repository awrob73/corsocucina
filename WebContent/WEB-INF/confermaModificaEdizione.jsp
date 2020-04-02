
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Corso"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@page import="java.util.List"%>
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
	<%Utente a = (Utente)session.getAttribute("user"); %>
	<% Edizione ed = (Edizione) request.getAttribute("edizione"); %>
	
	la modifica dell'edizione del <%= ed.getDataInizio() %> è avvenuta con successo
	<form action="ServletEdizioniCorso" method="post">
	<input type="hidden" name="username" value=<%=a.getUsername()%>>
	<input type="hidden" name="password" value=<%=a.getPassword()%>>
	<input type="hidden" name="idCorso" value=<%=ed.getCorso().getId()%>>
	<input type="submit" value="Visualizza la lista delle edizioni">
	</form>
<p>

</body>
</html>