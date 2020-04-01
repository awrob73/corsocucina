<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Corso c = (Corso) request.getAttribute("corso"); %>
	
	
<form action="ServletModificaCorso" method="post">
	<input type='hidden' name='id' value= <%= c.getId() %> >
	<strong> Codice </strong>
		<input type="text" name="codice" value = <%=c.getCodice()%> > <br>
		<strong> Titolo </strong>
		<input type="text" name="titolo" value = <%=c.getTitolo()%> > <br>
	<strong> Categoria </strong>
		<input type="text" name="categoria" value = <%=c.getCategoria().getDescrizione()%> > <br>
		<input type="hidden" name="id_categoria" value =<%=c.getCategoria().getId()%>>
	<strong> Numero massimo di partecipanti </strong>
		<input type="text" name="maxPartecipanti" value = <%=c.getMaxPartecipanti()%> > <br>
	<strong> Costo </strong>
		<input type="text" name="costo" value = <%=c.getCosto()%> > <br>
	<strong> Descrizione</strong>
		<input type="text" name="descrizione" value = <%=c.getDescrizione()%> >
		<input type="submit" value="modifica" >
</form>	
</body>
</html>