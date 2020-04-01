<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
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
<%Utente u =(Utente) session.getAttribute("user"); %>

<%
	List<EdizioneDTO>  lista = (List<EdizioneDTO>) request.getAttribute("edizioni");
	%>



	Lista di tutte le Edizioni:
	<br>

	<ul>
		<%
			for (int i = 0; i < lista.size(); i++) {
				out.println("<li> <form action='ServletDettagliEdizione' method='post'>"
						+ " <input type='hidden' name='id' value=" + lista.get(i).getEdizione().getId() + "> "
                		+ " <input type='hidden' name='username' value=" + u.getUsername() + "> "	
						+ " <input type='submit' value=" + lista.get(i).getEdizione().getDataInizio()
						+ "></form> </li>");
			}
		%>
		<p>
		<form action="login" method="post">
<input type='hidden' name='username' value=<%=u.getUsername() %>>
<input type='hidden'  name='password' value=<%=u.getPassword() %>>
<input type='submit' value='Vai alla Pagina Privata Utente'></form>
		
	</ul>
		<p>
		<form action="login" method="post">
<input type='hidden' name='username' value=<%=u.getUsername() %>>
<input type='hidden'  name='password' value=<%=u.getPassword() %>>
<input type='submit' value='Vai alla Pagina Privata Utente'></form>

</body>
</html>
