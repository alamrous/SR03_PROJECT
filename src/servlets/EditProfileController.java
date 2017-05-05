package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ClientManager;
import beans.Client;

/**
 * Servlet implementation class EditProfileController
 */
@WebServlet("/EditProfile")
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubs
		//doGet(request, response);
		Client client = (Client)request.getSession().getAttribute("client");
		client = ClientManager.selectClientUsingId(client.getId());
		if(client.getFirstname() != request.getParameter("firstname")) 
			client.setFirstname(request.getParameter("firstname"));
		if(client.getName() != request.getParameter("name"))
			client.setName(request.getParameter("name"));
		if(client.getAddress() != request.getParameter("adress")) 
			client.setAddress(request.getParameter("adress"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = formatter.parse(request.getParameter("birthdate"));
			if(client.getBirthdate() != date)
				client.setBirthdate(date);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(client.getEmail() != request.getParameter("email")) 
			client.setEmail(request.getParameter("email"));
		if(client.getPseudo()!= request.getParameter("pseudo")) 
			client.setPseudo(request.getParameter("pseudo"));
		if(client.getGender() != request.getParameter("gender").charAt(0)) 
			client.setGender(request.getParameter("gender"));



		ClientManager.updateClientProfile(client);
		client = ClientManager.selectClientUsingId(client.getId());
		request.getSession().removeAttribute("client");
		request.getSession().setAttribute("client", client);
		request.getRequestDispatcher("ClientCompte").forward(request, response);
	}

}
