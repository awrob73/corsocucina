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

<style>

body {
  margin: auto;
  font-family: Arial, Helvetica, sans-serif;
}

h1{
color: red;
font-size: 30px;
}

.hero-image {
  
  margin: auto;
  background-image: url("img/cutlery_decoration_background_eat_gastronomy_knife_fork_spoon-695364.jpg");
  background-color: #cccccc;
  height: 600px;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative; 
  text-align: center;
}

input[type=submit] {
  width: 100%;
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

div.listaEdizioniAEdVecchie {
  width:350px;
  margin-top: 50px;
  margin-right: 700px;
/*   border: 5px double #800000; */
/*   border-radius: 20px; */
  padding: 20px;
  background-size: 5%;
  margin-left: 40%;
  margin-top: 0px;
}

</style>
<body>

<div class="hero-image"> 
<% Corso c = (Corso) request.getAttribute("corso"); 
Utente a = (Utente) session.getAttribute("user");
%>
<div class="listaEdizioniAEdVecchie">
<h1>Il corso <%= c.getTitolo() %> è stato correttamente inserito. </h1><br>



<form action="login" method="post">
<input type='hidden' name='username' value=<%=a.getUsername() %>>
<input type='hidden'  name='password' value=<%=a.getPassword() %>>
<input type='submit' value='Vai alla Pagina Privata Amministratore'></form>
<p>

<form action="ServletListaCorso" method="post">
<input type="hidden" name="username" value=<% a.getUsername();%>>
<input type="submit" value="Vedi i corsi presenti">
</form>

</div>

</div>
</body>
</html>
