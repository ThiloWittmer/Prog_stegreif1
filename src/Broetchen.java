public class Broetchen extends Zutaten {
	private int backzeit;
	private int hoehe;
	
	public Broetchen(int nummer) {
		this.nummer = nummer;
		switch(nummer) {
		case 10: 
			name = "Hamburger (Standard)";
			preis = 0.85f;
			klassisch = true;
			vegetarisch = true;
			vegan = false;
			backzeit = 90;
			hoehe = 27;
			break;
		case 11: 
			name = "Hamburger Sesam";
			preis = 0.95f;
			klassisch = true;
			vegetarisch = true;
			vegan = false;
			backzeit = 90;
			hoehe = 28;
			break;
		case 12: 
			name = "Vegan-Broetchen";
			preis = 0.55f;
			klassisch = false;
			vegetarisch = true;
			vegan = true;
			backzeit = 240;
			hoehe = 34;
			break;
		case 13: 
			name = "Ciabatta";
			preis = 0.45f;
			klassisch = false;
			vegetarisch = true;
			vegan = false;
			backzeit = 330;
			hoehe = 41;
		}
	}
	
	public int zubereiten() {
		System.out.println(name + " " + backzeit/60f + " Minuten roesten und schneiden.");
		return backzeit;
	}

	public float berechneHoehe() {
		float h;
		h =  (float) backzeit/60 * (hoehe * 0.025f) + hoehe;
		return h;
	}

	public float getBackzeit() {
		return backzeit;
	}

	public int getHoehe() {
		return hoehe;
	}
}
