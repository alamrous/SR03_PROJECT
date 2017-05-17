package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClientManager;
import beans.Client;

/**
 * Servlet implementation class ClientController
 */
@WebServlet("/ClientController")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */	
    public ClientController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client client = new Client(); 	
		client.setEmail(request.getParameter("email"));
		client.setPwd(request.getParameter("pwd"));
		client = ClientManager.selectClientUsingEmailUsingPwd(client.getEmail(), client.getPwd());
		request.setAttribute("client", client);
		request.getSession().setAttribute("client", client);
		request.getRequestDispatcher("ConfirmationCreationCompte.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String regexEmail = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}\\b";
		String regexName = "[A-Za-z]{2,}";
		String regexPseudo = "[A-Za-z0-9 -_]{3,}";
		String regexPassword = ".{3,}";
		
		Client client = new Client();
		request.setAttribute("messageErreur", "");
		if(request.getParameter("name").matches(regexName)){
			client.setName(request.getParameter("name"));
		}
		else{
			request.setAttribute("messageErreur", "Le nom n'a pas une forme valide.");
		}
		if(request.getParameter("firstname").matches(regexName)){
			client.setFirstname(request.getParameter("firstname"));
		}
		else{
			request.setAttribute("messageErreur", "Le prénom n'a pas une forme valide.");
		}
		if(request.getParameter("pseudo").matches(regexPseudo)){
			client.setPseudo(request.getParameter("pseudo"));
		}
		else{
			request.setAttribute("messageErreur", "Le pseudo n'a pas une forme valide.");
		}
		if(request.getParameter("pwd").matches(regexPassword)){
			client.setPwd(request.getParameter("pwd"));
		}
		else{
			request.setAttribute("messageErreur", "Le password n'a pas une forme valide.");
		}
		client.setAddress(request.getParameter("adress"));
		if(request.getParameter("email").matches(regexPassword)){
			client.setEmail(request.getParameter("email"));
		}
		else{
			request.setAttribute("messageErreur", "L'adresse e-mail n'a pas une forme valide.");
		}
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date;
		try {
			date = formatter.parse(request.getParameter("birthdate"));
			client.setBirthdate(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		client.setGender(request.getParameter("gender"));
		try {
			ClientManager.insertIntoClient(client);
			request.setAttribute("client", client);
			ApplicationController.setClient(client);
			request.getRequestDispatcher("ConfirmationCreationCompte.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		


	}

}
