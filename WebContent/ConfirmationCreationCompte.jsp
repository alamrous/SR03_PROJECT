<%@page import="beans.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmation</title>
</head>
<body>
	<h2>Validation de la création de compte</h2>
	<%
		Client client = (Client) request.getAttribute("client");
		if (request.getAttribute("messageErreur") != "" && request.getAttribute("messageErreur") != null)
			out.println(
					"<p>Bienvenue" + client.getName() + ", retour à l'<a href=\"GameController\">Accueil</a> </p>");
		else
			out.println(
					"<p>"+request.getAttribute("messageErreur")+", retour à l'<a href=\"GameController\">Accueil</a> </p>");
	%>
</body>
</html>