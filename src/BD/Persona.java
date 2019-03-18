package BD;

import java.io.Serializable;

public class Persona implements Serializable {

	private String email;
	private String contrase�a;
	private String nick;
	private int idPersona;

	public Persona(String email, String contrase�a, String nick) {
		
		this.email = email;
		this.contrase�a = contrase�a;
		this.nick = nick;
	}
	
	public Persona(String email,String contrase�a) {
		this.email = email;
		this.contrase�a = contrase�a;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public String getNick() {
		return nick;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	
}
