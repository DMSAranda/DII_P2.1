package dam2.dii.p21.dao;

import java.util.ArrayList;

import dam2.dii.p21.dao.IUserDAO;
import dam2.dii.p21.model.User;

public class UserDAOImplMem implements IUserDAO {

	public static ArrayList<User> agenda = new ArrayList<User>();
	
	@Override
	public ArrayList<User> getUserList() {

		ArrayList<User> listaContactos = new ArrayList<User>();

		listaContactos = agenda;

		return listaContactos;
	}

}
