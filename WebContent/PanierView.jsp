<%@page import="beans.Client"%>
<%@page import="java.text.DateFormat"%>
<%@page import="beans.Panier"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script type="text/javascript" src="js/test.js"></script> -->
<title>Mon panier</title>
</head>
<body>
<h1>Mon panier</h1>
<a href="GameController">Retour à l'accueil</a>
<%Panier[] panier = null; 	
Client client= (Client) request.getSession().getAttribute("client");
request.getSession().removeAttribute("isConnected");
Panier[] achats= null;
if ((panier =(Panier[]) request.getSession().getAttribute("panier")) != null){ %>
<table>
<tr>
<th>Id</th>
<th> Jeu </th>
<th> Plateforme </th>s</th>
</tr>
<th> Date d'ajout </th>
<th> Prix </th>
<th>Actions</th>
</tr>
<% for(int i=0; i<panier.length; i++){ %>
<tr>
<td> <%= panier[i].getId() %> </td>
<td> <%= panier[i].getJeu().getTitle() %> </td>
<td> <%= panier[i].getJeu().getPlateforme().getName() %> </td>
<td> <%= panier[i].getDate_creation() %> </td>
<td> <%= panier[i].getJeu().getPrix() %> </td>
<td> <form action="PanierAction" method="GET"><input type="hidden" name="id_panier" value="<%= panier[i].getId() %>"> <input type="submit" value="Supprimer"></form></td>
</tr>

<%} %>

</tr>
</table>
<h2> Total </h2> <%= request.getSession().getAttribute("total") %>
<form action="AchatController" method="POST"><input type="submit" value="Acheter"></form>
<%} %>

<h2> Achats effectués</h2>
<% if((achats =(Panier[]) request.getSession().getAttribute("achats")) !=null){ %>
<table>
<tr>
<th> Jeu </th>
<th> Plateforme </th>
<th> Date d'achat </th>
<th> Prix </th>
</tr>
<% for(int i=0; i<achats.length; i++){ %>
<tr>
<td> <%= achats[i].getJeu().getTitle() %> </td>
<td> <%= achats[i].getJeu().getPlateforme().getName() %> </td>
<td> <%= achats[i].getDate_achat() %> </td>
<td> <%= achats[i].getJeu().getPrix() %> </td>
</tr>

<%} %>
</tr>
</table>
<% } %>
</body>
</html>