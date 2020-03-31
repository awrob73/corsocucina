<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Corso"%>
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

<% Corso c = (Corso) request.getAttribute("corso"); 
Utente a = (Utente) session.getAttribute("user");
%>

Il corso <%= c.getTitolo() %> è stato correttamente inserito. <p>

<form action="login" method="post">
<input type='hidden' name='username' value=<%=a.getUsername() %>>
<input type='hidden'  name='password' value=<%=a.getPassword() %>>
<input type='submit' value='Vai alla Pagina Privata Amministratore'></form>
<p>

<form action="ServletListaCorso" method="post">
<input type="hidden" name="username" value=<% a.getUsername();%>>
<input type="submit" value="Vedi i corsi presenti">
</form>


</body>
</html>
