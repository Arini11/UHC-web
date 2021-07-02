package proves.objectes;

public class Jugador {
	
	private String nom;
	private String nickname;
	private String equip;
	
	public Jugador(String nom, String nickname, String equip) {
		this.nom = nom;
		this.nickname = nickname;
		this.equip = equip;
	}

	public String getNom() {
		return nom;
	}

	public String getNickname() {
		return nickname;
	}

	public String getEquip() {
		return equip;
	}
	
}
