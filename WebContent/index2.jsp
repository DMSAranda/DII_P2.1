<%@ page import="dam2.dii.p21.model.User"%>

<!DOCTYPE html>

<html>
<head>

<%@include file="cabecera.jsp"%>

</head>
<body>

	<div id="contenedor1">
		
		<h1>SESION INICIADA</h1>

		<div id="contenedor2">
		
			<br> <a href="<%=request.getContextPath()%>/enlacepass">CAMBIAR
			PASSWORD</a>
			
			
			
			<%
				String mensaje = (String) request.getSession().getAttribute("mensaje"); //recoge el atributo de mensaje

				if (mensaje == null) {

					mensaje = "";
					//si es null lo deja en blanco
				}
			%>
			
			<br>
			<br>
			<div><%=mensaje%></div>
			
		</div>

	</div>

	<%@include file="pie.jsp"%>

</body>

</html>