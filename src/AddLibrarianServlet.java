

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.app.dao.LibrarianDAO;

/**
 * Servlet implementation class AddLibrarianServlet
 */
@WebServlet("/AddLibrarianServlet")
public class AddLibrarianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLibrarianServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONArray  jArray = new JSONArray();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("em");
		String country = request.getParameter("country");
		
		try {
			LibrarianDAO libDAO = new LibrarianDAO();
			PrintWriter out = response.getWriter();
			jArray = libDAO.addLibrarians(firstName, lastName, email, country);
			System.out.print(jArray.toJSONString());
			out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
