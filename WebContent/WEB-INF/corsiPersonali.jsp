
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Edizione"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Corso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corsi Personali</title>
</head>
<body>
<body>

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
</head>
<body>

<div class="hero-image">
  <div class="hero-text">
  <div class="indexDiv"></div>
	<%
		List<Edizione> listaEdizioniAttive = (List<Edizione>) request.getAttribute("listaEdizioniAttive");
	%>
	<%
		List<Edizione> listaEdizioniConcluseNoFeedback = (List<Edizione>) request
				.getAttribute("listaEdizioniConcluseNoFeedback");
	%>
	<%
		List<Edizione> listaEdizioniConcluseSiFeedback = (List<Edizione>) request
				.getAttribute("listaEdizioniConcluseSiFeedback");
	%>
	<%
		Utente u = (Utente) request.getAttribute("user");
	%>

	<h1> <%=u.getNome()%>, ecco i tuoi corsi attivi: </h1>
	<br>

	<%
		if (listaEdizioniAttive.isEmpty()) {
			out.println("non ci sono corsi attivi");
		} else {
			for (Edizione edA : listaEdizioniAttive) {
				out.println("<li>Nome del corso: " + edA.getCorso().getTitolo() + " Data inizio corso: "
						+ edA.getDataInizio());

				out.println("<form action ='disiscriviUtente' method='post' >"
						+ "<input type='hidden' name='idUtente' value=" + u.getId() + ">"
						+ "<input type='hidden' name='idEdizione' value=" + edA.getId() + ">"
						+ "<input type='submit' value='annulla iscrizione'> </form>");
				out.println("<li>");
			}
		}
	%>
	<p>

		ed i tuoi corsi conclusi in attesa di inserimento del feedback:<br>

		<%
			if (listaEdizioniConcluseNoFeedback.isEmpty()) {
				out.println("non ci sono corsi in attera di inserimento feedback");
			} else {
				for (Edizione edCNoFeedback : listaEdizioniConcluseNoFeedback) {

					out.println("<li>Nome del corso: " + edCNoFeedback.getCorso().getTitolo() + " Data inizio corso: "
							+ edCNoFeedback.getDataInizio());

					out.println("<form action ='ServletInserisciFeedback' method='post' >"
							+ "<input type='hidden' name='idUtente' value=" + u.getId() + ">"
							+ "<input type='hidden' name='idEdizione' value=" + edCNoFeedback.getId() + ">"
							+ "<input type='submit' value='inserisci Feedback'> </form>");
					
					out.println("<li>");
				}
			}
		%>
	
	<p>

		ed i tuoi corsi conclusi con feedback: <br>

		<%
			if (listaEdizioniConcluseSiFeedback.isEmpty()) {
				out.println("non ci sono corsi conlusi con feedback");
			} else {
				for (Edizione edCSiFeedback : listaEdizioniConcluseSiFeedback) {

					out.println("<li>Nome del corso: " + edCSiFeedback.getCorso().getTitolo() + " Data inizio corso: "
							+ edCSiFeedback.getDataInizio() + "<li>");
				}
			}
		%>
	    
</body>
</html>