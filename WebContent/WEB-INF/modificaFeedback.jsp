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
  background-color: #800000;
  color: white;
}

h1{
color: red;
}
</style>

<body>


<%Feedback f = (Feedback) request.getAttribute("feedback");  %> 

<div class="hero-image">
 <div class="hero-text">

 ecco il tuo feedback: <strong> <%=f.getDescrizione()%> </strong>, puoi modificarlo. <p>



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
	
	</div>
	</div>	

</body>
</html>