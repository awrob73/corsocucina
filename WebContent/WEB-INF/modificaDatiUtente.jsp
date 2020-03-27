<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Utente u = (Utente)request.getAttribute("user"); %>

<form action="ServletModificaUtente" method="post">
<input type='hidden' name='id' value=<%=u.getId()%>>
<input type='text' name='nome' value=<%=u.getNome()%>>
<input type='text' name='cognome' value=<%=u.getCognome()%>>
<input type='text' name='password' value=<%=u.getPassword()%>>
<input type='number' name='giorno' values=<%=u.getDataNascita().getDay()%>>
<input type='number' name='mese' value=<%=u.getDataNascita().getMonth()%>>
<input type='number' name='anno' value=<%=u.getDataNascita().getYear()%>>
<input type='text' name='email' value=<%=u.getEmail()%>>
<input type='text' name='telefono' value=<%=u.getTelefono()%>>

<input type='submit' value='modifica!'>

</form>

</body>
</html>