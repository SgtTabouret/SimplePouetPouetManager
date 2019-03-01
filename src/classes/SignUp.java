package classes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/signup")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String login = req.getParameter("login");
		String pwd = req.getParameter("password");
		PrintWriter out = res.getWriter();
		
		if(login == null || login.equals("") || login.equals(" ")) {
		out.println("<script>alert('le login ne peut pas être vide');</script>");
		} 
		if(pwd == null || pwd.equals("") || pwd.equals(" ")) {
		out.println("<script>alert('le mot de passe ne peut pas être vide');</script>");
		}
		
		User u = new User(lgin, pwd);
		DS ds = new DS();
		UserDAO udao = new UserDAO(ds);
		
		Encrypt e = new Encrypt();
		udao.create(u);
		
		
	}

}
