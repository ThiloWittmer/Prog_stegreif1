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

public class Burger {
	private String name;
	private Zutaten[] zutaten = new Zutaten[9];
	private int anzahlZutaten;
	private Zutatenliste z = new Zutatenliste();
	private boolean mitBroetchen= false;
	private String geschmack;
	


	
	
	public String Geschmack() {
		String geschmacksrichtung;
		for(Zutaten aktZutat : zutaten) {
			if(aktZutat.getNummer()>=50) {
				geschmacksrichtung+= "- " + aktZutat.getGeschmack() + " ";
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
			
	public int zeitBerechnen()  {
		int zeit=0;
		for(Zutaten aktZutat : zutaten) {
			zeit+= aktZutat.zubereiten();		
		}
		return zeit;
	}
	
	public String toString() {
		String ausgabe= name + ": ";		
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
}	
	
	
	
	



