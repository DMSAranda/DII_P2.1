
package dam2.dii.p21.model;

public class User {
	
	public User() {
		super();
	}

	private String name;
	private String pass1;
	private String pass2;

	public User(String name, String pass, String pass2) {
		super();
		this.name = name;
		this.pass1 = pass;
		this.pass2 = pass2;
	}

	public User(String name, String pass) {
		super();
		this.name = name;
		this.pass1 = pass;
	}
	
	public User(String name) {
		super();
		this.name = name;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass) {
		this.pass1 = pass;
	}

	
}
