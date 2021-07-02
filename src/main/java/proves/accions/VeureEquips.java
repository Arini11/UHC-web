package proves.accions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proves.Action;


public class VeureEquips implements Action {
	
	public VeureEquips() {
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "jsp/veureEquips.jsp";
	}
}
