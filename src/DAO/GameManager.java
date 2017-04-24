package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.xml.internal.ws.message.PayloadElementSniffer;

import beans.Country;
import beans.Editeur;
import beans.Jeu;import beans.Pegi;
import sun.security.krb5.internal.PAEncTSEnc;

public class GameManager {
public static ArrayList<Jeu> getAllGame(){
	ArrayList<Jeu> liste = new ArrayList<Jeu>();
	ConnexionBDD mysqlConnect = new ConnexionBDD();
	String sql = "SELECT test.Jeu.*, test.Pegi.description AS Pegi_description,"
			+ " test.Editeur.nom AS Editeur_name, test.Pays.nom AS Country_name"
			+ "	FROM test.Jeu "
			+ " INNER JOIN test.Pegi ON Pegi.id=Jeu.pegi_fk"
			+ " INNER  JOIN test.Editeur ON Editeur.id=Jeu.editeur_fk"
			+ " iNNER  JOIN test.Pays ON Pays.id=Editeur.country_fk ;" ;
	
	try {
	Connection connection =  mysqlConnect.connect();
	PreparedStatement statement=	connection.prepareStatement(sql);

	ResultSet res = statement.executeQuery();
	Jeu jeu;
	Editeur editeur; 
	Country pays;
	Pegi pegi;
	while(res.next()){
		jeu = new Jeu();
		editeur = new Editeur();
		editeur.setDescription(res.getString("Editeur_name"));
		pays = new Country();
		pays.setNom(res.getString("Country_name"));
		editeur.setCountry_fk(pays);
		pegi = new Pegi();
		pegi.setDescription(res.getString("Pegi_description"));
		jeu.setFk_editeur(editeur);
		jeu.setFk_pegi(pegi);
		jeu.setNote(res.getDouble("note"));
		jeu.setSummary(res.getString("summary"));
		jeu.setTitle(res.getString("title"));
		
		liste.add(jeu);
		
//	(Integer id, String title, Integer fk_pegi, Double note, String summary, Integer fk_editeur)
	}
	
	res.close();	
	mysqlConnect.disconnect();
	}			
	catch (Exception e) {
		// TODO: handle exception
	}
	return liste;
}
}
