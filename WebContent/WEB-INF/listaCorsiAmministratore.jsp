<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@page import="java.util.List"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista corsi</title>


</head>
<body>
	<%Utente a = (Utente) session.getAttribute("user"); %>
    <%List<Corso> listCorsi =(List<Corso>) request.getAttribute("listaCorsi"); %>
	
	Lista di tutti i Corsi:
<p>

<% for(Corso co: listCorsi){
	out.println(co.getTitolo());
	out.println("<li> <form action='ServletEdizioniCorso' method='post'>"); 
	out.println(" <input type='hidden' name='username' value="+ a.getUsername() + "> ");
	out.println(" <input type='hidden' name='password' value="+ a.getPassword() + "> ");
	out.println(" <input type='hidden' name='idCorso' value="+ co.getId() + "> ");
	out.println(" <input type='submit' value='edizioni'></form> <br></li>");
	
	out.println("<li> <form action='ServletModificaIntermediaCorso' method='post'>");
	out.println(" <input type='hidden' name='id' value="+ co.getId() + "> ");
	out.println(" <input type='submit' value='Modifica'></form> <br></li>");
	}%>
<p>
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
<p>
<form action="login" method="post">
<input type='hidden' name='username' value=<%=a.getUsername() %>>
<input type='hidden'  name='password' value=<%=a.getPassword() %>>
<input type='submit' value='Vai alla Pagina Privata Amministratore'></form>
</body>
</html>