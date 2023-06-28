<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>

<%@include file="cabecera.jsp" %>

</head>
<body>

	<div id="contenedor1">
		<h1>ALTA USUARIO</h1>

		

		<form id="form2" action="<%=request.getContextPath()%>/altacontroller" method="post">



			<div>
				<img id="im3" src="img/user.png" alt="" /> <input type="text"
					name="nombre" placeholder="INTRODUCE TU USUARIO" />
			</div>

			<br>

			<div>
				<img id="im4" src="img/key.png" alt="" /> <input type="password"
					name="pass1" placeholder="INTRODUCE TU CONTRASEÑA" />
			</div>

			<br>
			<br>

			<div>
				<img id="im5" src="img/key.png" alt="" /> <input type="password"
					name="pass2" placeholder="VUELVE A INTRODUCIR TU CONTRASEÑA" />
			</div>

			<br> <input type="submit" name="boton" value="Enviar" />

		</form>
		
		<br>
		


		<%
			String mensaje = (String) request.getAttribute("mensaje"); //recoge el atributo de mensaje

			if (mensaje == null) {

				mensaje = "";
				//si es null lo deja en blanco
			}
		%>


		<div id="contenedor2">
			<%=mensaje%>
			<br>
			<a href="index.jsp">VOLVER A LOGIN</a>
		</div>

	</div>

 <%@include file="pie.jsp" %>

</body>
</html>