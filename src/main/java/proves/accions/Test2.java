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
		 *  100 -> Null, encara no s'ha enviat res al servidor, per tant,
		 *  no hi pot haver codi de sortida
		 *  200 -> Correcte
		 *  400 -> Algun error
		 */
		request.removeAttribute("codiSortida");
		request.setAttribute("codiSortida", dades.insertTeam(nom));
		// retornar a l'�ndex
		return "registrarEquips.jsp";
	}
}
