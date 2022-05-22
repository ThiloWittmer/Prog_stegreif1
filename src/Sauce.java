public class Sauce extends Zutaten {
    private int menge;
    private String geschmack;

    public Sauce(int nummer){
        this.nummer = nummer;
		switch(nummer) {
		case 50: 
			name = "Ketchup";
			preis = (float) 0.1;
			klassisch = true;
			vegetarisch = false;
			vegan = true;
            menge = 5;
            geschmack = "normal";
            break;
		case 51: 
			name = "Sandwich-Sauce";
			preis = (float) 0.15;
			klassisch = true;
			vegetarisch = true;
			vegan = false;
            menge = 10;
            geschmack = "normal";
            break;
		case 52: 
			name = "Chili-Sauce";
			preis = (float) 0.25;
			klassisch = false;
			vegetarisch = false;
			vegan = true;
            menge = 8;
            geschmack = "scharf";
            break;
		case 53: 
			name = "Honig-Senf-Sauce";
			preis = (float) 0.18;
			klassisch = false;
			vegetarisch = true;
			vegan = false;
            menge = 8;
            geschmack = "suess";
        }
    }

    public int zubereiten() {
        System.out.print(name + " wird geschuettelt");
        return 0;
    }

    public float berechneHoehe() {
        return 0;
    }

    public int getMenge() {
        return menge;
    }

    public String getGeschmack() {
        return geschmack;
    }

    public String toString() {
		return "No." + nummer + "\t" + name + " - Preis = " + preis + " Euro\t" + print(klassisch, "Klassisch")
				+ print(vegan, "Vegan") + print(vegetarisch, "Vegetarisch") + " (" + geschmack + ")";
	}
	private String print(boolean b, String s) {
		if(b) {
			return " - " + s;
		}
		return "";
	}
}
