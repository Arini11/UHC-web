package proves.accions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proves.Action;
import proves.logica.LogicaFacade;


public class GenerarInforme implements Action {
	
	public GenerarInforme() {
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		LogicaFacade dades = new LogicaFacade();

		dades.generarInforme();
		
		return "informe.pdf";
	}
}
