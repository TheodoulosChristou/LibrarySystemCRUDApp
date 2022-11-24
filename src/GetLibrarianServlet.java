

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.app.dao.LibrarianDAO;

/**
 * Servlet implementation class GetLibrarianServlet
 */
@WebServlet("/GetLibrarianServlet")
public class GetLibrarianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLibrarianServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JSONArray jsonArray = new JSONArray();
		LibrarianDAO libDao = new LibrarianDAO();
		
		try {
			PrintWriter out = response.getWriter();
			jsonArray = libDao.getLibrarians();
			System.out.println(jsonArray.toJSONString());
			out.print(jsonArray.toJSONString());
			out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

}
