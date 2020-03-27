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

<% Utente u = (Utente) request.getAttribute("utente"); %>

Dati utente: <br>

<p> 

<%= u.getUsername() %> <br>
<%= u.getPassword() %> <br>
<%= u.getNome() %> <br>
<%= u.getCognome() %> <br>
<%= u.getDataNascita() %> <br>
<%= u.getEmail() %> <br>
<%= u.getTelefono() %> <br>

<p>

<form action="%%%%%%" method="post">
<input type='hidden' name='id' value=<%=u.getId()%>>

<input class="datiAllievoSubmit"type='submit' value='modifica allievo'>
</form>

<form action="cancella" method="post">
<input type='hidden' name='username' value=<%=u.getUsername()%>>
<input class="datiAllievoSubmit"type='submit' value='Elimina account'>
</form>


</body>
</html>