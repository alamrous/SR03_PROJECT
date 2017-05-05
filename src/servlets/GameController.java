package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.plugins.server.servlet.Cleanable;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import DAO.ClientManager;
import DAO.EditeurManager;
import DAO.GameManager;
import DAO.PlateformeManager;
import beans.Client;
import beans.Editeur;
import beans.Jeu;
import beans.Plateforme;

/**
 * Servlet implementation class GameController
 */
@WebServlet("/GameController")
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client client= new Client();
		client = ClientManager.selectClientUsingId(3);
		request.getSession().setAttribute("client", client);
		String  option="";
		String editeurOption= "";
		ArrayList<Plateforme> plateformes = PlateformeManager.getPlateforme();
		plateformes.forEach(Cle-> System.out.println(Cle.getName()));
		for (Iterator iterator = plateformes.iterator(); iterator.hasNext();) {
			Plateforme plateforme = (Plateforme) iterator.next();
			//System.out.println(plateforme.getName());
			option=option+"<option value=\""+plateforme.getId()+"\">"+plateforme.getName()+"</option> ";
		}
		ArrayList<Editeur> editeurs = EditeurManager.getEditeurs();
		editeurs.forEach(Cle-> System.out.println(Cle.getDescription()));
		for (Iterator iterator = editeurs.iterator(); iterator.hasNext();) {
			Editeur editeur= (Editeur) iterator.next();
			//System.out.println(plateforme.getName());
			editeurOption=editeurOption+"<option value=\""+editeur.getId()+"\">"+editeur.getDescription()+"</option> ";
		}
		request.setAttribute("plateformes", option);
		request.setAttribute("editeurs", editeurOption);

		if(request.getSession().getAttribute("client") != null && request.getSession().getAttribute("isConnected")!=null)
		{
			request.getSession().removeAttribute("client");
			request.getSession().removeAttribute("isConnected");

		}
		else
		{
			if(request.getSession().getAttribute("client") != null)
			{
				request.getSession().setAttribute("isConnected", true);
			}
		}
		ArrayList<Jeu> liste= new ArrayList<Jeu>();
		liste = GameManager.getAllGame();
       try {
    		Jeu[] jeu_liste = liste.toArray(new Jeu[liste.size()]);
    		request.setAttribute("liste", jeu_liste);
    	   request.getRequestDispatcher("GamesList.jsp").forward(request, response);

	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("DISPATCHER "+e.toString());
	}

//		request.getRequestDispatcher("/WebContent/GamesList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
