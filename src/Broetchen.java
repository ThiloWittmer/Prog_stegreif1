
public class Broetchen extends Zutaten {
	private float backzeit;
	private int hoehe;
	private String broetchenName;
	
	
	public Broetchen(int hoehe) {
		this.hoehe = hoehe;
		switch(hoehe) {
		case 27: 
			broetchenName = "Hamburger (Standard)";
			backzeit = (float) 1.5;
		case 28: 
			broetchenName = "Hamburger Sesam";
			backzeit = (float) 1.5;
		case 34: 
			broetchenName = "Vegan-Br�tchen";
			backzeit = (float) 4.0;
		case 41: 
			broetchenName = "Ciabatta";
			backzeit = (float) 5.5;
		}
	}
	
	public float zubereiten() {
		System.out.println(broetchenName + " " + backzeit + " Minuten rösten und schneiden.");
		return backzeit;
	}

	public float berechenHoehe() {
		float h;
		h = backzeit * (hoehe * 0,025) + hoehe;
		return h;
	}
	
}
