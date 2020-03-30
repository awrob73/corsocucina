<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Edizione"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Utente u = (Utente) request.getAttribute("user"); %>
<%Edizione ed = (Edizione) request.getAttribute("edizione"); %>

L'utente <%= u.getUsername() %> è stato correttamente disiscritto dal corso <%= ed.getCorso().getTitolo() %> del <%= ed.getDataInizio() %>.


</body>
</html>
