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
	private boolean mitBroetchen= false;
	private String geschmack;


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
			for (Zutaten aktZutate : zutaten) {
				if(!aktZutate.istVegan()){
					return false;
				}
			}return true;
		}

	public boolean istVegetarisch(){
		for (Zutaten aktZutat : zutaten) {
			if(!aktZutat.istVegetarisch()){
				return false;
			}
		}return true;
		}

	public boolean mitFleisch(){
		for (Zutaten aktZutat : zutaten){
			if(!aktZutat.istKlassisch()){
				return false;
			}
		}return true;
	}

	public String Geschmack() {
		String geschmacksrichtung = "";
		for(Zutaten aktZutat : zutaten) {
			if(aktZutat.getNummer()>=50) {
				geschmacksrichtung += "- " + aktZutat.getGeschmack() + " ";
			}
		}			
		return geschmacksrichtung;
	}
	
	public boolean klassisch() {		
		for(Zutaten aktZutat : zutaten) {
			if(!aktZutat.istKlassisch()) {
				return false;
			}
		}	
		return true;
	}
	
	public String toString() {
		String ausgabe = "";	
		for(Zutaten aktZutat : zutaten) {
			ausgabe+= "- " + aktZutat.getName() + " ";
		}
		return ausgabe;
	}

	public void zutatHinzufuegen(int nummer) {
		switch(nummer) {
		case 10, 11, 12, 13:mitBroetchen= true;
		
		zutaten[anzahlZutaten]= z.getZutat(nummer);
		anzahlZutaten++;
		}			
	}

	public int printRezept(Burger burger) {
		int zeit=0;
		char c = 'a';
		
		System.out.println("Rezept - " + name + " (" + Math.round(berechneHoehe())/10 + " cm, " + 
		Zutaten.printBoolean(istVegetarisch(), "Vegetarisch") + Zutaten.printBoolean(istVegan(), "Vegan") + ") - " + berechnePreis() + " Euro");
		System.out.println("Zutaten: " + burger.toString());
		System.out.println();
		System.out.println("Und so geht`s:");
		
		for (int i=0; i < zutaten.length; i++) {
			System.out.println((c+i) + " - ");
			zeit += zutaten[i].zubereiten();
		}

		return zeit;
	}

	public String getName() {
		return name;
	}

	public int getAnzahlZutaten() {
		return anzahlZutaten;
	}

	public boolean istMitBroetchen() {
		return mitBroetchen;
	}

	public String getGeschmack() {
		return geschmack;
	}
}	
	
	
	
	



