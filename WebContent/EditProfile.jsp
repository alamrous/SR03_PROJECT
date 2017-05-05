<%@page import="beans.Client"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edition Compte</title>
</head>
<body>
<% Client client = (Client)request.getSession().getAttribute("client"); %>
<h1>Edition de votre compte</h1>
<form action="EditProfile" method="post">
<label>Name</label>
<input type="text" name="name" value="<%=client.getName()%>"/>
<br/>
<label>FirstName</label>
<input type="text" name="firstname"value="<%=client.getFirstname()%>" />
<br/>
<label>Pseudo</label>
<input type="text" name="pseudo" value="<%=client.getPseudo()%>"/>
<br/>
<label>Adresse</label>
<input type="text" name="adress" value="<%=client.getAddress()%>"/>
<br/>
<label>Email</label>
<input type="text" name="email" value="<%=client.getEmail()%>"/>
<br/>
<label>Date de naissance</label>
<input type="text" name="birthdate" value="<%=client.getBirthdate()%>"/>
<br/>
<label>Sexe</label>
<label>M</label>
<input type="radio" name="gender" value="M"<% if (client.getGender() == 'M') { %> checked="checked"<%} %>/>
<label>F</label>
<input type="radio" name="gender" value="F"<% if (client.getGender() == 'F') { %> checked="checked"<%} %>/>
<br/>
<input type="submit" value="Editer"/>
</form>
</body>
</html>