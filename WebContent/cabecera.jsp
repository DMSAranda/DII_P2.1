<%@ page import="dam2.dii.p21.model.User"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/styles.css" />
<title>App</title>

</head>

<body>

	<%
		User user2 = (User) request.getSession().getAttribute("user");
	%>
	<header>

		<div id="head">

			<%
				if (user2 == null) {
			%>
			INICIA SESIÓN
			<%
				}

				else {
			%>

			
			<a href="<%=request.getContextPath()%>/cerrarsesion">CERRAR
				SESION</a>

			<%
				//crear un controlador para cerrar
				}
			%>

		</div>

	</header>



</body>



</html>