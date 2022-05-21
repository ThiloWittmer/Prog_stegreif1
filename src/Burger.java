/***
 * Data:
•	String: name
•	Object [9]: Zutaten
•	Int: anzahlZutaten 

Methoden:
•	Float: berechnePreis()
•	Float: berechneHoehe()
•	Boolean: istVegan()
•	Boolean: istVegetarisch()
•	Boolean: istMitFleisch()
•	String: geschmack() [abhängig von Sauce]
•	Boolean: klassisch()
•	Int: zeitBerechnen()
•	Boolean: zutatHinzufuegen(int index) // boolean: existiert Brötchen?
•	String: zutatenString() (Alle Zutaten in ein String)

 */

public class Burger {
	private String name;
	private Zutaten[] zutaten = new Zutaten[9];
	private int anzahlZutaten;


}
