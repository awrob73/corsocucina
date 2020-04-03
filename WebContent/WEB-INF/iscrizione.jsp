<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Edizione"%>
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

.hero-image {
  
  margin: auto;
  background-image: url("img/cutlery_decoration_background_eat_gastronomy_knife_fork_spoon-695364.jpg");
  background-color: #cccccc;
  height: 600px;
  background-position: center;
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

a{
background-color: #800000;
color: black;
}

div.listaEdizioniAEdVecchie {
  width:350px;
  height:150px;
  margin-top: 50px;
  margin-right: 700px;
/*   border: 5px double #800000; */
/*   border-radius: 20px; */
  padding: 20px;
  margin-left:10px;
  margin-right: 10px;
  background-size: 5%;
  margin-left: 40%;
}

div.listaEdizioniAEdNuova {
	
  width:350px;
  height:230px;
  margin-top: 10px;
  margin-right: 700px;
/*   border: 5px double #800000; */
/*   border-radius: 20px; */
  padding: 20px;
  margin-left:10px;
  margin-right: 10px;
  background-size: 5%;
  text-align: left;
  margin-left: 40%;
}

div.listaEdizioniAAmm {
	
  width:350px;
  height:50px;
  margin-top: 10px;
  margin-right: 700px;
/*   border: 5px double #800000; */
/*   border-radius: 20px; */
  padding: 20px;
  margin-left:10px;
  margin-right: 10px;
  background-size: 5%;
  margin-left: 40%;
}

</style>
<body>
<div class="hero-image"> 
<%Utente u = (Utente) request.getAttribute("user"); %>
<%Edizione ed = (Edizione) request.getAttribute("edizione"); %>
<div class="listaEdizioniAEdVecchie">
<h1>L'utente <%= u.getUsername() %> è stato correttamente iscritto dal corso <%= ed.getCorso().getTitolo() %> del <%= ed.getDataInizio() %>.</h1>

<form action="corsiPersonali" method = "get">
 <input type='hidden' name='username' value=<%=u.getUsername() %>>
 <input type="submit" value = "Torna ai tuoi corsi"> <br>
 </form>
 </div>
</div>
</body>
</html>