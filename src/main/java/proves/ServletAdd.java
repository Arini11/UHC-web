package proves;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proves.Action;
import proves.FactoryImpl;
import proves.logica.LogicaFacade;

public class ServletAdd extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		Action action=null;
		String nextPage=null;
		String nameAction = request.getParameter("action");
		System.out.println(dtf.format(now)+"\t"+request.getRemoteAddr()+"\t"+nameAction);
		
		try {
			action= FactoryImpl.getReference().getAction(nameAction);
			nextPage = action.execute(request, response);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(response.encodeURL("/"+nextPage));
			rd.forward(request, response);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		//res.getWriter().print("Bones, "+s);
		//res.sendRedirect("test.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
}
