import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.app.dao.LibrarianDAO;

@WebServlet("/EditLibrarianServlet")
public class EditLibrarianServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		
		JSONArray jArray = new JSONArray();
		LibrarianDAO libDAO = new LibrarianDAO();
		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String email = request.getParameter("em");
		String country = request.getParameter("country");
		String id = request.getParameter("i");
		
		try {
			PrintWriter out = response.getWriter();
			jArray = libDAO.getEditLibrarian(firstname, lastname, email, country, id);
			out.print(jArray.toJSONString());
			out.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
