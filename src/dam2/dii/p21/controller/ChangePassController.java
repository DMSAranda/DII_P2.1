package dam2.dii.p21.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dam2.dii.p21.dao.UserDAOImplMem;
import dam2.dii.p21.model.User;


/**
 * Servlet implementation class Sesion
 */
@WebServlet("/changepasscontroller")
public class ChangePassController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePassController() {
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

		String claveOld = request.getParameter("pass"); // recoge nombre y claves del index
		String clave1 = request.getParameter("pass1");
		String clave2 = request.getParameter("pass2");

		User user2 = (User) request.getSession().getAttribute("user");

		String nombre = user2.getName();

		System.out.println("cambiar clave de usuario: " + nombre);

		if (claveOld.isEmpty() || clave1.isEmpty() || clave2.isEmpty()) { // si esta vacio lo deja en null

			claveOld = null;
			clave1 = null;
			clave2 = null;

			request.setAttribute("mensaje", "NO PUEDE HABER CAMPOS VACIOS"); // envia mensaje al index de que no estan
																				// campos rellenados
			request.getRequestDispatcher("password.jsp").forward(request, response);
		}

		else {

			if (clave1.equalsIgnoreCase(clave2)) {

				if (user2.getPass1().equals(claveOld)) { // si la clave antigua coincide con la del usuario

					UserDAOImplMem.agenda.remove(user2);

					user2.setPass1(clave1);
					UserDAOImplMem.agenda.add(user2);

					request.getSession().setAttribute("user", user2);
					request.getSession().setAttribute("mensaje", "CAMBIO DE CLAVE REALIZADO.");
					response.sendRedirect(request.getContextPath() + "/index2.jsp");
				}

				else {
					request.getSession().setAttribute("user", user2);
					request.getSession().setAttribute("mensaje", "LA CLAVE ANTIGUA NO ES VÁLIDA.");
					response.sendRedirect(request.getContextPath() + "/password.jsp");
				}

			}

			else {
				request.getSession().setAttribute("user", user2);
				request.getSession().setAttribute("mensaje", "LAS CLAVES NO COINCIDEN.");
				response.sendRedirect(request.getContextPath() + "/password.jsp");
			}

		}

	}

}
