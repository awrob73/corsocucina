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
<%Utente a = (Utente) session.getAttribute("user"); %>
<form action="ServletInserisciCorso" method="post">
<input type='text' name='codice'> Digita il codice del nuovo corso<br>
<input type='text' name='titolo'> Digita il titolo del nuovo corso<br>
<input type='text' name='idCategoria'> Digita l'id della categoria<br>
<input type='text' name='maxPartecipanti'> Digita il numero massimo di partecipanti<br>
<input type='text' name='costo'> Digita il costo del corso<br>
<input type='text' name='descrizione'> Digita la descrizione del nuovo corso<br>
<input type="hidden" name="username" value=<% a.getUsername();%>>
<input type="submit" value="Crea un nuovo corso">
</form>
</body>
</html>