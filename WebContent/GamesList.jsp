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
<a href="CreationCompte.jsp">Création de compte</a>
<h2>Liste des jeux</h1>
<table style="border: black;">
<tr>
<th>Titre</th>
<th>Pegi</th>
<th>Note</th>
<th>Editeur</th>
<th>Pays</th>

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
	</tr>
<% } %>
<%-- <%for(int i = 0; i<liste.length; i ++){	%> --%>
<!-- <tr> -->
<%-- <td> <%= liste[i].getTitle()%></td> --%>
<%-- <td> <%=  liste[i].getFk_pegi().getDescription()%></td> --%>
<%-- <td> <%=  liste[i].getNote()%></td> --%>
<%-- <td> <%=  liste[i].getFk_editeur().getDescription()%></td> --%>
<%-- <td> <%=  liste[i].getFk_editeur().getCountry_fk().getNom()%></td> --%>

<!-- </tr>	 -->
<%-- 	<% --%>
<%-- %> --%>
</table>
</body>
</html>