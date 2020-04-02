<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<style>

</style>


<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="FormGrafica.css">
</head>
<body>
<%Utente u = (Utente)request.getAttribute("user"); %>
 
<div class="paginaPrivataUtenteDiv">

<div class="paginaPrivataUtenteDivBenvenuto">
<h1 id="paginaPrivataUtenteh1">Benvenuto</h1>
<h2 id="paginaPrivataUtenteh2"> <%= u.getNome() %> <%= u.getCognome() %> </h2><br>
</div>

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
<input type='submit' value='Logout'>
</form>
--

</div>
</body>
</html>