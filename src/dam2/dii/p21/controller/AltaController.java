package dam2.dii.p21.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dam2.dii.p21.model.User;
import dam2.dii.p21.service.UserService;

@WebServlet("/altacontroller")
public class AltaController extends HttpServlet { // servlet
	
	
	private static final long serialVersionUID = 1L;

	public AltaController() {
		super(); // constructor vacio

	}

	public void init() throws ServletException { // incializamos
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response); // de doget a dopost directo
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre"); // recoge nombre y claves del index
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");

		if (nombre.isEmpty() || pass1.isEmpty() || pass2.isEmpty()) { // si esta vacio lo deja en null

			nombre = null;
			pass1 = null;
			pass2 = null;

			request.getSession().setAttribute("mensaje", "NO PUEDE HABER CAMPOS VACIOS"); // envia mensaje al index de que no estan
																				// campos rellenados
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}

		else {

			User user = new User(nombre, pass1, pass2); // crea un obketo usuario con los atributos que se recogen desde
														// el form del alta

			user.setName(nombre);
			user.setPass1(pass1);
			user.setPass2(pass2);

			if (user.getPass1().equals(user.getPass2())) { // si las claves coinciden devuelve el objeto a la vista
															// salida

				

				UserService servicio = new UserService();

				if (servicio.compruebaExiste(user) == false) {

					servicio.agregarAgenda(user);

					request.getSession().setAttribute("mensaje", "ALTA CORRECTA.");
					response.sendRedirect(request.getContextPath() + "/index.jsp");

				}

				else {
					
					request.getSession().setAttribute("user", null);
					request.getSession().setAttribute("mensaje", "USUARIO EXISTENTE.");
					response.sendRedirect(request.getContextPath() + "/alta.jsp");

				}

			}

			else {
				request.getSession().setAttribute("user", null);
				request.getSession().setAttribute("mensaje", "LAS CLAVES NO COINCIDEN.");
				response.sendRedirect(request.getContextPath() + "/alta.jsp");
			}

		}

	}

}