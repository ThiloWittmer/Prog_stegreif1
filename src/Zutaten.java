/***
 * @class Zutaten - Werte Definiton der Zutaten der OberKlasse
 * @parameter nummer - jede Zutat hat eine Nummer  
 * @parameter name - jede Zutat hat einen Name 
 * @parameter preis - jede Zutat hat einen Preis
 * @parameter klassisch - die Zutat kann klassisch sein
 * @parameter vegan- die Zutat kann vegan sein
 * @parameter vegetarisch - die Zutat kann vegetarisch sein 
 */

public abstract class Zutaten {
	protected int nummer;
	protected String name;
	protected float preis;
	protected boolean klassisch;
	protected boolean vegan;
	protected boolean vegetarisch;
	
	/***
	 *die Methode zubereiten - Ausgabe jeder Zutat, wie sie zubereitet wird
	 * @return gibt wie viele Sekunden die Zubereitung gedauert hat zurück
	 * die Methode berechneHoehe - berechnung der Hoehe vom Bürger
	 */
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
