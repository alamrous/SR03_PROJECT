<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Création de Compte</title>
</head>
<body>
<h1>Création de compte</h1>
<form action="ClientController" method="post">
<label>Name</label>
<input type="text" name="name"/>
<br/>
<label>FirstName</label>
<input type="text" name="firstname"/>
<br/>
<label>Pseudo</label>
<input type="text" name="pseudo"/>
<br/>
<label>Password</label>
<input type="text" name="pwd"/>
<br/>
<label>Adresse</label>
<input type="text" name="adress"/>
<br/>
<label>Email</label>
<input type="text" name="email"/>
<br/>
<label>Date de naissance</label>
<input type="text" name="birthdate"/>
<br/>
<label>Sexe</label>
<input type="radio" name="gender" value="M"/>
<input type="radio" name="gender" value="F"/>
<br/>
<input type="submit" value="ok"/>
</form>
</body>
</html>