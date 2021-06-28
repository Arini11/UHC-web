package proves.accions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proves.Action;
import proves.logica.LogicaFacade;


public class EliminarEquipAjax implements Action {
	
	public EliminarEquipAjax() {
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String equip = request.getParameter("equip");
		LogicaFacade dades = new LogicaFacade();
		dades.eliminarEquip(equip);
		return "jsp/actualitzarEquipsAjax.jsp";
	}
}
