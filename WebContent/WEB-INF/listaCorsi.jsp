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
<% List<Corso> lista = (List<Corso>)request.getAttribute("corso"); %>



Lista di tutti i Corsi: <br>

<ul>
<% for(int i = 0; i< lista.size(); i++) {
out.println("<li> <a href=infoCorso?id="+ lista.get(i).getId() +">"+ lista.get(i).getTitolo() + "</a> </li>");
}
%>
<p>

</body>
</html>