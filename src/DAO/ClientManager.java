package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Client;
public class ClientManager{

	public static List<Client> findAll() {
		/*
		 * List<beans.Utilisateur> lu = new ArrayList<Utilisateur>(); lu.add(new
		 * Utilisateur(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Utilisateur(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Utilisateur(3,"nom3","tel3","username3","pwd3"));
		 */

		List<Client> lu = new ArrayList<Client>();
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			
			//Requete
			//String sql = "SELECT id,firstname FROM Client";
			String sql = "INSERT INTO Editeur VALUES (null,'nom',null)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();

//			while(res.next()){
//				Client client = new Client();
//				client.setFirstname(res.getString("firstname"));
//				client.setId(res.getInt("id"));
//				lu.add(client);
//			}
//			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("Erreur");
		}


		return lu;
	}
	
	

}
