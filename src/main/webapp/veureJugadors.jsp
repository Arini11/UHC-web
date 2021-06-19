<%@ page import = "java.util.*, proves.logica.*, proves.connexio.*" %>
<%
	LogicaFacade dades = new LogicaFacade();
	List<String> lst = dades.getPlayers();
	String error = "";
	if(lst == null)
		error = "No hi ha jugadors";
%>
<html>
<head>
	<title>UHC</title>
	<link rel="icon" href="img/UHC_logo.png" type="image/icon">
	<link rel="stylesheet" type="text/css" href="css/estils.css">
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
		</tr>
	<%for (String p: lst) {%>
		<tr>
			<td><%=p.split(";")[0] %></td>
			<td><%=p.split(";")[1] %></td>
		</tr>
	<%} %>
	</table>
	</main>
	<p><%=error %></p>
</body>
</html>