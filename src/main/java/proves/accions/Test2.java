package proves.accions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proves.Action;
import proves.logica.LogicaFacade;


public class Test2 implements Action {
	
	public Test2() {
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// obtenir dades formulari
		String nom = request.getParameter("nom");
		
		// insertar dades a la taula
		LogicaFacade dades = new LogicaFacade();
		
		// codis sortida
		/*
		 *  200 -> Correcte
		 *  400 -> Algun error
		 */
		request.setAttribute("codiSortida", dades.insertTeam(nom));
		// retornar a l'índex
		return "index2.jsp";
	}
}
