package proves.accions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proves.Action;
import proves.logica.LogicaFacade;


public class CanviarEquip implements Action {
	
	public CanviarEquip() {
	}

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String txt = "";
		String equip = request.getParameter("equip");
		String jugador = request.getParameter("jugador");
		LogicaFacade dades = new LogicaFacade();
		dades.actualitzarEquipJugador(equip,jugador);
		txt += dades.getTeamFromPlayer(jugador);
		request.setAttribute("equip", equip);
		//return txt;
		return "canviarEquip.jsp";
	}
}
