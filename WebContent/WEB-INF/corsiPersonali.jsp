
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

	<%=u.getNome()%>, ecco i tuoi corsi attivi:
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
