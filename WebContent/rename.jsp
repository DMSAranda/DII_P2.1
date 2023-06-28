<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>

<%@include file="cabecera.jsp"%>

</head>
<body>

	<div id="contenedor1">
		
		<h1>CAMBIAR NOMBRE</h1>

		<form id="form3" action="<%=request.getContextPath()%>/changenamecontroller"
			method="post">

			<div>
				<img id="im7" src="img/user.png" alt="" /> <input type="text"
					name="name1" placeholder="INTRODUCE NUEVO NOMBRE" />
			</div>

			<br> <br>

			<div>
				<img id="im8" src="img/user.png" alt="" /> <input type="text"
					name="name2" placeholder="VUELVE A INTRODUCIR NUEVO NOMBRE" />
			</div>

			<br> <input type="submit" name="boton" value="Enviar" />

		</form>
		
	    <div id="contenedor2">
		<a href="<%=request.getContextPath()%>/returnadmincontroller">VOLVER</a>
		</div>
		
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