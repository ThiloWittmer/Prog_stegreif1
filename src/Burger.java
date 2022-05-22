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
		for (int i=0; i < anzahlZutaten; i++) {
			preis += zutaten[i].getPreis();
		}
		preis = (Math.round(preis*100))/100;
		return preis;
	}

	public float berechneHoehe(){
		float hoehe = 0.0f;
		for (int i=0; i < anzahlZutaten; i++) {
			hoehe += zutaten[i].berechneHoehe();
		}
		return hoehe;
	}

	public boolean istVegan(){
		for (int i=0; i < anzahlZutaten; i++) {
			if(!zutaten[i].istVegan()){
				return false;
			}
		}
		return true;
	}

	public boolean istVegetarisch(){
		for (int i=0; i < anzahlZutaten; i++) {
			if(!zutaten[i].istVegetarisch()){
				return false;
			}
		}
		return true;
	}

	public boolean mitFleisch(){
		for (int i=0; i < anzahlZutaten; i++){
			if(!zutaten[i].istKlassisch()){
				return false;
			}
		}
		return true;
	}

	public String Geschmack() {
		String geschmacksrichtung = "";
		for(int i=0; i < anzahlZutaten; i++) {
			if(zutaten[i].getNummer()>=50) {
				geschmacksrichtung += "- " + zutaten[i].getGeschmack() + " ";
			}
		}			
		return geschmacksrichtung;
	}
	
	public boolean klassisch() {		
		for(int i=0; i < anzahlZutaten; i++) {
			if(!zutaten[i].istKlassisch()) {
				return false;
			}
		}	
		return true;
	}
	
	public String toString() {
		String ausgabe = "";	
		for(int i=0; i < anzahlZutaten; i++) {
			ausgabe+= "- " + zutaten[i].getName() + " ";
		}
		return ausgabe;
	}

	public void zutatHinzufuegen(int nummer) {
		switch(nummer) {
		case 10, 11, 12, 13:mitBroetchen= true;
		}
		zutaten[anzahlZutaten]= z.getZutat(nummer);
		anzahlZutaten++;
	}

	public int printRezept(Burger burger) {
		int zeit=0;
		char c = 'a';
		
		System.out.println("Rezept - " + name + " (" + Math.round(berechneHoehe())/10f + " cm" + Zutaten.printBoolean(klassisch(), "Klassisch") +
		Zutaten.printBoolean(istVegetarisch(), "Vegetarisch") + Zutaten.printBoolean(istVegan(), "Vegan") + ") - " + berechnePreis() + " Euro");
		System.out.println("Zutaten: " + burger.toString());
		System.out.println();
		System.out.println("Und so geht`s:");
		
		for (int i=0; i < anzahlZutaten; i++) {
			System.out.print(c + " - ");
			zeit += zutaten[i].zubereiten();
			c++;
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
	
	
	
	



