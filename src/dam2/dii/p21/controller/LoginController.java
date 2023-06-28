package dam2.dii.p21.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dam2.dii.p21.dao.UserDAOImplMem;
import dam2.dii.p21.model.User;
import dam2.dii.p21.service.UserService;

@WebServlet("/logincontroller")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("controlador: get");

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("controlador: post");

		String name = request.getParameter("name");
		String pass = request.getParameter("pass1");
		
		if(UserDAOImplMem.agenda.isEmpty()) {
			
			User one = new User("david", "12345");          //datos de muestra
			User two = new User("admin", "admin");
			User three = new User("mar", "54321");
			
			UserDAOImplMem.agenda.add(one);
			UserDAOImplMem.agenda.add(two);
			UserDAOImplMem.agenda.add(three);
		}

		if (name.isEmpty() || pass.isEmpty()) {

			if (name.isEmpty()) {

				name = null;
			}

			else if (pass.isEmpty()) {

				pass = null;
			}

			User user2 = new User(name, pass);

			request.getSession().setAttribute("mensaje", "NO PUEDE HABER CAMPOS VACIOS");

			request.getSession().setAttribute("user", user2);

			response.sendRedirect(request.getContextPath() + "/index.jsp");

		}

		else {

			User user2 = new User(name, pass);

			user2.setName(name);
			user2.setPass1(pass);

			UserService servicio = new UserService();

			if (servicio.compruebaExiste(user2) == true) {

				if (servicio.compruebaLogin(user2) == true) {

					request.getSession().setAttribute("user", user2);

					request.getSession().setAttribute("mensaje", null);

					if (user2.getName().equals("admin")) {
						
						ArrayList<User> aux =  UserDAOImplMem.agenda;
												
						request.getSession().setAttribute("array", aux);
						
						response.sendRedirect(request.getContextPath() + "/admin.jsp");

					} else {

						response.sendRedirect(request.getContextPath() + "/index2.jsp");
					}
				}

				else {

					request.getSession().setAttribute("mensaje", "LOGIN INCORRECTO.");

					request.getSession().setAttribute("user", null);

					response.sendRedirect(request.getContextPath() + "/index.jsp");
				}

			}

			else {

				/*
				 * servicio.agregarAgenda(user); request.getSession().setAttribute("mensaje",
				 * "ALTA CORRECTA"); request.getSession().setAttribute("array",
				 * UserDAOImplMem.agenda);
				 */

				response.sendRedirect(request.getContextPath() + "/alta.jsp");

			}

		}

	}
}
