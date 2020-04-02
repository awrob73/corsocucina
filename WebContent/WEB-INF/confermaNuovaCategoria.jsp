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


<style>

body {
  margin: auto;
  font-family: Arial, Helvetica, sans-serif;
}

.hero-image {
  
  margin: auto;
  background-image: url("img/la_pasta_come_nonna_la_fa....jpg");
  background-color: #cccccc;
  height: 600px;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative; 
}

.hero-text {
  margin: auto;
  text-align: auto;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: black;
}

input[type=submit] {
  width: 80%;
  background-color: #800000;
  color: white;
  padding: 14px 20px 10px 10px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 13px
}

input[type=submit]:hover {
  background-color: #e40101;
  font-size: 14px;
  margin: 8px 0
}

a{
background-color: #800000;
color: black;
}

</style>
</head>
<body>

<div class="hero-image">
  <div class="hero-text">
  <div class="indexDiv"></div>

<% String descrizione = (String)request.getAttribute("descrizione"); %>
<% Utente a = (Utente)session.getAttribute("user"); %>

<h3> <strong> La categoria <%= descrizione %> </strong> è stata correttamente inserita. </h3> <p>

<form action="login" method="post">
<input type='hidden' name='username' value=<%=a.getUsername() %>>
<input type='hidden'  name='password' value=<%=a.getPassword() %>>
<input type='submit' value='Vai alla Pagina Privata Amministratore'></form>
<p>
<form action="ServletListaCategoria" method="post">
<input type="hidden" name="username" value=<% a.getUsername();%>>
<input type="submit" value="Vedi le categorie presenti">
</form>

</body>
</html>
