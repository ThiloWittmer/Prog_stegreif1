/***
 * Data:
•	String: name
•	Object [9]: Zutaten
•	Int: anzahlZutaten 

	!!Konstruktor mit Name als Parameter muss noch implementiert werden.
	Zutaten werden jetzt ueber die Klasse Zutatenliste verwaltet: 
	Die Methode z.getZutat(int nummer) gibt ein passendes Objekt der Zutat zurueck

Methoden:

	//Aaron
•	Float: berechnePreis()
•	Float: berechneHoehe()
•	Boolean: istVegan()
•	Boolean: istVegetarisch()
•	Boolean: istMitFleisch()

	//Mohamad
•	String: geschmack() [abhängig von Sauce]
•	Boolean: klassisch()
•	Int: zeitBerechnen()
•	Boolean: zutatHinzufuegen(int anzahlZutaten, int nummer) // boolean: existiert Brötchen?; nummer: nummer der Zutat
•	String: zutatenString() (Alle Zutaten in ein String)

 */

public class Burger{
	private String name;
	private Zutaten[] zutaten = new Zutaten[9];
	private int anzahlZutaten;
	private Zutatenliste z = new Zutatenliste();


	public Burger(String name){
		this.name = name;
	}

	public float berechnePreis(){
		float preis = 0.0f;
		for (Zutaten aktZutat : zutaten) {
			preis += aktZutat.getPreis();
		}
		return preis;
	}

	public float berechneHoehe(){
		float hoehe = 0.0f;
		for (Zutaten aktZutat : zutaten) {
			hoehe += aktZutat.berechneHoehe();
		}
		return hoehe;
	}

	public boolean istVegan(){
		boolean istVegan = false;
		for (Zutaten aktZutat : zutaten) {
			if(aktZutat.vegan = true){
				istVegan = true;
				}
			}
			return istVegan;
		}

	public boolean istVegetarisch(){
		boolean istVegetarisch = false;
		for (Zutaten aktZutat : zutaten) {
			if(aktZutat.vegan = true){
				istVegetarisch = true;
			}
		}
		return istVegetarisch;
		}

	public boolean mitFleisch(){
		boolean istKlassisch = false;
		for (Zutaten aktZutat : zutaten) {
			if(aktZutat.klassisch == true){
				istKlassisch = true;
			}
		}
		return istKlassisch;
	}

}