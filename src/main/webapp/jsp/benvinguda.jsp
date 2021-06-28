<%@ page import = "java.util.List, java.util.Iterator" %>
<%
String error = (String) request.getAttribute("error");
String user = (String) request.getAttribute("user");
if (error == null){error = "";}
if (user == null){user = "";}
%>
<head>
	<title>UHC</title>
	<link rel="icon" href="img/UHC_logo.png" type="image/icon">
	<link rel="stylesheet" type="text/css" href="css/estils.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="description" content="Pàgina esdeveniment UHC" />
</head>
<body>
<div class="">
	<form action="<%= response.encodeURL("/UHC/servletController?action=Valida") %>" method="post">
	     <h1>Accedir</h1>
	     <div class="">
	     	<% if (user.equalsIgnoreCase("")){ %>
	       		<input type="text" class="" placeholder="user" name="UserName" id="UserName" value="" autofocus autocomplete="off">
	     	<% } else { %>
	       		<input type="text" class="" placeholder="user" name="UserName" id="UserName" value=<%=user %> autocomplete="off">
	       	<% } %>
	     </div>
	     <div class="">
	     	<% if (user.equalsIgnoreCase("")){ %>
	       		<input type="password" class="" placeholder="passwd" name="Password" id="Password">
	     	<% } else { %>
	       		<input type="password" class="" placeholder="passwd" name="Password" id="Password" autofocus>
	       	<% } %>
	     </div>
	     <h3><%=error%></h3>
		 <input type="submit" class="" value="Entrar">
	</form>
</div>
</body>
</html>