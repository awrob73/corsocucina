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
<style>

body {
  margin: auto;
  font-family: Arial, Helvetica, sans-serif;
}

.hero-image {

  margin: auto;
  background-image: url("img/la_pasta_come_nonna_la_fa....jpg");
  background-color: #cccccc ;
  height: 600px;
  background-position: bottom;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}

.hero-text {
  margin: auto;
  text-align: justify;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: black;
}

input[type=submit] {
  width: 100%;
  background-color: #800000;
  color: white;
  padding: 14px 20px 10px 10px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 15px
}

input[type=submit]:hover {
  background-color: #e40101;
  font-size: 15px;
  margin: 8px 0
}

a{
background-color: #800000;
color: black;
}
</style>
</head>

<div class="hero-image">
  <div class="hero-text">





<body>
<%Utente a = (Utente) session.getAttribute("user"); %>
<%List<Categoria> lista =(List<Categoria>) request.getAttribute("listaCategoria"); %>

<h1>Ecco le categorie presenti:</h1>
<p>
<% for(Categoria c: lista){
	out.println("<li>"+c.getDescrizione()+"</li>");
	}%>
<p>
<form action="ServletInserisciCategoria" method="post">
<input type='text' name='descrizione'> Digita la nuova categoria<br>
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