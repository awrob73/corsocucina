<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String m =(String) request.getAttribute("messaggio"); %>
<%=m %>
	<form action="login" method="post">
		<table>
			<tr height="50" align="left">
				<th colspan="3" valign="middle">LOGIN UTENTE</th>
			</tr>
			<tr height="50">
				<td width="20%">Username</td>
				<td width="40%"><input type="text" name="username"></td>
				<td width="40%">
			</tr>
			<tr height="50">
				<td width="20%">Password</td>
				<td width="40%"><input type="password" name="password"></td>
				<td width="40%">
			</tr>
			<tr height="50">
				<th colspan="3" valign="middle"><input type="submit"
					value="Accedi"><br></th>
			</tr>
		</table>
		<br>
	</form>
	<form action="%%%%%%%">
	Visualizza i nostri corsi:
	<input type="submit" value="VAI">
	</form>

	<br>
	<br>
Se non hai ancora un account registrati <a href="registrazione-utente.html">qui</a> <br>
</body>
</html>