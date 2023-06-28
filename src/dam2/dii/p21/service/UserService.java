package dam2.dii.p21.service;

import java.util.ArrayList;
import java.util.Iterator;

import dam2.dii.p21.dao.UserDAOImplMem;
import dam2.dii.p21.dao.IUserDAO;
import dam2.dii.p21.model.User;

public class UserService {
	
	private IUserDAO udao = new UserDAOImplMem();

	ArrayList<User> libreta = udao.getUserList();
	

	public ArrayList<User> agregarAgenda(User contact) {

		libreta.add(contact);

		UserDAOImplMem.agenda = libreta;

		return libreta;
	}

	public boolean compruebaExiste(User user) {

		boolean existe = false;

		try {

			Iterator<User> it = libreta.iterator();

			while (it.hasNext()) {

				User user2 = it.next();

				String name = user2.getName();
				

				if (name.equals(user.getName()) ) {
					existe = true;
				}

			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Datos fuera de límites");
		}

		return existe;
	}
	
	public boolean compruebaLogin(User user) {

		boolean correcto = false;

		try {

			Iterator<User> it = libreta.iterator();

			while (it.hasNext()) {

				User user2 = it.next();

				String name = user2.getName();
				String pass = user2.getPass1();
				

				if (name.equals(user.getName()) && pass.equalsIgnoreCase(user.getPass1()) )  {
					correcto = true;
				}

			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Datos fuera de límites");
		}

		return correcto;
	}
	
	public User devuelvePass(String nombre) {

		User aux = new User();

		try {

			Iterator<User> it = libreta.iterator();

			while (it.hasNext()) {

				User user2 = it.next();

					if (nombre.equals(user2.getName()) )  {
					aux = user2;
				}

			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Datos fuera de límites");
		}

		return aux;
	}
	


}
