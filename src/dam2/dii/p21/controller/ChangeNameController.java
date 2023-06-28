package dam2.dii.p21.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dam2.dii.p21.dao.UserDAOImplMem;
import dam2.dii.p21.model.User;
import dam2.dii.p21.service.UserService;

/**
 * Servlet implementation class Sesion
 */
@WebServlet("/changenamecontroller")
public class ChangeNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeNameController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name1 = request.getParameter("name1"); // recoge nombre
		String name2 = request.getParameter("name2");

		User user2 = (User) request.getSession().getAttribute("user");
		
		User user3 = (User) request.getSession().getAttribute("user2");

		
		if (name1.isEmpty() || name2.isEmpty()) { // si esta vacio lo deja en null

			name1 = null;
			name2 = null;

			request.getSession().setAttribute("mensaje", "NO PUEDE HABER CAMPOS VACIOS"); 
			request.getSession().setAttribute("user", user2);
			request.getSession().setAttribute("user2", user3);
			response.sendRedirect(request.getContextPath() + "/rename.jsp");
		}

		else {				//////  se queda la pantalla en blanco y lo del jdk8

			if (name1.equalsIgnoreCase(name2)) {

				UserService servicio = new UserService();
				
				if (servicio.compruebaExiste(user3) == true) {
					
					user3 = servicio.devuelvePass(user3.getName());     // si existe pido ya el usuario con clave tambien
					
					UserDAOImplMem.agenda.remove(user3);     //borro el usuario de la agenda con el nombre antiguo

					user3.setName(name1); // le cambio el nombre
					
					UserDAOImplMem.agenda.add(user3);    //le añado a la agenda

					request.getSession().setAttribute("mensaje", "NOMBRE CAMBIADO.");
					
					request.getSession().setAttribute("user", user2);  //mantengo la sesion del admin
					
					response.sendRedirect(request.getContextPath() + "/admin.jsp");   //vuelvo a su menu

				}
				
				else {
					request.getSession().setAttribute("user", user2);
					request.getSession().setAttribute("user2", user3);
					request.getSession().setAttribute("mensaje", "EL USUARIO NO EXISTE.");
					response.sendRedirect(request.getContextPath() + "/rename.jsp");
				}
				
				
				
			}

			else {
				request.getSession().setAttribute("user", user2);
				request.getSession().setAttribute("user2", user3);
				request.getSession().setAttribute("mensaje", "LOS NOMBRE NO COINCIDEN.");
				response.sendRedirect(request.getContextPath() + "/rename.jsp");
			}

		}

	}

}
