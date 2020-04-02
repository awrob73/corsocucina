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
<body>

	<%
	Corso corso = (Corso) request.getAttribute("corso");
	List<EdizioneDTO>  lista = (List<EdizioneDTO>) request.getAttribute("edizioni");
	Utente a =(Utente) session.getAttribute("user");
	%>

   <%String m =(String) request.getAttribute("messaggio"); %>
	<%=m %> <p>
	 

	Lista di tutte le Edizioni:
	<br>

		<%
			for (int i = 0; i < lista.size(); i++) {
				out.println("<li>" + lista.get(i).getEdizione().getDataInizio() + "<form action='ServletCancellaEdizione' method='post'>" + 
							"<input type='hidden' name='idEdizione' value=" + lista.get(i).getEdizione().getId() + "> " + 
							"<input type='hidden' name='idCorso' value=" + corso.getId() + "> " +
							"<input type='submit' value='cancella'></form>" + "<form action='ServletModificaEdizione' method='post'>" + 
							"<input type='hidden' name='idEdizione' value=" + lista.get(i).getEdizione().getId() + "> " + 
							"<input type='hidden' name='idCorso' value=" + corso.getId() + "> " +
							"<input type='submit' value='modifica'></form> </li>");
			}
		%>
		
	<form action='ServletInserisciEdizione' method='post'> 
	<input type='hidden' name="idCorso" value= <%=corso.getId()%>>
	Inserisci la data di inizio: <br>
	Giorno [GG] <input type='number' name='giorno'> Mese [MM] <input type='number' name='mese'> Anno [AAAA] <input type='number' name='anno'> <br>
	Inserisci la durata del corso <input type='number' name='durata'> <br>
	Inserisci l'aula del corso <input type='text' name='aula'> <br>
	Inserisci il nome del docente del corso <input type='text' name='docente'> <br>
	
	<input type='submit' value='inserisci nuova edizione'></form>

<form action="login" method="post">
<input type='hidden' name='username' value=<%=a.getUsername() %>>
<input type='hidden'  name='password' value=<%=a.getPassword() %>>
<input type='submit' value='Vai alla Pagina Privata Amministratore'></form>

</body>
</html>