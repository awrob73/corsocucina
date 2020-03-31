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
	List<EdizioneDTO>  lista = (List<EdizioneDTO>) request.getAttribute("edizioni");
	%>

   <%String m =(String) request.getAttribute("messaggio"); %>
	<%=m %> <p>
	 

	Lista di tutte le Edizioni:
	<br>

		<%
			for (int i = 0; i < lista.size(); i++) {
				out.println("<li>" + lista.get(i).getEdizione().getDataInizio() + "<form action='ServletCancellaEdizione' method='post'>" + 
							"<input type='hidden' name='idEdizione' value=" + lista.get(i).getEdizione().getId() + "> " + 
							"<input type='submit' value='cancella'></form> </li>");
			}
		%>



</body>
</html>