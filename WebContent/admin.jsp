<%@ page import="dam2.dii.p21.model.User"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>

<html>
<head>

<%@include file="cabecera.jsp"%>

</head>
<body>

	<div id="contenedor1">

		<h1>MENU ADMIN</h1>

		<div id="contenedor2">

			<br> <a href="<%=request.getContextPath()%>/enlacepass">CAMBIAR
				PASSWORD</a> <br> <br>

			

			<br>

			<%
				ArrayList<User> lista = (ArrayList<User>) request.getSession().getAttribute("array");
			%>

			<%
				Iterator<User> it = lista.iterator();
			%>

			<h1>Listado de Usuarios</h1>

			<br>

			<table id="tabla">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Password</th>

					</tr>

				</thead>

				<tbody>
					<%
						
						while (it.hasNext()) {

							User us = it.next();
							
					%>
					<tr>
						<td><%=us.getName()%></td>
						<td><%=us.getPass1()%></td>
						<td><form id="form4"
								action="<%=request.getContextPath()%>/enlacerename"
								method="post">
								<input type="hidden" name= "nombre" value="<%=us.getName() %>">
							    <input type="submit" id="boton" name="boton" value="Cambiar Nombre" />
								
							</form></td>

						<td><form id="form4"
								action="<%=request.getContextPath()%>/deletecontroller"
								method="post">
								<input type="hidden" name= "nombre" value="<%=us.getName() %>">
							    <input type="submit" id="boton" name="boton" value="Eliminar" />
								
							</form></td>

					</tr>

				</tbody>
				<%
					}
				%>

			</table>
			<br> <br>



			<%
				lista = null;
			%>

			

			<%
				String mensaje = (String) request.getSession().getAttribute("mensaje"); //recoge el atributo de mensaje

				if (mensaje == null) {

					mensaje = "";
					//si es null lo deja en blanco
				}
			%>


			<div >
				<br><br>
				<%=mensaje%>
			</div>

		</div>

	</div>

	<%@include file="pie.jsp"%>

</body>

</html>