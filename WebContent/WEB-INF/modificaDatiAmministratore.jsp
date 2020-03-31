

<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Dati Utente</title>
<!-- <link rel="stylesheet" type="text/css" href="FormGrafica.css"> -->
<div class="ModificaUtenteDiv">
</head>
<body>


<%Utente a = (Utente)request.getAttribute("amministratore");  %> 
<strong> <%=a.getUsername()%> </strong> ecco i tuoi dati, puoi modificarli. <p>

<form action="ServletModificaAmministratore" method="post">
<input type='hidden' name='id' value=<%=a.getId()%>>
		<strong> Username </strong>
		<input type="text" name="username" value = <%=a.getUsername()%> > <br>
		<strong> Password </strong>
		<input type="text" name="password" value=<%=a.getPassword() %>>  <br>
        <strong> Nome </strong>
		<input type="text" name="nome" value=<%=a.getNome() %>>  <br>
		<strong> Cognome </strong>
		<input type="text" name="cognome" value= <%=a.getCognome() %> >  <br>		
		<strong> Data di nascita </strong> <br>
		<strong> Giorno </strong> 
		<input type="number" name="giorno" value=<%=a.getDataNascita().getDay() %>  >  <br>
		<strong> Mese </strong> 
		<input type="number" name="mese" value=<%=a.getDataNascita().getMonth() %> >  <br>
		<strong> Anno </strong>  
		<input type="number" name="anno" value=<%=a.getDataNascita().getYear() %> >  <br>	
		<strong> Email </strong>
	    <input type="text" name="email" value=<%=a.getEmail() %>>  <br>
	    <strong> Telefono </strong>
	    <input type="text" name="telefono" value=<%=a.getTelefono() %>>  <br>
	    
		<input type="submit" value="modifica">

</form>

</div>

</body>
</html>

