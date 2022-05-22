
public abstract class Zutaten {
	protected int nummer;
	protected String name;
	protected float preis;
	protected boolean klassisch;
	protected boolean vegan;
	protected boolean vegetarisch;
	
	public abstract int zubereiten();
	public abstract float berechneHoehe();
	
	
	public String toString() {
		return "No." + nummer + "\t" + name + " - Preis = " + preis + " Euro\t" + printBoolean(klassisch, "Klassisch")
				+ printBoolean(vegan, "Vegan") + printBoolean(vegetarisch, "Vegetarisch");
	}

	public static String printBoolean(boolean b, String s) {
		if(b) {
			return " - " + s;
		}
		return "";
	}
	public int getNummer() {
		return nummer;
	}
	public String getName() {
		return name;
	}
	public float getPreis() {
		return preis;
	}
	public String getGeschmack(){
		return "";
	}
	public boolean istKlassisch() {
		return klassisch;
	}
	public boolean istVegan() {
		return vegan;
	}
	public boolean istVegetarisch() {
		return vegetarisch;
	}
}
