<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Corso"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.dto.EdizioneDTO"%>
<%@page import="java.util.List"%>
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

h1 {
  color:red;
  margin-top: 0px;
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
  overflow: auto;
  width:500px;
  height:100px;
  margin-top: 50px;
/*   border: 5px double #800000;  */
/*   border-radius: 20px; */
  padding: 20px;
  margin-left:10px;
  margin-right: 10px;
  background-size: 5%;
  margin-left: 35%;
  text-align: center;
}

div.listaEdizioniAEdNuova {
	
  width:1000px;
  height:300px;
  margin-top: 10px;
  margin-right: 700px;
/*   border: 5px double #800000; */
/*   border-radius: 20px; */
  padding: 20px;
  margin-left:10px;
  margin-right: 10px;
  background-size: 5%;
  text-align: center;
  margin-left: 20%;
  display: inline-block;
}

 .listaEdizioniAScritte{
	
  width:400px;
  height:350px;
  font-size: 20px;
  border-radius: 20px;
  line-height: 35px;
/*   border: 5px double #800000;  */
/*   border-radius: 20px;   */
  text-align: left;
  margin-top: -50px;
  margin-left: 200px;

}
.listaEdizioniAPulsanti{
	
  width:200px;
  height:350px;
  font-size: 20px;
  border-radius: 20px;
  background-color: none;
  line-height: 35px;
/*   border-radius: 20px;  */
/*   border: 5px double #800000;   */
  text-align: left;
  margin-top: -320px;
  margin-left: 600px;
}

div.listaEdizioniAAmm {
	
  width:300px;
  height:20px;
  margin-top: 10px;
  margin-right: 700px;
/*   border: 5px double #800000;  */
/*  border-radius: 20px;  */
  padding: 20px;
  margin-left:10px;
  margin-right: 10px;
  background-size: 5%;
  margin-left: 45%;
}
</style>

<body>

<div class="hero-image"> 
	<%
	Corso corso = (Corso) request.getAttribute("corso");
	List<EdizioneDTO>  lista = (List<EdizioneDTO>) request.getAttribute("edizioni");
	Utente a =(Utente) session.getAttribute("user");
	%>

	    <%String m =(String) request.getAttribute("messaggio"); %>
	<%=m %> <p>
	
<div class="listaEdizioniAEdVecchie">
	<h1>Lista di tutte le Edizioni: </h1>
	<br>

		<%
			for (int i = 0; i < lista.size(); i++) {
				out.println("<li>" + lista.get(i).getEdizione().getDataInizio() + "<form action='ServletCancellaEdizione' method='post'>" + 
							"<input type='hidden' name='idEdizione' value=" + lista.get(i).getEdizione().getId() + "> " + 
							"<input type='hidden' name='idCorso' value=" + corso.getId() + "> " +
							"<input type='submit' value='cancella'></form>" + "<form action='ServletModificaIntermediaEdizione' method='post'>" + 
							"<input type='hidden' name='idEdizione' value=" + lista.get(i).getEdizione().getId() + "> " + 
							"<input type='hidden' name='idCorso' value=" + corso.getId() + "> " +
							"<input type='submit' value='modifica'></form> </li>");
			}
		%>
		
</div>
<div class="listaEdizioniAEdNuova">
<h1>Clicca qui se per inserire una nuova edizione del corso </h1>

<div class="listaEdizioniAScritte"> 
<br>
Inserisci la data di inizio: <br>
<strong> Giorno[GG] </strong><br>
<strong> Mese[MM] </strong><br>
<strong> Anno[AAAA] </strong><br>
<strong> Inserisci la durata del corso </strong><br>
<strong> Inserisci l'aula corso </strong><br>
<strong> Inserisci il nome del docente del corso </strong><br>
</div>

<div class="listaEdizioniAPulsanti">
		
	<form action='ServletInserisciEdizione' method='post'> 
	<input type='hidden' name="idCorso" value= <%=corso.getId() %>>
	 <br>
	<input type='number' name='giorno'> <br>
	<input type='number' name='mese'> <br>
	<input type='number' name='anno'> <br>
	<input type='number' name='durata'> <br>
	<input type='text' name='aula'> <br>
	 <input type='text' name='docente'> <br>
	<input type='submit' value='inserisci nuova edizione'></form>
</div>
</div>

<div class="listaEdizioniAAmm">
<form action="login" method="post">
<input type='hidden' name='username' value=<%=a.getUsername() %>>
<input type='hidden'  name='password' value=<%=a.getPassword() %>>
<input type='submit' value='Vai alla Pagina Privata Amministratore'></form>
</div>
</div>
</body>
</html>