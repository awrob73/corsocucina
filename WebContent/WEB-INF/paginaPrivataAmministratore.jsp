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
<%Utente a = (Utente)request.getAttribute("user"); %>
 
<div class="paginaPrivataAmministratoreDiv">

<div class="paginaPrivataAmministratoreDivBenvenuto">
<h1 id="paginaPrivataUtenteh1">Benvenuto</h1>
<h2 id="paginaPrivataUtenteh2"> <%= a.getNome() %> <%= a.getCognome() %> </h2><br>
</div>

<form action="ServletVisualizzaDatiAmministratore" method="post">
<input type="hidden" name="username" value='<%=a.getUsername()%>'>
<input type="submit" value='Visualizza dati'>
</form>
<p>
<form action="ServletNuovoCorso" method="get">
<input type="hidden" name="username" value=<% a.getUsername();%>>
<input type="submit" value="Inserisci nuovo corso">
</form>
<p>
<form action="ServletNuovaCategoria" method="get">
<input type="hidden" name="username" value=<% a.getUsername();%>>
<input type="submit" value="Crea una nuova categoria">
</form>
<p>
<form action="ServletListaCorsi" method="get">
<input type="hidden" name="username" value=<%=a.getUsername()%>>
<input type="submit" value="Visualizza la lista dei corsi">
</form>
<p>

<form action="logout" method="get">
<input type='submit' value='Logout'>
</form>


</div>
</body>
</html>