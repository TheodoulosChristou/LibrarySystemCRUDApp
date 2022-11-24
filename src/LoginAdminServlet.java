import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dao.AdminDAO;
import com.app.dbConnection.DBConnection;
import com.app.model.Admin;

@WebServlet("/LoginAdminServlet")
public class LoginAdminServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		Admin admin = null;
		String username = request.getParameter("username");
		String password = request.getParameter("pws");
		try {
			AdminDAO  adminDAO = new AdminDAO();
			admin = adminDAO.getAdmin(username, password);
			HttpSession session = request.getSession();
			session.setAttribute("adminFirstName", admin.getFirstName());
			RequestDispatcher rd = request.getRequestDispatcher("welcomePage.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
