<%@ page import = "java.util.*, proves.logica.*, proves.connexio.*" %>
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
			<div class="imgJugSol">
				<img width="65px" height="175px" alt="jugador sol" src="img/player.png"/>
			</div>
			<div class="regJug">
				<a href="/UHC/add?action=registrarJugadors">Registrar jugador</a>
			</div>
			<div class="veuJug">
				<a href="/UHC/add?action=veureJugadors">Ver jugadores</a>
			</div>
		</div>
		<div class="grid-container">
			<div class="imgJugTeam">
				<img width="65px" height="175px" alt="jugador sol" src="img/player.png"/>
			</div>
			<div class="imgJugTeam2">
				<img width="65px" height="175px" alt="jugador sol" src="img/player.png"/>
			</div>
			<div class="regEq">
				<a href="/UHC/add?action=registrarEquips">Registrar equipo</a>
			</div>
			<div class="veuEq">
				<a href="/UHC/add?action=veureEquips">Ver equipos</a>
			</div>
		</div>
	</div>
	</div>
</main>


</body>
</html>