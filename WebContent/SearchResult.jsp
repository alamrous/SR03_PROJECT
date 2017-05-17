<%@page import="beans.Jeu"%>

<h2>Liste des jeux</h2>
<table class="table">
<tr>
<th>Titre</th>
<th>Pegi</th>
<th>Note</th>
<th>Editeur</th>	
<th>Pays</th>
<th>Plateforme</th>
<th>Prix</th>
<% if(request.getSession().getAttribute("client") != null){ %>
<th> Action </th>
<%} %>
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
	<% if(request.getSession().getAttribute("client") != null){ %>
<td> <form action="PanierAction" method="post">
<input type="hidden" name="productId" value="<%= liste[i].getPlateforme_jeu_fk()%>">
<input type="submit" value="Ajouter" class="btn btn-success" id="AddPanier">
</form> </td>
<%} %>
</tr> 
						
			
			
<% } %>

</table>