package proves.accions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proves.Action;


public class RegistrarJugadors implements Action {
	
	public RegistrarJugadors() {
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "jsp/registrarJugadors.jsp";
	}
}
