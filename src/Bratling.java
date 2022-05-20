public class Bratling extends Zutaten {
    private float bratzeit;
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
		case 21: 
			name = "Haendchenfleisch gegrillt";
			preis = (float) 1.15;
			klassisch = true;
			vegetarisch = false;
			vegan = false;
		case 22: 
			name = "Falafel-Bratling";
			preis = (float) 1.45;
			klassisch = false;
			vegetarisch = false;
			vegan = true;
		case 23: 
			name = "Gemuese-Bratling";
			preis = (float) 1.75;
			klassisch = false;
			vegetarisch = true;
			vegan = false;
		}
    }
    
    public int zubereiten() {
		System.out.println(name
 + " von jeder Seite " + (int) bratzeit/2 + " Minuten und " + ((bratzeit % 1)/2)*60 + " Sekunden grillen.");
		return (int) bratzeit*60;
	}

	public float berechneHoehe() {
		float h;
		h = hoehe - (bratzeit * (hoehe * (float) 0.035));
		return h;
	}

	public float getBratzeit() {
		return bratzeit;
	}

	public int getHoehe() {
		return hoehe;
	}
}
