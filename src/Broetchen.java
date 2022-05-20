
public class Broetchen extends Zutaten {
	private float backzeit;
	private int hoehe;
	private String broetchenName;
	
	
	public Broetchen(int hoehe) {
		this.hoehe = hoehe;
		switch(hoehe) {
		case 27: 
			broetchenName = "Hamburger (Standard)";
			backzeit = 1.5;
		case 28: 
			broetchenName = "Hamburger Sesam";
			backzeit = 1.5;
		case 34: 
			broetchenName = "Vegan-Br�tchen";
<<<<<<< HEAD
			backzeit = 4.0;
=======
			backzeit = 240;
>>>>>>> e1248bf9e1fdd211f566798eb3c040800ceb17b9
		case 41: 
			broetchenName = "Ciabatta";
			backzeit = 5.5;
		}
	}
	
<<<<<<< HEAD
	public float zubereiten() {
		System.out.println(broetchenName + " " + backzeit + " Minuten rösten und schneiden.");
=======
	public int zubereiten() {
		System.out.println(broetchenName + " " + (float) backzeit/60 + " Minuten roesten und aufschneiden");
>>>>>>> e1248bf9e1fdd211f566798eb3c040800ceb17b9
		return backzeit;
	}

	public float berechenHoehe() {
		float h;
		h = backzeit * (hoehe * 0,025) + hoehe;
		return h;
	}
	
}
