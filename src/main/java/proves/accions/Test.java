package proves.accions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proves.Action;
import proves.logica.LogicaFacade;


public class Test implements Action {
	
	public Test() {
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// obtenir dades formulari
		String nom = request.getParameter("nom");
		String nickname = request.getParameter("nickname");
		
		// insertar dades a la taula
		LogicaFacade dades = new LogicaFacade();
		dades.insertPlayer(nom, nickname);
		
		request.removeAttribute("codiSortida");
		request.setAttribute("codiSortida", 100);
		// retornar a l'índex
		return "index2.jsp";
	}
}
