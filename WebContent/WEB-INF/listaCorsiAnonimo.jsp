<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
<%@page import="java.util.List"%>
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Corso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
.listaCorsi {
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
.listaCorsiDiv {
  overflow: auto;
  width:1400px;
  height:740px;
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
</style>

<body class="listaCorsi">
	<% List<Corso> lista = (List<Corso>) request.getAttribute("corso");
	%>



	Ecco i nostri corsi
	<br>
<div class="listaCorsiDiv">
	<ul>
		<%
			for (int i = 0; i < lista.size(); i++) {			
                                        out.println(lista.get(i).getTitolo()+ "<p>");			
			}
		%>
</div>
		
Che aspetti, <a href="registrazione-utente.html">registrati!</a> <br>
</body>
</html>