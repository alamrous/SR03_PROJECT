/**
 * 
 */

$(document).ready(function(){

	$('#AddPanier').on("click",function(){
		$('#TableView').prepend('<div class="alert alert-success"> Un nouveau jeu ajouté au Panier !</div>');
	});
	$('#searchGame').on("click",function(){
		var titre = null;
		if($('input[name="title"]').val()!="")
			{
			titre = $('input[name="title"]').val()
			}
		var plateforme = $('select[name="plateforme"] option:selected').val();
		
		var year =null;
		if ($('input[name="year"]').val() != "")
			{
			year=$('input[name="year"]').val();
			}
		var editeur = $('select[name="editeur"] option:selected').val();
		
		var priceMin =null;
		if($('input[name="minPrice"]').val() != "")
			{
			priceMin=$('input[name="minPrice"]').val();
			}
		var maxPrice = null;
		if($('input[name="maxPrice"]').val() != "")
			{
			maxPrice=$('input[name="maxPrice"]').val();
			}
console.log(maxPrice == null);
		$.get('SearchGame',{title:titre,plateforme:plateforme,year:year,editeur:editeur,priceMin:priceMin,priceMax:maxPrice},function(data){
			$('#TableView').hide(500).empty().append(data).show(100);
		});});
	});
