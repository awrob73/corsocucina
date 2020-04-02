
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
	<% Edizione ed = (Edizione) request.getAttribute("edizione"); %>
	
	
<form action="ServletModificaEdizione" method="post">
	<input type='hidden' name='idEdizione' value= <%= ed.getId() %> >
		<input type="hidden" name="idCorso" value =<%=ed.getCorso().getId()%>>	
		<strong> Data di inizio </strong>
		<input type="text" name="giorno" value = <%=ed.getDataInizio().getDay()%> > <br>
		<input type="text" name="mese" value = <%=ed.getDataInizio().getMonth()%> > <br>
		<input type="text" name="anno" value = <%=ed.getDataInizio().getYear()%> > <br>
	<strong> Dutata </strong>
		<input type="text" name="durata" value = <%=ed.getDurata()%> > <br>
	<strong> Aula </strong>
		<input type="text" name="aula" value = <%=ed.getAula()%> > <br>
	<strong> Docente </strong>
		<input type="text" name="docente" value = <%=ed.getDocente()%> > <br>
		<input type='submit' value='Modifica'>

</form>	
</body>
</html>