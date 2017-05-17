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

import DAO.GameManager;
import beans.Jeu;

/**
 * Servlet implementation class SearchGameController
 */
@WebServlet("/SearchGame")
public class SearchGameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGameController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = (String.valueOf(request.getParameter("title")).length()== 0)?null:request.getParameter("title");
		Integer plateforme = (String.valueOf(request.getParameter("plateforme") ).length()== 0)?null:Integer.valueOf(request.getParameter("plateforme"));
		Integer editeur =(request.getParameter("editeur") == "")?null:Integer.valueOf(request.getParameter("editeur"));
		Double priceMin = (String.valueOf(request.getParameter("priceMin") ).length()== 0)?null:Double.valueOf(request.getParameter("priceMin"));
		Double priceMax = (String.valueOf(request.getParameter("priceMax") ).length()== 0)?null:Double.valueOf(request.getParameter("priceMax"));
		  SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date =null;
			try {
				if(String.valueOf(request.getParameter("year")).length()!= 0)
				date = formatter.parse(request.getParameter("year"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		ArrayList<Jeu> liste= new ArrayList<Jeu>();
		liste = GameManager.getGameUsingFields(title,plateforme,editeur,priceMin,priceMax,date);
//		liste = GameManager.getAllGame();
		Jeu[] jeu_liste = liste.toArray(new Jeu[liste.size()]);
		request.setAttribute("liste", jeu_liste);
		request.getRequestDispatcher("SearchResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
