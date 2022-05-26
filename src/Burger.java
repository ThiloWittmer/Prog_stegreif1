/***
 * @author Timo, Mohamad, Aaron
 * @version 3.0
 * 
 * @class Burger - Hier wird pro Eingabeaufforderung ein Objekt vom Typ Burger erstellt
 * @public Die Methoden stehen auf public da die Klasse Controler auf diese zugreifen muss
 * @param String name = jeder Burger bekommt einen eigenen Namen
 * @param Zutaten[] = pro Burger können max. 9 Zuaten hinzugefügt werden welche im Array gespeichert werden
 * @param anzahlZutaten = Zähler für die Anzahl
 * @param mitBroetchen = pro BUrger MUSS ein Brötchen ausgewählt werden
 * @param String Geschmack = Ein Burger hat je nach Soße und Zutaten einen bestimmten Geschmack
 *  */ 
public class Burger{
	private String name;
	private Zutaten[] zutaten = new Zutaten[9];
	private int anzahlZutaten;
	private ZutatenManager z = new ZutatenManager();
	private boolean mitBroetchen= false;
	private String geschmack;

	/***
	 * 
	 * @param name Über den Konstruktor der Klasse wird ein Burger mit seinem Namen definiert
	 */

	public Burger(String name){
		this.name = name;
	}

	/**
	 * @param preis		Der Preis berechnet sich durch alle hinzugefügten Zutaten -
	 * 					dafür wird das gesamte Zutaten Array invertiert und aus jeder Klasse die Methode .getPreis() aufgerufen 
	 * 					welche den Preis der jeweiligen Zutat zurückgibt
	 * @return preis 	Der Gesamtpreis aller Zutaten 
	 */
	public float berechnePreis(){
		float preis = 0.0f;
		for (int i=0; i < anzahlZutaten; i++) {
			preis += zutaten[i].getPreis();
		}
		preis = (Math.round(preis*100))/100f;
		return preis;
	}

	/***
	 * @param hoehe		Gleiches Prinzip wie bei der Methode berechnePreis() - das Array Zuaten wird invertiert und ruft die Methode 
	 * 					berechneHoehe() der jeweiligen Klasse auf und wird in der Varibalen hoehe gespeichert
	 * @return hoehe	Gibt die Gesamthoehe des Burgers zurück
	 */
	public float berechneHoehe(){
		float hoehe = 0.0f;
		for (int i=0; i < anzahlZutaten; i++) {
			hoehe += zutaten[i].berechneHoehe();
		}
		return hoehe;
	}

	/**+
	 * Die Methoden istVegan() - istVegatrisch() - mitFleisch() prüfen die einzelen Zutaten auf ihre Inhaltsstoffe und lesen 
	 * aus dem jeweiligen Zutaten Objekt den Paramter aus 
	 * @return Boolean Wert welcher angibt ob die Variante true oder false ist
	 */
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

	/***
	 * Gibt die Geschmacksrichtung zurück - hierzu wird die jeweilige Soßennummer abgefragt und aus der Klasse Sauce 
	 * mittels der Methode getGeschmack() dieser Wert übergeben
	 * @return geschmacksrichtung = Geschmack der jeweiligen Soße
	 */
	public String Geschmack() {
		String geschmacksrichtung = "";
		for(int i=0; i < anzahlZutaten; i++) {
			if(zutaten[i].getNummer()>=50) {
				geschmacksrichtung += "- " + zutaten[i].getGeschmack() + " ";
			}
		}			
		return geschmacksrichtung;
	}
	
	/**
	 * Wenn alle Zutaten den Parameter klassisch sind wird der Burger Typ zu klassisch
	 * @return boolean klassisch oder nicht
	 */
	public boolean klassisch() {		
		for(int i=0; i < anzahlZutaten; i++) {
			if(!zutaten[i].istKlassisch()) {
				return false;
			}
		}	
		return true;
	}

	/**
	 * @return Fragt den Namen der Zutat aus der Nummer ab und gibt Sie in einem String aus
	 */
	public String toString() {
		String ausgabe = "";	
		for(int i=0; i < anzahlZutaten; i++) {
			ausgabe+= "- " + zutaten[i].getName() + " ";
		}
		return ausgabe;
	}

	/***
	 * Hier werden die hinzugefügten Zutaten aus der Abfrage in das Array zutaten[] gespeichert -
	 * dazu wird aus der Klasse Zutatenmanager mittels der Nummer die jeweilige Zutat zurückgeliefert
	 * @param mitBroetchen = es wird abgefragt ob schon ein Brötchen hinzugefügt wurde
	 * @param anzahlZutaten = bei jeder Zutat wird der Zähler erhöt (max. 9)
	 */
	public void zutatHinzufuegen(int nummer) {
		switch(nummer) {
		case 10, 11, 12, 13:mitBroetchen= true;
		}
		zutaten[anzahlZutaten]= z.getZutat(nummer);
		anzahlZutaten++;
	}

	/***
	 * Ausgabe des Burger Rezeptes - Aufruf der obigen Methoden 
	 * Die Hoehe wird auf zwei Nachkommastellen gerundet und mit den anderen Werten ausgegeben
	 * @param burger = Der Methode wird immer ein Objekt vom Typ Burger übergeben
	 * @param char c = Als Aufzählungselemt für die Ausgabe wird die Variable c mit jedem durchlauf erhöht
	 * @return zeit = Die Zubereitungszeit des Burgers wird gespeichert und zurückgegeben - durch die jeweilige Methode in der Klasse berechnet
	 */
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
	
	
	
	



