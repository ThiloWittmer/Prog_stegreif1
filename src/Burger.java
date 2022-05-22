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


}

public Burger(String name, Zutatenliste zutat, int anzahlZutaten,int nummer){
this.name = name;
this.zutat = z.getZutat(nummer);
this.anzahlZutaten = anzahlZutaten;
}

public static float berechnePreis(Zutaten[] array){
	float preis;
	
	for(int i = 0; i <= array.length; i++){
		preis += array[i].getPreis();
	}
	return preis;
}

public float berechneHoehe(Zutaten[] array){
	float hoehe;
	for(int i = 0; i <= array.length; i++){
		hoehe = Bratling.berechneHoehe() + Broetchen.berechneHoehe() + Gemuese.berechneHoehe(); 
	}
	return hoehe;
}

public boolean istVegan(){

}

public boolean istVegetarisch(){

}

public boolean mitFleisch(){
	
}

