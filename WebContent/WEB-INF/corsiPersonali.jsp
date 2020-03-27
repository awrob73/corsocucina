<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Corso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corsi Personali</title>
</head>
<body>
<%List<Corso> lista = (List<Corso>) request.getAttribute("lista") ;%>
<%Utente u = (Utente) request.getAttribute("user"); %>

Caro <%=u.getNome() %>, ecco i tuoi corsi:
<p>
<%for(Corso c:lista){
	out.println("<li>"+c+"<li>");
}%>


</body>
</html>