<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>

<%@include file="cabecera.jsp"%>

</head>
<body>

	<div id="contenedor1">
		
		<h1>CAMBIO CLAVE</h1>

		<form id="form3" action="<%=request.getContextPath()%>/changepasscontroller"
			method="post">

			<div>
				<img id="im6" src="img/user.png" alt="" /> <input type="password"
					name="pass" placeholder="INTRODUCE TU ANTIGUA CONTRASEÑA" />
			</div>

			<br>

			<div>
				<img id="im7" src="img/key.png" alt="" /> <input type="password"
					name="pass1" placeholder="INTRODUCE TU NUEVA CONTRASEÑA" />
			</div>

			<br> <br>

			<div>
				<img id="im8" src="img/key.png" alt="" /> <input type="password"
					name="pass2" placeholder="VUELVE A INTRODUCIR TU NUEVA CONTRASEÑA" />
			</div>

			<br> <input type="submit" name="boton" value="Enviar" />

		</form>


		<%
			String mensaje = (String) request.getAttribute("mensaje"); //recoge el atributo de mensaje

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