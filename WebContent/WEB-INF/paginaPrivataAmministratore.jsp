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
<form action="ServletInserisciCorso" method="post">
<input type="hidden" name="username" value=<% a.getUsername();%>>
<input type="submit" value="Inserisci nuovo corso">
</form>
<p>
<form action="ServletInserisciCategoria" method="post">
<input tye='text' name='descrizione'> Digita la nuova categoria<br>
<input type="hidden" name="username" value=<% a.getUsername();%>>
<input type="submit" value="Crea una nuova categoria">
</form>

<form action="ServletListaCategoria" method="post">
<input type="hidden" name="username" value=<% a.getUsername();%>>
<input type="submit" value="Vedi le categorie presenti">
</form>

<p>
<form action="ServletListaCorso" method="post">
<input type="hidden" name="username" value=<%=a.getUsername()%>>
<%-- <input type="hidden" name="password" value=<%=a.getPassword()%>> --%>
<input type="submit" value="Visualizza la lista dei corsi">
</form>
<p>

<form action="logout" method="get">
<input type='submit' value='Logout'>
</form>


</div>
</body>
</html>