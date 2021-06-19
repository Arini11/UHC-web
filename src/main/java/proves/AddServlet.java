package proves;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String s = req.getParameter("action");
		System.out.println(s);
		//res.getWriter().print("Bones, "+s);
		if(s.equalsIgnoreCase("registrarEquips"))
			res.sendRedirect("registrarEquips.jsp");
		else if(s.equalsIgnoreCase("veureEquips"))
			res.sendRedirect("veureEquips.jsp");
		
	}
	
}
