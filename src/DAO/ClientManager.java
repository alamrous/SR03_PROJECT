package DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import beans.Client;
public class ClientManager{

	public static int insertIntoClient(Client client) throws SQLException {
		int res = 0;
		
		ConnexionBDD mysqlConnect = new ConnexionBDD();
		String sql = "INSERT INTO `test`.`Client`(`name`,`firstname`,`pseudo`,`pwd`,`gender`,"
				+ "`email`,`date_creation`,`birthdate`,`address`,`compte_fk_etat_compte`)"
				+ "VALUES (?,?,?,?,?,?,CURDATE(),?,?,1);";
		try {
	  Connection connection =  mysqlConnect.connect();
	if (connection == null)
	{
	System.out.println("Connection nulle");	
	return 0;
	}
						//Execution et traitement de la réponse
		PreparedStatement statement=	connection.prepareStatement(sql);
		statement.setString(1, client.getName());
		statement.setString(2, client.getFirstname());
		statement.setString(3, client.getPseudo());
		statement.setString(4, client.getPwd());
		statement.setString(5, String.valueOf(client.getGender()));
		statement.setString(6, client.getEmail());
	    java.sql.Date sqlDate = new java.sql.Date(client.getBirthdate().getTime());

		statement.setDate(7, sqlDate);
		statement.setString(8, client.getAddress());


		statement.execute();
		}
		finally {
		    mysqlConnect.disconnect();
		}

		return res;
	}
	
	

}
