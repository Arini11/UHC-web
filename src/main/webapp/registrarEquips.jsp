<%@ page import = "java.util.*, proves.logica.*, proves.connexio.*" %>
<%
	LogicaFacade dades = new LogicaFacade();
	int codiSortida = (int)request.getAttribute("codiSortida");
%>
<html>
<head>
<meta charset="utf-8">
<link rel="icon" href="img/UHC_logo.png" type="image/icon">
<link rel="stylesheet" type="text/css" href="css/estils.css">
<title>UHC</title>
</head>
<body>
<header>
	<a href="index.jsp"><img src="img/UHC_logo.png" alt="logo" width="250" height="250"></a>
</header>

<div class="espai"></div>

<main>
	<div class="container">
		<form action="<%= response.encodeURL("/UHC/add?action=Test2") %>" method="post">
			<input type="text" name="nom" placeholder="Nombre equipo" autocomplete="off" required>
			<input type="submit" value="Registrar" id="enviar">
		</form>
		<%if(codiSortida == 200){ %>
			<h3 class="codiSortida correcte">Correcte</h3>
		<%} else if(codiSortida == 400){ %>
			<h3 class="codiSortida incorrecte">Incorrecte</h3>
		<%} %>
	</div>
</main>
</body>
</html>