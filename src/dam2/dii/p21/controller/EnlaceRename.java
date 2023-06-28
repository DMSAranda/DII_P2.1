package dam2.dii.p21.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dam2.dii.p21.model.User;
import dam2.dii.p21.service.UserService;

/**
 * Servlet implementation class Sesion
 */
@WebServlet("/enlacerename")
public class EnlaceRename extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnlaceRename() {
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
		
		request.getSession().setAttribute("user", user2);
		request.getSession().setAttribute("user2", user3);
	
		response.sendRedirect(request.getContextPath() + "/rename.jsp");

	}

}
