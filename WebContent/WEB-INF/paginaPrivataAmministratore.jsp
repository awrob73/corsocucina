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
.paginaPrivataAmministratoreDiv {
  position:relative;
  width:1400px;
  height:800px;
  border-radius: 20px;
  background-image: url("img/cannavacciuolo3_2.jpg");
  background-size: 100%;
  padding: 20px;
  margin-left:10px;
  margin-right: 10px;
  border: 5px double #800000;
}

.paginaPrivataAmministratoreDivBenvenuto {
  position:relative;
  left:840px;
  top: 20px;
  width:520px;
  height:260px;
  line-height: 60px;
  text-align: center;
  font-size: 35px;
  color:white;
}

#paginaPrivataAmministratoreh1 {
	font-size: 50px;
	color:white;
	margin-bottom: 0px;
	
}

#paginaPrivataAmministratoreh2 {
	font-size: 50px;
	color:white;
	margin-top: 0px;

}

input[type=text] {
  width: 320px;
  background-color: #800000;
  color: white;

  padding-top:14px;
  padding-bottom: 10px;
  margin-bottom: 30px;
  margin-top: 14px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 15px;
  text-align: center;
}

::-webkit-input-placeholder {
    color: white;
}
input[type=submit] {
  width: 320px;
  background-color: #800000;
  color: white;
  padding: 14px 20px 10px 10px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 15px;
}

input[type=submit]:hover {
  width: 320px;
  background-color: red;
  color: white;
  padding: 14px 20px 10px 10px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 15px;
}


</style>
<body>
<%Utente a = (Utente)request.getAttribute("user"); %>
 
<div class="paginaPrivataAmministratoreDiv">

<div class="paginaPrivataAmministratoreDivBenvenuto">
<h1 id="paginaPrivataUtenteh1">Benvenuto</h1>
<h2 id="paginaPrivataUtenteh2"> <%= a.getNome() %> <%= a.getCognome() %> </h2><br>
</div>

<form action="ServletVisualizzaDatiAmministratore" method="post">
<input type="hidden" name="username" value='<%=a.getUsername()%>'>
<input type="submit" value='Visualizza dati'>
</form>
<p>
<form action="ServletFormInserisciCorso" method="post">
<input type="hidden" name="username" value=<% a.getUsername();%>>
<input type="submit" value="Inserisci nuovo corso">
</form>
<p>
<form action="ServletInserisciCategoria" method="post">
<input type='text' name='descrizione' placeholder="Digita la nuova categoria">
<input type="hidden" name="username" value=<% a.getUsername();%>>
<input type="submit" value="Crea una nuova categoria">
</form>

<form action="ServletListaCategoria" method="post">
<input type="hidden" name="username" value=<% a.getUsername();%>>
<input type="submit" value="Vedi le categorie presenti">
</form>

<p>
<form action="ServletListaCorso" method="post">
<input type="hidden" name="username" value=<%=a.getUsername()%>>
<%-- <input type="hidden" name="password" value=<%=a.getPassword()%>> --%>
<input type="submit" value="Visualizza la lista dei corsi">
</form>
<p>

<form action="logout" method="get">
<input type='submit' value='Logout'>
</form>


</div>
</body>
</html>