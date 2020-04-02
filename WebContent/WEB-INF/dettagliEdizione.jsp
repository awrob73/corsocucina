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
  width: 90%;
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
<body>

<div class="hero-image">
  <div class="hero-text">
  <div class="indexDiv"></div>
  
	<%
		List<Edizione> listaEdizioniAttive = (List<Edizione>) request.getAttribute("listaEdizioniAttive");
		Edizione e = (Edizione) request.getAttribute("infoEdizione");
		Utente u = (Utente) session.getAttribute("user");
	%>


Dettagli dell'edizione "<%=e.getDataInizio()%>":

	<p>

Corso: <%= e.getCorso().getTitolo() %> <br>
DataInizio: <%= e.getDataInizio() %> <br>
Durata: <%= e.getDurata() %> <br>
Aula: <%= e.getAula() %> <br>
Docente: <%= e.getDocente()%> <br>
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