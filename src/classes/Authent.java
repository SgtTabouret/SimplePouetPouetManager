package classes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authent
 */
@WebServlet("/Authent")
public class Authent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Authent() {
        super();

    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		  Connection con = null;
			try{
		      Class.forName("org.h2.Driver");
		      String url = "jdbc:h2:~/pwdManager";
		      String nom = "sa";
		      String mdp = "";
		      con = DriverManager.getConnection(url,nom,mdp);

		      String login = req.getParameter("login");
		      String mdp1 = req.getParameter("mdp");

		      String query = "Select login from personne where login='"+login+"'";
		      PreparedStatement ps = con.prepareStatement( query);
		      out.println("" + ps);



		    }catch (Exception e){
		      out.println("Erreur =" + e.getMessage());
		    }finally{
					// fermeture des espaces
					try {con.close();} catch(Exception e2) {}
				}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
