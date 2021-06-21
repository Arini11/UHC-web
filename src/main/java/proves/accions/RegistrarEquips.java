package proves.accions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proves.Action;
import proves.logica.LogicaFacade;


public class RegistrarEquips implements Action {
	
	public RegistrarEquips() {
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("codiSortida", 100);
		return "registrarEquips.jsp";
	}
}
