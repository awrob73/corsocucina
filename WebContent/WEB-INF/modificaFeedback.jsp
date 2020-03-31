<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Feedback"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Feedback</title>
</head>
<body>

<%Feedback f = (Feedback) request.getAttribute("feedback");  %> 

<strong> <%=f.getDescrizione()%> </strong> ecco il tuo feedback, puoi modificarlo. <p>



<form action="ServletModificaFeedback" method="post">
<input type='hidden' name="idFeedback" value=<%=f.getId()%>>
<input type='hidden' name="idUtente" value=<%=f.getUtente().getId() %>>
<input type='hidden' name="idEdizione" value=<%= f.getEdizione().getId() %> >
		<strong> Descrizione </strong>
		<input type="text" name="descrizione"> <br>
		<strong> Voto </strong>
		<input type="text" name="voto" value=<%=f.getVoto() %>>  <br>
		
		<input type="submit" value="conferma la modifica">
		</form>
		

</body>
</html>