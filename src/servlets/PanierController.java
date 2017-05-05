package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GameManager;
import DAO.PanierManager;
import beans.Client;
import beans.Jeu;

/**
 * Servlet implementation class PanierController
 */
@WebServlet("/PanierAction")
public class PanierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanierController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Integer panier_id = Integer.valueOf(request.getParameter("id_panier"));
		try {
			 PanierManager.removePanierItemUsingId(panier_id);
			
				request.getSession().removeAttribute("panier");
		    	 request.getRequestDispatcher("ClientPanierShow").forward(request, response);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Client client = (Client) request.getSession().getAttribute("client");
		Jeu jeu = new Jeu();
		//jeu.setId(Integer.valueOf(request.getParameter("productId")));
		jeu = GameManager.getGameUsingId(Integer.valueOf(request.getParameter("productId")));
		if(jeu != null)
		{
			try {
				PanierManager.insertIntoPanier(jeu,client.getId());
				request.getSession().removeAttribute("isConnected");
				request.getSession().removeAttribute("panier");
		    	   request.getRequestDispatcher("GameController").forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
