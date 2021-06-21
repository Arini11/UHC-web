<%@ page import = "java.util.*, proves.logica.*, proves.connexio.*" %>
<% int codiSortida = (int)request.getAttribute("codiSortida"); %>
<html>
<head>
<meta charset="utf-8">
<link rel="icon" href="img/UHC_logo.png" type="image/icon">
<link rel="stylesheet" type="text/css" href="css/estils.css">
<title>UHC</title>
</head>
<body>
<header>
	<img src="img/UHC_logo.png" alt="logo" width="250" height="250">
</header>
<div class="espai"></div>
<main>
	<div class="container">
	<div class="border-auxiliar">
		<div class="grid-container">
			<% if(codiSortida == 200) {%>
	    		<p>Equipo añadido correctamente!</p>
	    	<% } else if(codiSortida == 400){%>
	    		<p>El equipo ya existe!</p>
	    	<% } %>
		</div>
		<form action="<%= response.encodeURL("/UHC/add?action=Redirect") %>" method="post" id="redirect">
		 <a href="#" onclick="document.getElementById('redirect').submit();"> Menú </a>
		</form>
	</div>
	</div>
</main>
</body>
</html>