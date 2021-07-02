package proves.accions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proves.Action;


public class RegistrarEquips implements Action {
	
	public RegistrarEquips() {
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("codiSortida", 100);
		return "jsp/registrarEquips.jsp";
	}
}
