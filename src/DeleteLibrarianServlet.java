import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.app.dao.LibrarianDAO;

@WebServlet("/DeleteLibrarianServlet")
public class DeleteLibrarianServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		JSONArray jArray = new JSONArray();
		LibrarianDAO libDAO = new LibrarianDAO();
		String id = request.getParameter("id");
		
		try {
			PrintWriter out = response.getWriter();
			jArray =libDAO.getDeleteLibrarian(id);
			out.println(jArray.toJSONString());
			out.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
