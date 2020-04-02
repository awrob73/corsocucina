
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


<style>

body {
  margin: auto;
  font-family: Arial, Helvetica, sans-serif;
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

.hero-text {
  margin: auto;
  text-align: auto;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: black;
}

input[type=submit] {
  width: 80%;
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

a{
background-color: #800000;
color: black;
}

</style>
</head>
<body>

<div class="hero-image">
  <div class="hero-text">
  <div class="indexDiv"></div>
  
<%Utente u =(Utente) session.getAttribute("user"); %>

<%
	List<EdizioneDTO>  lista = (List<EdizioneDTO>) request.getAttribute("edizioni");
	%>



	<h1>Lista di tutte le Edizioni:</h1>
	<br>

	<ul>
		<%
			for (int i = 0; i < lista.size(); i++) {
				out.println("<li> <form action='ServletDettagliEdizione' method='post'>" + " <input type='hidden' name='id' value="
						+ lista.get(i).getEdizione().getId() + "> " + " <input type='submit' value=" + lista.get(i).getEdizione().getDataInizio()
						+  "><input type='hidden' name='username' value="+u.getUsername()+"></form> </li>");
			}
		%>
		
	</ul>
		<p>
		<form action="login" method="post">
<input type='hidden' name='username' value=<%=u.getUsername() %>>
<input type='hidden'  name='password' value=<%=u.getPassword() %>>
<input type='submit' value='Vai alla Pagina Privata Utente'></form>

</body>
</html>

