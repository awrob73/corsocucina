
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Feedback"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Edizione"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conferma inserimento feedback</title>
</head>
<style>

body {
  margin: auto;
  font-family: Arial, Helvetica, sans-serif;
}

.hero-image {

  margin: auto;
  background-image: url("img/cutlery_decoration_background_eat_gastronomy_knife_fork_spoon-695364.jpg");
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
  background-color: #800000;
  color: white;
}

a{
background-color: #800000;
color: black;
}
</style>

<body>

<% Utente u = (Utente) request.getAttribute("user"); %>
<% Edizione ed = (Edizione) request.getAttribute("edizione"); %>
<% Feedback fb = (Feedback) request.getAttribute("feedback"); %>

<div class="hero-image">
 <div class="hero-text">
 
Il tuo feedback è stato correttamente inserito: <br> 

<%= fb.getDescrizione() %> <br>
Voto:<%= fb.getVoto() %> <br>

<form action="corsiPersonali" method = "get">
 <input type='hidden' name='username' value=<%=u.getUsername() %>>
 <input type="submit" value = "Torna ai tuoi corsi"> <br>
 </form>

</body>
</html>


