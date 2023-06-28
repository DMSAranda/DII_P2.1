<%@ page import="dam2.dii.p21.model.User"%>

<html>
<head>


</head>

<body>

	<footer>
		
		<div id="foot">
	
			<%
			User user = (User) request.getSession().getAttribute("user"); //recoge el atributo de usuario

			if (user == null) {

				%>  SIN INICIAR  <% 
				//si es null lo deja en blanco
			}

			else {
				
				// NO COGE EL NOMBRE DE USUARIO EN EL FOOTER DE LA CABECERA DEL USUARIO DEL INDEX
				
				
				 out.println(user.getName());
				}
			%>

		</div>

	</footer>


</body>


</html>
