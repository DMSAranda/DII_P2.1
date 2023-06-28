<%@ page import="dam2.dii.p21.model.User"%>

<!DOCTYPE html>

<html>
<head>

<%@include file="cabecera.jsp"%>

</head>
<body>

	<div id="contenedor1">
	
		<h1>INCIAR SESIÓN</h1>

		<form id="form1"
			
			action="<%=request.getContextPath()%>/logincontroller" method="post">

			<div>
				<img id="im1" src="img/user.png" alt="" /> <input type="text"
					name="name" placeholder="INTRODUCE TU USUARIO" />
			</div>

			<br> <img id="im2" src="img/key.png" alt="" /> <input
				type="password" name="pass1" placeholder="INTRODUCE TU CONTRASEÑA" />

			<br> <br> <br> <input type="submit" name="boton"
				value="Enviar" />

		</form>


		<%
			String mensaje = (String) request.getSession().getAttribute("mensaje"); //recoge el atributo de mensaje

			if (mensaje == null) {

				mensaje = "";
				//si es null lo deja en blanco
			}
		%>

		<div id="contenedor2">
			<%=mensaje%>
			
		</div>

	</div>

	<%@include file="pie.jsp"%>

</body>

</html>