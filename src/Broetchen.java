public class Broetchen extends Zutaten {
	private float backzeit;
	private int hoehe;
	
	public Broetchen(int nummer) {
		this.nummer = nummer;
		switch(nummer) {
		case 10: 
			name = "Hamburger (Standard)";
			preis = (float) 0.85;
			klassisch = false;
			vegetarisch = true;
			vegan = false;
			backzeit = (float) 1.5;
			hoehe = 27;
		case 11: 
			name = "Hamburger Sesam";
			preis = (float) 0.95;
			klassisch = false;
			vegetarisch = true;
			vegan = false;
			backzeit = (float) 1.5;
			hoehe = 28;
		case 12: 
			name = "Vegan-Broetchen";
			preis = (float) 0.55;
			klassisch = false;
			vegetarisch = false;
			vegan = true;
			backzeit = (float) 4.0;
			hoehe = 34;
		case 13: 
			name = "Ciabatta";
			preis = (float) 0.45;
			klassisch = false;
			vegetarisch = true;
			vegan = false;
			backzeit = (float) 5.5;
			hoehe = 41;
		}
	}
	
	public int zubereiten() {
		System.out.println(name + " " + backzeit + " Minuten roesten und schneiden.");
		return (int) (backzeit*60);
	}

	public float berechneHoehe() {
		float h;
		h =  backzeit * (hoehe * (float) 0.025) + hoehe;
		return h;
	}

	public float getBackzeit() {
		return backzeit;
	}

	public int getHoehe() {
		return hoehe;
	}
}
