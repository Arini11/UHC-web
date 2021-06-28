package proves.accions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import proves.Action;
import proves.logica.LogicaFacade;
import proves.objectes.Usuari;


public class Valida implements Action {
	static final String PG_IDX = "jsp/benvinguda.jsp";
	static final String PG_INI = "jsp/menu.jsp";

	public Valida() {}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nextPage = null;
		String error = "";
		String user = request.getParameter("UserName");
		String pwd = request.getParameter("Password");
		Usuari usr = new Usuari(user, pwd); 
		LogicaFacade dades = new LogicaFacade();
		error = dades.valida(user, pwd, usr);
		if (error.equalsIgnoreCase("")){
			HttpSession ses = request.getSession();
			ses.removeAttribute("usuari");
			ses.setAttribute("usuari", usr);
			request.setAttribute("usuari", usr.getUsr());
			nextPage=PG_INI;
		} else {
			request.setAttribute("user", user); 
			request.setAttribute("error", error); 
			nextPage=PG_IDX;
		}	
		return nextPage;
	}

}
