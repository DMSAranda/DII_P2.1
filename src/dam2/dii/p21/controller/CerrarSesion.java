package dam2.dii.p21.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dam2.dii.p21.model.User;

/**
 * Servlet implementation class Sesion
 */
@WebServlet("/cerrarsesion")
public class CerrarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CerrarSesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entrando al controlador del cierre de sesión");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = (User) request.getSession().getAttribute("user");
		
		String nombre = user.getName();
		
		System.out.println("cerrar sesion: " + nombre);
				
		//invalidar atributo (deslogar)
		//request.getSession().invalidate();
		
		request.getSession().setAttribute("user", null);
		request.getSession().setAttribute("mensaje", "SESION CERRADA.");
		request.getSession().setAttribute("array", null);
		
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

}
