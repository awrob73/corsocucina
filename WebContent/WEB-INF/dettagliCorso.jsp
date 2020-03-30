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
 		
 	};
 	
</script>

</head>
<body>
<% Corso c = (Corso) request.getAttribute("corso"); %>
<% List<EdizioneDTO> listaEdizioniDTO = (List<EdizioneDTO>) request.getAttribute("listaEdizioniDTO"); %>

<% Utente u = (Utente) session.getAttribute("user"); %>

Dettagli del corso "<%= c.getTitolo()%>": <br>

<p>
Codice: <%= c.getCodice() %> <br>
Categoria: <%= c.getCategoria().getDescrizione() %> <br>
Numero partecipanti: <%= c.getMaxPartecipanti() %> <br>
Costo: <%= c.getCosto() %> <br>
Descrizione: <%= c.getDescrizione() %> <br>
<p>
	<% out.println("<form><input type = 'button' value = 'vedi recensioni' onClick='getFeedbacks()'>");
	out.println("<input id = 'h1' type = 'hidden' name ='idCorso' value="+ c.getId() +"></form> <br>");%>

<li><div id='demo'></div></li>
 	 
</body>
</html>


