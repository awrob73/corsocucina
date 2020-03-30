<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Edizione"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci Feedback</title>
</head>
<body>

<% Utente u = (Utente) request.getAttribute("user"); %>
<% Edizione ed = (Edizione) request.getAttribute("edizione"); %>

	<form action="ServletConfermaFeedback" method="post">
 		<input type="hidden" name = "idUtente" value = '<%=u.getId()%>' ><br>
 		<input type="hidden" name = "idEdizione" value = '<%=ed.getId()%>' ><br>
 		<input type="text" name = "descrizione"> inserisci il tuo commento <br>
 		<input type="number" name = "voto"> voto (1-10) <br>
 		<input type="submit" value = "conferma"> <br>
 		</form>

</body>
</html>