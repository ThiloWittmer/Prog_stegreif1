
public class Broetchen extends Zutaten {
	private int backzeit;
	private int hoehe;
	private String broetchenName;
	
	
	public Broetchen(int hoehe) {
		this.hoehe = hoehe;
		switch(hoehe) {
		case 27: 
			broetchenName = "Hamburger (Standard)";
			backzeit = 90;
		case 28: 
			broetchenName = "Hamburger Sesam";
			backzeit = 90;
		case 34: 
			broetchenName = "Vegan-Brötchen";
			backzeit = 240;
		case 41: 
			broetchenName = "Ciabatta";
			backzeit = 330;
		}
	}
	
	public int zubereiten() {
		return backzeit;
	}
}
