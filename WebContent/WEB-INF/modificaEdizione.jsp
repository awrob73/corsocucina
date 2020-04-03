<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Edizione"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<style>

h1 {
color: red
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
  border: 5px double #800000; 
  border-radius: 20px;
}

 .modificaEdizioneScritte{
	
  width:150px;
  height:350px;
  font-size: 20px;
  border-radius: 20px;
  line-height: 35px;
/*   border: 5px double #800000;  */
/*   border-radius: 20px;  */
  text-align: left;
  margin-left: 40%;
  margin-top: 0px;

}
.modificaEdizionePulsanti{
	
  width:200px;
  height:360px;
  font-size: 20px;
  border-radius: 20px;
  background-color: none;
  line-height: 35px;
  border-radius: 20px;
/*   border: 5px double #800000;  */
/*   text-align: left; */
  margin-left: 50%;
  margin-top: -350px;
}

</style>
<body>

<div class="hero-image">

<h1 color="red">Compila i campi seguenti se desideri apportare modifiche ad un corso</h1>
	<% Edizione ed = (Edizione) request.getAttribute("edizione"); %>


<div class="modificaEdizioneScritte"> 
<strong> Giorno </strong><br>
<strong> Mese </strong><br>
<strong> Anno </strong><br>
<strong> Durata </strong><br>
<strong> Aula </strong><br>
<strong> Docente </strong><br>
<strong> Terminata </strong> <br>


</div>

<div class="modificaEdizionePulsanti">
<form action="ServletModificaEdizione" method="post">
	<input type='hidden' name='idEdizione' value= <%= ed.getId() %> >
		<input type="hidden" name="idCorso" value =<%=ed.getCorso().getId()%>>	
		
		<input type="text" name="giorno"> <br>
		
		<input type="text" name="mese"  > <br>
		
		<input type="text" name="anno" > <br>
	
		<input type="text" name="durata" value = <%=ed.getDurata()%> > <br>
	
		<input type="text" name="aula" value = <%=ed.getAula()%> > <br>
	
		<input type="text" name="docente" value = <%=ed.getDocente()%> > <br>
		
		si<input type="radio" name="terminata"  id="si" value="si"> 
		no<input type="radio" name="terminata" id="no" value="no"> <br>
		<input type='submit' value='Modifica'>
</form>	
</div>

</div>
</body>
</html>