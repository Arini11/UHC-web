<%@ page import = "java.util.*, proves.logica.*, proves.connexio.*" %>
<%
	LogicaFacade dades = new LogicaFacade();
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
		<form action="<%= response.encodeURL("/UHC/servletController?action=Test") %>" method="post">
			<input type="text" name="nom" placeholder="Nombre y apellidos" autocomplete="off" autofocus required>
			<input type="text" name="nickname" placeholder="Nickname" autocomplete="off" required>
			<input type="submit" value="Registra" id="enviar">
		</form>
	</div>
</main>
</body>
</html>