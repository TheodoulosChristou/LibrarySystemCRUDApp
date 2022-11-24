import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.app.dao.LibrarianDAO;

@WebServlet("/GetDetailsLibrarianServlet")
public class GetDetailsLibrarianServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		JSONArray jArray = new JSONArray();
		LibrarianDAO libDAO = new LibrarianDAO();
		try {
			PrintWriter out = response.getWriter();
			jArray = libDAO.getLibrarianDetails(id);
			out.print(jArray.toJSONString());
			out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
