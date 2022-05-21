public class Bratling extends Zutaten {
    private int bratzeit;
    private int hoehe;

    public Bratling(int nummer){
        this.nummer = nummer;
		switch(nummer) {
		case 20: 
			name = "Rindfleisch (Original)";
			preis = (float) 1.85;
			klassisch = true;
			vegetarisch = false;
			vegan = false;
			hoehe = 25;
			bratzeit = 270;
		case 21: 
			name = "Haendchenfleisch gegrillt";
			preis = (float) 1.15;
			klassisch = false;
			vegetarisch = false;
			vegan = false;
			hoehe = 11;
			bratzeit = 180;
		case 22: 
			name = "Falafel-Bratling";
			preis = (float) 1.45;
			klassisch = false;
			vegetarisch = false;
			vegan = true;
			hoehe = 21;
			bratzeit = 210;
		case 23: 
			name = "Gemuese-Bratling";
			preis = (float) 1.75;
			klassisch = false;
			vegetarisch = true;
			vegan = false;
			hoehe = 25;
			bratzeit = 240;
		}
    }
    
    public int zubereiten() {
		System.out.println(name + " von jeder Seite " + bratzeit/60/2 + " Minuten und " + ((bratzeit % 60)/2) + " Sekunden grillen.");
		return  bratzeit;
	}

	public float berechneHoehe() {
		float h;
		h = hoehe - ((float) bratzeit/60 * (hoehe * (float) 0.035));
		return h;
	}

	public float getBratzeit() {
		return bratzeit;
	}

	public int getHoehe() {
		return hoehe;
	}
}
