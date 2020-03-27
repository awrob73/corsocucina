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
<%Utente u = (Utente)request.getAttribute("user"); %>
 
<div class="paginaUtenteDiv">

<h2>Benvenuto</h2>
Utente registrato: <strong> <%= u.getNome() %> <%= u.getCognome() %> </strong><br>

<form action="visualizzaDati" method="get">
<input type="hidden" name="username" value=<%=u.getUsername()%>>
<input type="submit" value='Visualizza dati'>
</form>
<p>
<form action="cercaNuoviCorsi" method="get">
<input type="hidden" name="username" value=<%=u.getUsername()%>>
<input type="submit" value="Cerca nuovi corsi">
</form>
<p>
<form action="corsiPersonali" method="get">
<input type="hidden" name="username" value=<%=u.getUsername()%>>
<input type="submit" value="I miei corsi">
</form>
<p>

<form action="logout" method="get">
<input type='submit' value='Log out'>
</form>


</div>
</body>
</html>