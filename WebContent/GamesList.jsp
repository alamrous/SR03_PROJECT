<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="beans.*"  %>
        <%@ page import="java.util.ArrayList"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<% if(request.getParameter("client") == null){ %>
<a href="CreationCompte.jsp">Création de comptes</a>
<a href="ConnexionCompte.jsp">Connexion</a>
<%} else  {%>
<a href="ClientCompte.jsp">Mon compte</a>
<a href="ClientPanier.jsp">Mon panier</a>
<%} %>
<h2>Liste des jeux</h2>
<table style="border: black;">
<tr>
<th>Titre</th>
<th>Pegi</th>
<th>Note</th>
<th>Editeur</th>
<th>Pays</th>
<th>Plateforme</th>
<th>Prix</th>


</tr> 
<% 
try{
Jeu[] liste = (Jeu[])request.getAttribute("liste"); 
}

catch(Exception e){
 System.out.print(e.toString());	
}
Jeu[] liste = (Jeu[])request.getAttribute("liste"); 
%>
<% int  i = 0; 
for (i=0; i<liste.length; i++){
	%><tr>
	<td>
	<%=
	liste[i].getTitle()
	%>
	</td>
	<td><%=  liste[i].getFk_pegi().getDescription()%></td>
	<td><%=  liste[i].getNote()%></td>
	<td><%=  liste[i].getFk_editeur().getDescription()%></td>
	<td><%=  liste[i].getFk_editeur().getCountry_fk().getNom()%></td>
	<td><%=  liste[i].getPlateforme().getName()%></td>
	<td><%=  liste[i].getPrix()%></td>
						
			
			
	</tr>
<% } %>

</table>
</body>
</html>