
<%@page import="it.ats.progettofinecorsoscuolacucina.modello.Utente"%>
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
  background-image: url("img/corsi-di-cucina.jpg");
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
  color: buttonface;
}

input[type=submit] {
  width: 90%;
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



<%Utente a = (Utente) session.getAttribute("user"); %>
<form action="ServletInserisciCorso" method="post">
<strong> <input type='text' name='codice'> Digita il codice del nuovo corso </strong>  <br>
<strong> <input type='text' name='titolo'> Digita il titolo del nuovo corso</strong> <br>
<strong> <input type='text' name='idCategoria'> Digita l'id della categoria</strong> <br>
<strong> <input type='text' name='maxPartecipanti'> Digita numero max di partecipanti</strong> <br>
<strong> <input type='text' name='costo'> Digita il costo del corso</strong> <br>
<strong> <input type='text' name='descrizione'> Digita descrizione del nuovo corso</strong> <br>
<input type="hidden" name="username" value=<% a.getUsername();%>>
<input type="submit" value="Crea un nuovo corso">
</form>
</body>
</html>