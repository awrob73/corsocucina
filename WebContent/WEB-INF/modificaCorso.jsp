<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Corso"%>
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

 .modificaCorsoScritte{
	
  width:200px;
  height:350px;
  font-size: 20px;
  border-radius: 20px;
  line-height: 35px;
/*    border: 5px double #800000;   */
/*    border-radius: 20px;   */
  text-align: left;
  margin-left: 42%;
  margin-top: 100px;

}
.modificaCorsoPulsanti{
	
  width:600px;
  height:350px;
  font-size: 20px;
  border-radius: 20px;
  background-color: none;
  line-height: 35px;
/*   border-radius: 20px;   */
/*   border: 5px double #800000;   */
  text-align: left;
  margin-left: 53%;
  margin-top: -350px;
}
</style>
<body>



<div class="hero-image">
	<% Corso c = (Corso) request.getAttribute("corso"); %>

<h1 color="red">Compila i campi seguenti se desideri apportare modifiche ad un corso</h1>

<div class="modificaCorsoScritte"> 
<strong> Codice </strong><br>
<strong> Titolo </strong><br>
<strong> Categoria </strong><br>
<strong> Numero massimo <br>
 di partecipanti </strong><br>
<strong> Costo </strong><br>
<strong> Descrizione </strong><br>
</div>



<div class="modificaCorsoPulsanti">
<form action="ServletModificaCorso" method="post">
	<input type='hidden' name='id' value= <%= c.getId() %> >
		<input type="text" name="codice" value = <%=c.getCodice()%> > <br>
		<input type="text" name="titolo" > <%=c.getTitolo()%><br>
		<input type="text" name="categoria"> <%=c.getCategoria().getDescrizione()%><br>
		<input type="hidden" name="id_categoria" value =<%=c.getCategoria().getId()%>>
		<input type="text" name="maxPartecipanti" value = <%=c.getMaxPartecipanti()%> > <br> <br>
		<input type="text" name="costo" value = <%=c.getCosto()%> > <br>
		<input type="text" name="descrizione" ><br>
		<input type="submit" value="modifica" >
</form>	
</div>
</div>
</body>
</html>