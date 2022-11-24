import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.AdminDAO;

@WebServlet("/RegisterAdminServlet")
public class RegisterAdminServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		int result = 0;
		String username = request.getParameter("username");
		String password = request.getParameter("pws");
		String firstName = request.getParameter("lastName");
		String lastName = request.getParameter("firstName");
		try {
			AdminDAO adminDAO = new AdminDAO();
			result = adminDAO.getRegisteredAdmin(username, password, firstName, lastName);
			RequestDispatcher rd = request.getRequestDispatcher("registerMessage.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			System.out.println("Problem please check it");
			e.printStackTrace();
		}
		
	}

}
