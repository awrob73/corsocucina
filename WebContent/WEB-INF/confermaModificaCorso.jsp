<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@page import="java.util.List"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ConfermaModificaCorso</title>
</head>

<style>

body {
  margin: auto;
  font-family: Arial, Helvetica, sans-serif;
}

h1{
color: red;
font-size: 30px;
}

.hero-image {
  
  margin: auto;
  background-image: url("img/cutlery_decoration_background_eat_gastronomy_knife_fork_spoon-695364.jpg");
  background-color: #cccccc;
  height: 600px;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative; 
  text-align: center;
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

div.listaEdizioniAEdVecchie {
  width:350px;
  margin-top: 50px;
  margin-right: 700px;
/*   border: 5px double #800000; */
/*   border-radius: 20px; */
  padding: 20px;
  background-size: 5%;
  margin-left: 40%;
  margin-top: 0px;
}

</style>
<body>

<div class="hero-image">
<div class="listaEdizioniAEdVecchie">
	<%Utente a = (Utente)session.getAttribute("user"); %>
	<% Corso c = (Corso) request.getAttribute("corso"); %>
	<h1>la modifica del corso <%= c.getTitolo() %> è avvenuta con successo </h1><br>
	<form action="ServletListaCorso" method="post">
	<input type="hidden" name="username" value=<%=a.getUsername()%>>
	<input type="submit" value="Visualizza la lista dei corsi">
	</form>
</div>
</div>
</body>
</html>