<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="FormGrafica.css">
</head>
<body>

<% Utente u = (Utente) request.getAttribute("utente"); %>
<div class="datiUtenteDiv">


<div class="datiUtenteUtenteTrovato">

<h1 style=" margin-bottom: -25px" > Utente trovato</h1> <br>

<img src="img/fotoutentevuoto.png" width="100px" height="100px" >

<p> 

<%= u.getUsername() %> <br>
<%= u.getPassword() %> <br>
<%= u.getNome() %> <br>
<%= u.getCognome() %> <br>
<%= u.getDataNascita() %> <br>
<%= u.getEmail() %> <br>
<%= u.getTelefono() %> <br>

<p>
</div>
<div class="datiUtenteFunctions">
Clicca qui se desideri <span style="color:#800000"><strong>modificare</strong> </span>  o <span style="color:#800000"> <strong>eliminare </strong> </span> il tuo account
<form class="datiUtenteActions" action="ServletModificaIntermediaA" method="post">
<input type='hidden' name='id' value=<%=u.getId()%>>
<input class="datiUtenteSubmit"type='submit' value='modifica dati'>
</form>

<form action="login" method="post">
<input type='hidden' name='username' value=<%=u.getUsername() %>>
<input type='hidden'  name='password' value=<%=u.getPassword() %>>
<input type='submit' value='Vai alla Pagina Privata Amministratore'></form>


</div>
</div>

</body>
</html>