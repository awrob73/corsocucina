<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Feedback"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Edizione"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conferma inserimento feedback</title>
</head>
<body>

<% Utente u = (Utente) request.getAttribute("user"); %>
<% Edizione ed = (Edizione) request.getAttribute("edizione"); %>
<% Feedback fb = (Feedback) request.getAttribute("feedback"); %>

Il tuo feedback è stato correttamente inserito. 

<%= fb.getDescrizione() %> <br>
<%= fb.getVoto() %> <br>

<form action="corsiPersonali" method = "get">
 <input type='hidden' name='username' value=<%=u.getUsername() %>>
 <input type="submit" value = "Torna ai tuoi corsi"> <br>
 </form>

</body>
</html>


