<%@page import="java.util.List"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Edizione"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Edizione> listaEdizioniAttive = (List<Edizione>) request.getAttribute("listaEdizioniAttive");
	%>

	<%
		Edizione e = (Edizione) request.getAttribute("infoEdizione");
	%>
	<%
		Utente u = (Utente) session.getAttribute("user");
	%>


	Dettagli dell'edizione "<%=e.getDataInizio()%>":
	<br>

	<p>

		Corso:
		<%=e.getCorso().getTitolo()%>
		<br> DataInizio:
		<%=e.getDataInizio()%>
		<br> Durata:
		<%=e.getDurata()%>
		<br> Aula:
		<%=e.getAula()%>
		<br> Docente:
		<%=e.getDocente()%>
	<p>
		<%
			if (listaEdizioniAttive.isEmpty()) {
				out.println("<form action ='ServletIscriviUtente' method='post' >"
						+ "<input type='hidden' name='idUtente' value=" + u.getId() + ">"
						+ "<input type='hidden' name='idEdizione' value=" + e.getId() + ">"
						+ "<input type='submit' value='Iscriviti'> </form>");
			} else {
				for (Edizione edA : listaEdizioniAttive) {
					out.println("Sei già iscritto al corso: " + edA.getCorso().getTitolo()
							+ ". Disiscriviti per poter partecipare ad un altro. ");
					out.println("<form action ='corsiPersonali' method='get' >"
							+ "<input type='hidden' name='username' value=" + u.getUsername() + ">"
							+ "<input type='submit' value='Torna alla pagina dei tuoi corsi'> </form>");

				}
			}
		%>
	
	<p>
	<form action="login" method="post">
		<input type='hidden' name='username' value=<%=u.getUsername()%>>
		<input type='hidden' name='password' value=<%=u.getPassword()%>>
		<input type='submit' value='Vai alla Pagina Privata Utente'>
	</form>


</body>
</html>