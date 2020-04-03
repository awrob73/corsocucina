
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Edizione"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci Feedback</title>
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

h1{
color: red;
}
</style>

<body>
<div class="hero-image">
  <div class="hero-text">
<% Utente u = (Utente) request.getAttribute("user"); %>
<% Edizione ed = (Edizione) request.getAttribute("edizione"); %>

<h1>Inserisci il tuo feedback del corso <%=ed.getCorso().getTitolo() %>:</h1>
	<form action="ServletConfermaFeedback" method="post">
 		<input type="hidden" name = "idUtente" value = '<%=u.getId()%>' ><br>
 		<input type="hidden" name = "idEdizione" value = '<%=ed.getId()%>' ><br>
 		<input type="text" name = "descrizione"> inserisci il tuo commento <br>
 		<input type="number" name = "voto"> voto (1-10) <br>
 		<input type="submit" value = "conferma"> <br>
 		</form>
</div>
</div>
</body>
</html>