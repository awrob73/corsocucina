
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
		<strong> Giorno </strong>
		<input type="text" name="giorno" > <br>
		<strong> Mese </strong>
		<input type="text" name="mese" > <br>
		<strong> Anno </strong>
		<input type="text" name="anno" > <br>
	<strong> Dutata </strong>
		<input type="text" name="durata" value = <%=ed.getDurata()%> > <br>
	<strong> Aula </strong>
		<input type="text" name="aula" value = <%=ed.getAula()%> > <br>
	<strong> Docente </strong>
		<input type="text" name="docente" value = <%=ed.getDocente()%> > <br>
		<strong> Terminata </strong> <br>
		si <input type="radio" name="terminata"  id="si" value="si"> <br>
		no <input type="radio" name="terminata" id="no" value="no">
		<input type='submit' value='Modifica'>

</form>	
</body>
</html>