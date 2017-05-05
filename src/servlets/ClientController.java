package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		//doGet(request, response);
		Client client = new Client(); 
		client.setName(request.getParameter("name"));
		client.setFirstname(request.getParameter("firstname"));
		client.setPseudo(request.getParameter("pseudo"));
		client.setPwd(request.getParameter("pwd"));
		client.setAddress(request.getParameter("adress"));
		client.setEmail(request.getParameter("email"));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date;
		try {
			date = formatter.parse(request.getParameter("birthdate"));
			client.setBirthdate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.setEmail(request.getParameter("email"));
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
