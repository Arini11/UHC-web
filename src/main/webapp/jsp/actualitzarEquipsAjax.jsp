<%@ page import = "java.util.*, proves.logica.*, proves.connexio.*" %>
<%
	LogicaFacade dades = new LogicaFacade();
	List<String> lst = dades.getTeams();
	String error = "";
	if(lst.isEmpty())
		error = "No hi ha equips";
%>
<html>
<body>
<main id="main_ajax">
	<table id="taula_ajax">
	<tbody>
		<tr>
			<th>Nombre</th>
		</tr>
		<%for(int i=0;i<lst.size();i++) {%>
		<tr >
			<td id="td_<%= i %>"><%=lst.get(i) %></td>
			<td class="sensePadding"><input class="botoEliminar" type="button" value="" onclick="ajaxFuncio(<%= i %>);" /></td>
		</tr>
		<%} %>
	</tbody>
	</table>
	<h3 class="codiSortida incorrecte centrat"><%=error %></h3>
</main>
</body>
</html>