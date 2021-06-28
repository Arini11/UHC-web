<%@ page import = "java.util.*, proves.logica.*, proves.connexio.*" %>
<%
	LogicaFacade dades = new LogicaFacade();
	List<String> lst = dades.getTeams();
	String error = "";
	if(lst.isEmpty())
		error = "No hi ha equips";
%>
<html>
<head>
	<title>UHC</title>
	<link rel="icon" href="img/UHC_logo.png" type="image/icon">
	<link rel="stylesheet" type="text/css" href="css/estils.css">
	<script language="javascript" type="text/javascript">
	function ajaxFuncio(i){
		var ajaxRequest;  // The variable that makes Ajax possible!	
		try{
			// Opera 8.0+, Firefox, Safari
			ajaxRequest = new XMLHttpRequest();
		} catch (e){
			// Internet Explorer Browsers
			try{
				ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try{
					ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e){
					// Something went wrong
					alert("Your browser broke!");
					return false;
				}
			}
		}

		ajaxRequest.onreadystatechange = function(){
			if(ajaxRequest.readyState == 4){
				var ajaxDisplay = document.getElementById("main_ajax");
				ajaxDisplay.innerHTML = ajaxRequest.responseText;
			}
		}

		var equip = document.getElementById("td_"+i).innerText;
		ajaxRequest.open("GET", "/UHC/servletController?action=EliminarEquipAjax&equip="+equip, true);
		ajaxRequest.send(null);
	}
	</script>
</head>
<body>
	<header>
		<a href="index.jsp"><img src="img/UHC_logo.png" alt="logo" width="250" height="250"></a>
	</header>

	<div class="espai"></div>

	<main id="main_ajax">
	<table>
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