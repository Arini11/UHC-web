package proves.accions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proves.Action;

public class Index implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nextPage = "jsp/benvinguda.jsp";
		return nextPage;
	}
}
