public class Broetchen extends Zutaten {
	private int backzeit;
	private int hoehe;
	
	public Broetchen(int nummer) {
		this.nummer = nummer;
		switch(nummer) {
		case 10: 
			name = "Hamburger (Standard)";
			preis = (float) 0.85;
			klassisch = true;
			vegetarisch = true;
			vegan = false;
			backzeit = 90;
			hoehe = 27;
		case 11: 
			name = "Hamburger Sesam";
			preis = (float) 0.95;
			klassisch = true;
			vegetarisch = true;
			vegan = false;
			backzeit = 90;
			hoehe = 28;
		case 12: 
			name = "Vegan-Broetchen";
			preis = (float) 0.55;
			klassisch = false;
			vegetarisch = false;
			vegan = true;
			backzeit = 240;
			hoehe = 34;
		case 13: 
			name = "Ciabatta";
			preis = (float) 0.45;
			klassisch = false;
			vegetarisch = true;
			vegan = false;
			backzeit = 330;
			hoehe = 41;
		}
	}
	
	public int zubereiten() {
		System.out.println(name + " " + (float) backzeit/60 + " Minuten roesten und schneiden.");
		return backzeit;
	}

	public float berechneHoehe() {
		float h;
		h =  (float) backzeit/60 * (hoehe * (float) 0.025) + hoehe;
		return h;
	}

	public float getBackzeit() {
		return backzeit;
	}

	public int getHoehe() {
		return hoehe;
	}
}
