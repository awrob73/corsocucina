<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Edizione"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancella Feedback</title>
</head>
<body>

<% Utente u = (Utente) request.getAttribute("user"); %>
<% Edizione ed = (Edizione) request.getAttribute("edizione"); %>

Il feedback del corso <%= ed.getCorso().getTitolo() %> del <%= ed.getDataInizio() %> è stato correttamente cancellato.


<form action="corsiPersonali" method = "get">
 <input type='hidden' name='username' value=<%=u.getUsername() %>>
 <input type="submit" value = "Torna ai tuoi corsi"> <br>
 </form>


</body>
</html>