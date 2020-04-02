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

div.datiAmministratoreDiv {
	
  width:1400px;
  height:740px;
  right:0px; top:150px;
  border: 5px double #800000;
  border-radius: 20px;
  padding: 20px;
  margin-left:10px;
  margin-right: 10px;
  background-image: url("img/fotoutentevuoto.png");
  background-size: 5%;
}
.datiAmministratoreTrovato {
	
  width:600px;
  height: 500px;
  font-size: 20px;
  border-radius: 20px;
  background-color: white;
  border: 5px double #800000;
  margin:auto;
  text-align: center;
  line-height: 35px;
  border-radius: 20px;
  border: 5px double #800000;
  margin-top: 70px;
}

.datiAmministratoreScritte{
	
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

.datiAmministratoreValori{
	
  width:200px;
  height:450x;
  font-size: 20px;
  border-radius: 20px;
  background-color: none;
  line-height: 35px;
  border-radius: 20px;
/* border: 5px double #800000; */
  text-align: left;
  margin-left: 340px;
  margin-top: -245px;
}


div.datiAmministratoreFunctions {
	
  width:600px;
  height:80px;
  font-size: 20px;
  margin-top: 50px;
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

<% Utente u = (Utente) request.getAttribute("utente"); %>
<div class="datiAmministratoreDiv">


<div class="datiAmministratoreTrovato">

<h1 style=" margin-bottom: -25px" > Amministratore trovato</h1> <br>

<img src="img/fotoutentevuoto.png" width="100px" height="100px" >

<div class="datiAmministratoreScritte">

<strong> Username </strong> <br>
<strong> Password </strong> <br>
<strong> Nome </strong> <br>
<strong> Cognome </strong> <br>
<strong> Data di nascita </strong> <br>
<strong> E-mail </strong> <br>
<strong> Telefono </strong> 

</div>

<div class="datiAmministratoreValori">

<%= u.getUsername() %> <br>
<%= u.getPassword() %> <br>
<%= u.getNome() %> <br>
<%= u.getCognome() %> <br>
<%= u.getDataNascita() %> <br>
<%= u.getEmail() %> <br>
<%= u.getTelefono() %> <br>
</div>
</div>
<div class="datiAmministratoreFunctions">
Clicca qui se desideri <span style="color:#800000"><strong>modificare</strong> </span> il tuo account <br>
<form class="datiAmministratoreActions" action="ServletModificaIntermediaA" method="post">
<input type='hidden' name='id' value=<%=u.getId()%>>
<input class="datiAmministratoreSubmit" type='submit' value='modifica dati'>
</form>

<form class="datiAmministratoreActions" action="login" method="post">
<input type='hidden' name='username' value=<%=u.getUsername() %>>
<input type='hidden'  name='password' value=<%=u.getPassword() %>>
<input  type='submit' value='Vai alla Pagina Privata Amministratore'></form>


</div>
</div>

</body>
</html>