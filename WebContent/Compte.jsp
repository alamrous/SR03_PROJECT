<%@page import="beans.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mon Compte</title>
</head>
<body>
<% Client client = (Client) request.getSession().getAttribute("client"); %>
<a href="ChangePwd" method="POST">Modifier le mot de passe</a>
<a href="EditProfile.jsp">Editer Mon Profil</a>
<a href="ClientPanierShow">Mes achats</a>
<a href="ClientPanierShow">Mon Panier</a>
<h1> Mes informations</h1>
<table>
<tr>
<th>Nom</th>
<td><%= client.getName() %></td>
</tr>
<tr>
<th>Prénom</th>
<td><%= client.getFirstname() %></td>
</tr>
<tr>
<th>Email</th>
<td><%= client.getEmail() %></td>
</tr>
<tr>
<th>Pseudo</th>
<td><%= client.getPseudo() %></td>
</tr>
<tr>
<th>Sexe</th>
<td><%= client.getGender() %></td>
</tr>
<tr>
<th>Date de naissance</th>
<td><%= client.getBirthdate()%></td>
</tr>
<tr>
<th>Adresse</th>
<td><%= client.getAddress() %></td>
</tr>
</table>
</body>
</html>