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
	List<EdizioneDTO>  lista = (List<EdizioneDTO>) request.getAttribute("edizione");
	%>



	Lista di tutte le Edizioni:
	<br>

	<ul>
		<%
			for (int i = 0; i < lista.size(); i++) {
				out.println("<li> <form action='ServletDettagliEdizione' method='post'>" + " <input type='hidden' name='id' value="
						+ lista.get(i).getEdizione().getId() + "> " + " <input type='submit' value=" + lista.get(i).getEdizione().getDataInizio()
						+ "></form> </li>");
			}
		%>
		
	</ul>
		<p>

</body>
</html>
