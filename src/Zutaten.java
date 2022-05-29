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

	
	
	public Zutaten(int nummer, String name, float preis, boolean klassisch, boolean vegan, boolean vegetarisch) {
		this.nummer = nummer;
		this.name = name;
		this.preis = preis;
		this.klassisch = klassisch;
		this.vegan = vegan;
		this.vegetarisch = vegetarisch;
	}
	
	/***
	 *die Methode zubereiten - Ausgabe jeder Zutat, wie sie zubereitet wird
	 * @return gibt wie viele Sekunden die Zubereitung gedauert hat zur�ck
	 * die Methode berechneHoehe - berechnung der Hoehe vom B�rger
	 */
	public abstract int zubereiten();
	public abstract float berechneHoehe();
	
	/***
	 * @return die Werte der Zutat als String
	 */
	public String toString() {
		return "No." + nummer + "\t" + name + " - Preis = " + preis + " Euro\t" + printBoolean(klassisch, "Klassisch")
				+ printBoolean(vegan, "Vegan") + printBoolean(vegetarisch, "Vegetarisch");
	}

	/***
	 * @param b boolean der Zutateneigenschaft
	 * @param s Beschreibung des boolean
	 * @return	Wenn b==true dann wird die Beschreibung (z.B. "vegan") zurueck gegeben
	 */
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
	public boolean isKlassisch() {
		return klassisch;
	}
	public boolean isVegan() {
		return vegan;
	}
	public boolean isVegetarisch() {
		return vegetarisch;
	}
}
