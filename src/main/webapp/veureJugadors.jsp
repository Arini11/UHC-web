<%@ page import = "java.util.*, proves.logica.*, proves.connexio.*" %>
<%
	LogicaFacade dades = new LogicaFacade();
	List<String> lst = dades.getPlayers();
	List<String> teams = dades.getTeams();
	String error = "";
	if(lst == null)
		error = "No hi ha jugadors";
%>
<html>
<head>
	<title>UHC</title>
	<link rel="icon" href="img/UHC_logo.png" type="image/icon">
	<link rel="stylesheet" type="text/css" href="css/estils.css">
	<script language="javascript" type="text/javascript">
	function ajaxFuncio(equip,jugador,td_id){
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
				var ajaxDisplay = document.getElementById("p_"+td_id);
				ajaxDisplay.innerHTML = ajaxRequest.responseText;
			}
		}
		
		ajaxRequest.open("GET", "/UHC/add?action=CanviarEquip&equip="+equip+"&jugador="+jugador, true);
		ajaxRequest.send(null);
	}
	function submitForm(element)
    {
        var equip = element.value;
        var td_id = element.parentElement.id;
        var jugador = document.getElementById("nom_"+td_id).innerText;
        ajaxFuncio(equip,jugador,td_id)
    }
	</script>
</head>
<body>
	<header>
		<a href="index.jsp"><img src="img/UHC_logo.png" alt="logo" width="250" height="250"></a>
	</header>

	<div class="espai"></div>

	<main>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Nickname</th>
			<th>Team</th>
		</tr>
	<%for(int j=0;j<lst.size();j++) {%>
		<tr>
			<td><%=lst.get(j).split(";")[0] %></td>
			<td id="nom_<%=j%>"><%=lst.get(j).split(";")[1] %></td>
			<td id="<%=j%>">
				<select class="llista" onchange="submitForm(this);">
					<%for(int i=0;i<teams.size();i++){ %>
    					<option value="<%=teams.get(i)%>"><%=teams.get(i)%></option>
    				<%} %>
    			</select>
    			<p id="p_<%=j%>"><%=lst.get(j).split(";")[2] %></p>
    		</td>
		</tr>
	<%} %>
	</table>
	</main> 
	<p><%=error %></p>
</body>
</html>