package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import beans.Jeu;
import beans.Pegi;
import beans.Plateforme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/REST")
public class REST {

	@GET()
	@Path("getJeu/{id}")
	public String getJeu(@PathParam("id") int id) {
		String sql = "SELECT * FROM jeu WHERE id = ?";
		ConnexionBDD mysqlConnect = new ConnexionBDD();
		Connection connection = mysqlConnect.connect();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet res = statement.executeQuery();
			Jeu jeu;
			if (res.next()) {
				jeu = new Jeu();
				jeu.setId(res.getInt("Jeu.id"));
				jeu.setPrix(res.getDouble("prix"));
				jeu.setTitle(res.getString("title"));
				jeu.setPlateforme_jeu_fk(res.getInt("Jeu_Plateforme.id"));
				Plateforme plateforme = new Plateforme();
				plateforme.setName("Plateforme.nom");
				jeu.setPlateforme(plateforme);

			}
		} catch (Exception ex) {

		}
		return "Hello";
	}

	@POST()
	@Path("/REST/postJeu/{jeu}")
	public void postJeu(@PathParam("jeu") Jeu jeu) {
		String sql = "INSERT INTO jeu VALUES('" + jeu.getTitle() + "'," + jeu.getFk_pegi() + "," + jeu.getNote() + ",'"
				+ jeu.getSummary() + "'," + jeu.getFk_editeur().getId() + ");";
		ConnexionBDD mysqlConnect = new ConnexionBDD();
		Connection connection = mysqlConnect.connect();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@DELETE()
	@Path("/REST/deleteJeu/{id}")
	public void deleteJeu(@PathParam("id") int id){
		String sql = "DELETE FROM jeu WHERE id = ?;";
		ConnexionBDD mysqlConnect = new ConnexionBDD();
		Connection connection = mysqlConnect.connect();
	
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement = connection.prepareStatement(sql);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
