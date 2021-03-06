<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica Dati Amministratore</title>
<!-- <link rel="stylesheet" type="text/css" href="FormGrafica.css"> -->
</head>

<style>

div.modificaDatiAmministratoreDiv {
	
  width:1400px;
  height:740px;
  right:0px; top:150px;
  background-image: url("img/cannavacciuolo3_2.jpg");  background-image: url("img/fotoutentevuoto.png");
  background-size: 5%;-radius: 20px;
  padding: 20px;
  margin-left:10px;
  margin-right: 10px;
  background-color: white;
  background-size: 5%;
}

.modificadatiAmministratoreModifiche {
	
  width:600px;
  height:450x;
  font-size: 20px;
  border-radius: 20px;
  background-color:white;
  border: 5px double #800000;
  margin:auto;
  margin-top: 70px;
  text-align: center;
  line-height: 35px;
  border-radius: 20px;
  border: 5px double #800000;
}

 .modificaDatiAmministratoreScritte{
	
  width:150px;
  height:450x;
  font-size: 20px;
  border-radius: 20px;
  line-height: 35px;
  border-radius: 20px;
/*   border: 5px double #800000; */
  text-align: left;
  margin-left: 150px;

}

 .modificaDatiAmministratorePulsanti{
	
  width:200px;
  height:450x;
  font-size: 20px;
  border-radius: 20px;
  background-color: none;
  line-height: 35px;
  border-radius: 20px;
/*   border: 5px double #800000; */
  text-align: left;
  margin-left: 300px;
  margin-top: -350px;
}


div.datiAmministratoreFunctions {
	
  width:500px;
  height:80px;
  font-size: 20px;
  margin-top: 100px;
  background-color: white;
  border-radius: 20px;
  border: 5px double #800000;
  margin-left:auto;
  margin-right:auto;
  text-align: center;

}

.datiAmministratoreActions {
	display: inline;
	padding: 40px;
	
}
.datiAmministratoreSubmit[type=submit] {
  width: 140px;
  height: 40px;
  background-color: #800000;
  color: white;
  text-align:center;
  vertical-align: middle;
  border-radius: 4px;
  cursor: pointer;
  font-size: 15px;
  display: inline-block;
}
.datiAmministratoreSubmit[type=submit]:hover {
  width: 140px;
  height: 40px;
  background-color: #e40101;
  font-size: 15px;
}



</style>


<body>
 <div class="modificaDatiAmministratoreDiv">


<div class="modificadatiAmministratoreModifiche">

<%Utente a = (Utente)request.getAttribute("amministratore");  %> 
<strong> <%=a.getUsername()%> </strong> ecco i tuoi dati, puoi modificarli. <p>

<img src="img/fotoutentevuoto.png" width="100px" height="100px" >

<div class="modificaDatiAmministratoreScritte">

<strong> Username </strong> <br>
<strong> Password </strong> <br>
<strong> Nome </strong> <br>
<strong> Cognome </strong> <br>
<strong> Data di nascita </strong> <br>
<strong> Giorno </strong> <br>
<strong> Mese </strong> <br>
<strong> Anno </strong> <br>
<strong> E-mail </strong> <br>
<strong> Telefono </strong> 

</div>

<div class="modificaDatiAmministratorePulsanti">
<form action="ServletModificaAmministratore" method="post">
<input type='hidden' name='id' value=<%=a.getId()%>>
		<input type="text" name="username" value = <%=a.getUsername()%> > <br>
		<input type="text" name="password" value=<%=a.getPassword() %>>  <br>
		<input type="text" name="nome" value=<%=a.getNome() %>>  <br>
		<input type="text" name="cognome" value= <%=a.getCognome() %> >  <br>		
        <br>
		<input type="number" name="giorno" >  <br>
		<input type="number" name="mese" >  <br>

		<input type="number" name="anno" >  <br>	

	    <input type="text" name="email" value=<%=a.getEmail() %>>  <br>

	    <input type="text" name="telefono" value=<%=a.getTelefono() %>>  <br>
	    
<input type="submit" value="modifica">
</form>
</div>
		

</div>

</div>

</body>
</html>

