package proves.objectes;

public class Usuari {
	
	private String usr;
	private String pswd;
	/*
	 * Rols:
	 *   admin
	 *   usuari
	 */
	private String rol;
	
	public Usuari(String usr, String pswd) {
		this.usr = usr;
		this.pswd = pswd;
		// El rol s'estableix més tard, des de la lògica, amb el setter
		this.rol = "";
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}	

}
