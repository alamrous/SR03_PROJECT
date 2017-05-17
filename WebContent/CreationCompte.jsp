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
<title>Création de Compte</title>
</head>
<body style="padding: 70px">
<%@ include file="header.jsp"%>
<h1>Création de compte</h1>
<div class="row">
<div class="col-md-5 col-md-offset-3">
<form action="ClientController" method="post">
<label>Name</label>
<input type="text" name="name" class="form-control"/>
<br/>
<label>FirstName</label>
<input type="text" name="firstname" class="form-control"/>
<br/>
<label>Pseudo</label>
<input type="text" name="pseudo" class="form-control"/>
<br/>
<label>Password</label>
<input type="text" name="pwd" class="form-control"/>
<br/>
<label>Adresse</label>
<input type="text" name="adress" class="form-control"/>
<br/>
<label>Email</label>
<input type="text" name="email" class="form-control"/>
<br/>
<label>Date de naissance</label>
<input type="text" name="birthdate" class="form-control"/>
<br/>
<label>Sexe</label>
<div class="form-check">
  <label class="form-check-label">
    <input class="form-check-input" type="radio" name="gender" value="M">
M
  </label>
</div>
<div class="form-check">
  <label class="form-check-label">
    <input class="form-check-input" type="radio" name="gender" value="F">
F  </label>
</div>

<br/>
<input type="submit" value="M'enregistrer" class="btn btn-lg btn-primary btn-block"/>
</form>

</div>
</div>
</body>
</html>