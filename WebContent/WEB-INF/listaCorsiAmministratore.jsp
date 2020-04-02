<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@page import="java.util.List"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista corsi</title>


</head>
<style>
.listaCorsiAmministratore {
  background-image: url("img/listaCorsi1.2.jpg");
  background-size: 100%;
  background-repeat: no-repeat;
/*   border: 5px double #800000; */
/*   border-radius: 20px; */
  padding: 20px;
  text-align: center;
  font-size: 50px;
  color: red;
  vertical-align: middle;
  font-size: 70px;
  font-weight: bold;
}
.listaCorsiAmministratoreDiv {
  overflow: auto;
  width:1400px;
  height:450px;
/*   border: 5px double #800000; */
/*   border-radius: 20px; */
  padding: 20px;
  background-repeat: no-repeat;
  text-align: center;
  color: red;
  vertical-align: middle;
  margin: auto;
  
}
ul {
	font-size: 30px;
	line-height:15px;
	margin-top:50px;
	list-style-type: none;
}
 li {
 color: white;
 font-family:cursive;
 vertical-align: middle;
 }
li:hover{
 color: red;
 font-family:cursive;
 vertical-align: middle;
 }
 .listaCorsiSubmit[type=submit] {
 margin-top: 20px;
  width: 25%;
  height: 30px;
  background-color: #800000;
  color: white;
  border: none;
  padding: 0px;
  border-radius: 4px;
  cursor: pointer;
  font-size: 15px;
  
}
.listaCorsiSubmit[type=submit]:hover {
 margin-top: 20px;
  width: 25%;
  height: 30px;
  background-color: red;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 15px;
  }
  
  .listaCorsiAmministratoreSezioneCorsi {
  width:1400px;
  height:250px;
/*   border: 5px double #800000; */
/*   border-radius: 20px; */
  padding: 20px;
  background-repeat: no-repeat;
  text-align: center;
  color: white;
  font-size: 20px;;
  vertical-align: middle;
  margin: auto;
}
  
  .listaCorsiAmministratoreScritte{
	
  width:400px;
  height:450x;
  font-size: 20px;
  border-radius: 20px;
  line-height: 35px;
/*   border-radius: 20px; */
/*   border: 5px double #800000; */
  text-align: left;
  margin-left: 400px;
  color: red;

}

 .listaCorsiAmministratorePulsanti{
	
  width:200px;
  height:450x;
  font-size: 20px;
  border-radius: 20px;
  background-color: none;
  line-height: 35px;
/*   border-radius: 20px; */
/*   border: 5px double #800000; */
  text-align: left;
  margin-left: 850px;
  margin-top: -210px;
}
</style>
<body class="listaCorsiAmministratore">
	<%Utente a = (Utente) session.getAttribute("user"); %>
    <%List<Corso> listCorsi =(List<Corso>) request.getAttribute("listaCorsi"); %>
	
	Ecco la lista dei corsi già presenti:

<div class="listaCorsiAmministratoreDiv">

<ul>
<% for( Corso co: listCorsi){
	out.println( "<li>"+co.getTitolo());
	out.println("<form action='ServletEdizioniCorso' method='post'>"); 
	out.println(" <input type='hidden' name='username' value="+ a.getUsername() + "> ");
	out.println(" <input type='hidden' name='password' value="+ a.getPassword() + "> ");
	out.println(" <input type='hidden' name='idCorso' value="+ co.getId() + "> ");
	out.println(" <input class='listaCorsiSubmit' type='submit' value='edizioni'></form> <br></li>");
	
	out.println("<li> <form action='ServletModificaIntermediaCorso' method='post'>");
	out.println(" <input type='hidden' name='id' value="+ co.getId() + "> ");
	out.println(" <input class='listaCorsiSubmit' type='submit' value='Modifica'></form> <br></li>");
	}%>
	
</div>

Clicca qui se invece vuoi creare un nuovo corso

<div class="listaCorsiAmministratoreSezioneCorsi">
<div class="listaCorsiAmministratoreScritte">

<strong> Inserisci codice del nuovo corso </strong> <br>
<strong> Inserisci il titolo del nuovo corso </strong> <br>
<strong> Digita l'ID della categoria </strong> <br>
<strong> Digita il numero massimo di partecipanti</strong> <br>
<strong> Digita il costo del corso </strong> <br>
<strong> Digita la descrizione del nuovo corso </strong> <br>

</div>

<div class="listaCorsiAmministratorePulsanti">

<form action="ServletInserisciCorso" method="post">
<input type='text' name='codice'><br>
<input type='text' name='titolo'> <br>
<input type='text' name='idCategoria'> <br>
<input type='text' name='maxPartecipanti'> <br>
<input type='text' name='costo'> <br>
<input type='text' name='descrizione'> <br>
<input type="hidden" name="username" value=<% a.getUsername();%>>
<input type="submit" value="Crea un nuovo corso">
</form>

<form action="login" method="post">
<input type='hidden' name='username' value=<%=a.getUsername() %>>
<input type='hidden'  name='password' value=<%=a.getPassword() %>>
<input type='submit' value='Vai alla Pagina Privata Amministratore'></form>

</div>
</div>


</body>
</html>