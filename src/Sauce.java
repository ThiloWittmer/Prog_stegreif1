public class Sauce extends Zutaten {
    private int menge;
    private String geschmack;

    public Sauce(int nummer){
        this.nummer = nummer;
		switch(nummer) {
		case 50: 
			name = "Ketchup";
			preis = 0.1f;
			klassisch = true;
			vegetarisch = true;
			vegan = true;
            menge = 5;
            geschmack = "normal";
            break;
		case 51: 
			name = "Sandwich-Sauce";
			preis = 0.15f;
			klassisch = true;
			vegetarisch = true;
			vegan = false;
            menge = 10;
            geschmack = "normal";
            break;
		case 52: 
			name = "Chili-Sauce";
			preis = 0.25f;
			klassisch = false;
			vegetarisch = true;
			vegan = true;
            menge = 8;
            geschmack = "scharf";
            break;
		case 53: 
			name = "Honig-Senf-Sauce";
			preis = 0.18f;
			klassisch = false;
			vegetarisch = true;
			vegan = false;
            menge = 8;
            geschmack = "suess";
        }
    }

    public int zubereiten() {
        System.out.println(name + " wird geschuettelt");
        return 0;
    }

    public float berechneHoehe() {
        return 0f;
    }

    public int getMenge() {
        return menge;
    }

    public String getGeschmack() {
        return geschmack;
    }

    public String toString() {
		return "No." + nummer + "\t" + name + " - Preis = " + preis + " Euro\t" + Zutaten.printBoolean(klassisch, "Klassisch")
				+ Zutaten.printBoolean(vegan, "Vegan") + Zutaten.printBoolean(vegetarisch, "Vegetarisch") + " (" + geschmack + ")";
	}
}
