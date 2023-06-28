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
@WebServlet("/deletecontroller")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteController() {
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

		User user2 = (User) request.getSession().getAttribute("user");
		
		String nombre = (String) request.getParameter("nombre");
		
		UserService servicio = new UserService();
		
		User user3 = servicio.devuelvePass(nombre);
		

		if (user3.getName().equalsIgnoreCase("admin")) {

			request.getSession().setAttribute("user", user2);
			request.getSession().setAttribute("mensaje", "PERMISO DENEGADO.");
			response.sendRedirect(request.getContextPath() + "/admin.jsp");
		}

		else {
			
				
			UserDAOImplMem.agenda.remove(user3);     //borro el usuario con el nombre antiguo

			request.getSession().setAttribute("mensaje", "USUARIO ELIMINADO.");
				
			request.getSession().setAttribute("user", user2);  //mantengo la sesion del admin
				
			response.sendRedirect(request.getContextPath() + "/admin.jsp");   //vuelvo a su menu
		}
	
  }

}
