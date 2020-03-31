<%@page import="java.util.List"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Categoria"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListaCategorie</title>
</head>
<body>
<%Utente a = (Utente) session.getAttribute("user"); %>
<%List<Categoria> lista =(List<Categoria>) request.getAttribute("listaCategoria"); %>

Ecco le categorie presenti:
<p>
<% for(Categoria c: lista){
	out.println("<li>"+c.getDescrizione()+"</li>");
	}%>
<p>
<form action="ServletInserisciCategoria" method="post">
<input tye='text' name='descrizione'> Digita la nuova categoria<br>
<input type="hidden" name="username" value=<% a.getUsername();%>>
<input type="submit" value="Crea una nuova categoria">
</form>
<p>
<form action="login" method="post">
<input type='hidden' name='username' value=<%=a.getUsername() %>>
<input type='hidden'  name='password' value=<%=a.getPassword() %>>
<input type='submit' value='Vai alla Pagina Privata Amministratore'></form>
</body>
</html>