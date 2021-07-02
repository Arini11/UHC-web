package proves.accions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proves.Action;


public class Redirect implements Action {
	
	public Redirect() {
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "jsp/index.jsp";
	}
}
