<%@page import="beans.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
    <%@include file="bootstrap/css/bootstrap.css" %>
    <%@include file="bootstrap/css/bootstrap-theme.css" %>    
</style>
<title>Confirmation</title>
</head>
<body style="padding: 70px">
<%@ include file="header.jsp"%>
<h2>Validation de la création de compte</h2>
<%Client client = (Client)request.getAttribute("client");%>
<p>Bienvenue<%= client.getName() %>, retour à l'<a href="GameController">Accueil</a> </p>

</body>
</html>