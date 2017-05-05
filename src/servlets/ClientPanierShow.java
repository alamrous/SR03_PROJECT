package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PanierManager;
import beans.Client;
import beans.Panier;

/**
 * Servlet implementation class ClientPanierShow
 */
@WebServlet("/ClientPanierShow")
public class ClientPanierShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientPanierShow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client client = (Client) request.getSession().getAttribute("client");
		if(request.getSession().getAttribute("panier") == null){
		Panier[] paniers = PanierManager.getClientPanier(client.getId());
		if(paniers.length >=1){
		request.getSession().setAttribute("panier", paniers);
		double total =0 ;
		for (int i = 0; i < paniers.length; i++) {
			total = total + paniers[i].getJeu().getPrix();
		}
		request.getSession().setAttribute("total", total);
		}
		}
		
		request.getSession().removeAttribute("achats");
		
		Panier[] achats = PanierManager.getClientBoughtItem(client.getId());
		if(achats.length >=1)
		{
			request.getSession().setAttribute("achats", achats);

		}
		request.getRequestDispatcher("PanierView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
