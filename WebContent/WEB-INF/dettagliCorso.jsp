<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Feedback"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.dto.EdizioneDTO"%>
<%@page import="java.util.List"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dettaglio corso</title>
<script type="text/javascript">
 	//Tag per scrivere in Javascript
 	
 	function getFeedbacks(){
 		
 		
 		var idCorso = document.getElementById('h1').value;
 		var xhttp = new XMLHttpRequest();
 		
 		
 		//gestione della risposta
 		xhttp.onreadystatechange = function(){
 			if(this.readyState == 4 && this.status == 200){
 				
 				document.getElementById('demo').innerHTML = this.responseText;
 			}
 		}
 		
 		//gestione richiesta
 		xhttp.open("POST", "ServletListaFeedback?idCorso=" + idCorso, true);
 		xhttp.send();
 		
 		//alert
 		
 	};
 	
</script>

</head>

<style>
.dettagliCorsoDiv { 
  background-image: url("img/aaa.jpg");
  background-size: 100%;
  width:1400px;
  height:900px; 
  margin: auto;
  border: 5px double #800000; 
  border-radius: 20px; 
  text-align: center;
  font-size: 30px;
  list-style-type: none;
	
}


.dettagliCorsoDivDettagli{
  font-family: Informal Roman;
  font-weight:bold;
  position:relative;
  margin-left:500px;
  margin-top: 120px;
  font-size: 25px;
  color:red;
  width:800px;
  height:200px;
  line-height: 40px;
  text-align: center;
/*   border: 5px double #800000;order: thick; */
}

.dettagliCorsoDivDescrizione {
  position:relative;
  margin-left:400px;
  font-weight: bold;
  margin-top: 30px;
  font-family: Informal Roman;
  font-size: 25px;
  color:black;
  padding-right: 25px;
  padding-left: 25px;
  width:800px;
  height:430px;
  line-height: 30px;
  text-align: justify;
/*   border: 5px double #800000;order: thick; */
}
.dettagliCorsoDivForm {
  width:900px;
  height:50px;
  position:relative;
  margin-left:350px;
  margin-top: 0px;
  font-size: 30px;
  padding-right: 25px;
  padding-left: 25px;
/*   border: 5px double #800000;order: thick; */
  text-align: center;
}

.dettagliCorsoActions {
	display: inline;
	padding: 10px;
/* 	border: 5px double #800000;order: thick; */
	
}
#dettagliCorsoButtonSubmit{
  width: 140px;
  height: 40px;
  background-color: red;
  color: white;
  text-align:center;
  vertical-align: middle;
  border-radius: 4px;
  cursor: pointer;
  font-size: 15px;
  display: inline-block;
}
</style>

<body>
<div  class="dettagliCorsoDiv">
<% Corso c = (Corso) request.getAttribute("corso"); %>
<% List<EdizioneDTO> listaEdizioniDTO = (List<EdizioneDTO>) request.getAttribute("listaEdizioniDTO"); %>
<% Utente u = (Utente) session.getAttribute("user"); %>

<div class="dettagliCorsoDivDettagli">
<strong><a style="color:green; font-size:50px; text-transform: uppercase; ">" <%= c.getTitolo()%>"</a> </strong> <br>

<strong>Codice: </strong> <a style="color:black;"> <%= c.getCodice() %> </a> <br>
<strong>Categoria: </strong>  <a style="color:black;">  <%= c.getCategoria().getDescrizione() %> </a> <br>
<strong>Numero partecipanti: </strong> <a style="color:black;">  <%= c.getMaxPartecipanti() %> </a> <br>
<strong>Costo:</strong>  <a style="color:black;">  <%= c.getCosto() %>  euro </a>  <br>

</div>

<div class="dettagliCorsoDivDescrizione">
<strong><a style="color:red;">Descrizione:</a> </strong>  <%= c.getDescrizione() %> <br>
</div>


	<div class="dettagliCorsoDivForm">
<form class="dettagliCorsoActions"><input id="dettagliCorsoButtonSubmit" type = 'button' value = 'vedi recensioni' onClick='getFeedbacks()'>
	<input id = 'h1' type = 'hidden' name ='idCorso' value=<%=c.getId() %>></form>
	
	<form class="dettagliCorsoActions" action="ServletEdizioniCorso" method="post">
<input type="hidden" name="idCorso" value=<%=c.getId() %>>
<input type="hidden" name="username" value=<%=u.getUsername() %>>
<input type="hidden" name="password" value=<%=u.getPassword() %>>
<input id="dettagliCorsoButtonSubmit" type="submit" value="Visualizza edizioni">
</form>
	
	<form action="login" method="post">
		<input type='hidden' name='username' value=<%=u.getUsername()%>>
		<input type='hidden' name='password' value=<%=u.getPassword()%>>
		<input type='submit' value='Torna alla Pagina Privata Utente'>
	</form>
</div>

<li><div id='demo'></div></li>


</div> 	 
</body>
</html>


