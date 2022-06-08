import java.util.Scanner;

/***
 * @author Aaron Stier, Muhanad Khatib, Thilo Wittmer
 * 
 * @class Controller fuer den Programmablauf
 * @bestellung arr zu dem potentiell ein neuer Burger hinzugefuegt wird
 * @anzahlBurger Anzahl der bisher erstellten Burger
 * @fertig [0] fuer gesamte Bestellung und fertig[1] fuer Burger Zusammenstellung und fertig[2] ob die Eingabe korrekt war
 */
public class Control {

	public static void main(String[] args) {
		int anzahlBurger = 0;
		//fertig[0] fuer gesamte Bestellung und fertig[1] fuer Burger Zusammenstellung und fertig[2] ob die Eingabe korrekt war
		boolean[] fertig = {false, true, false};
		Burger[] bestellung = new Burger[10];
		String eingabe = null;
		Scanner sc = new Scanner(System.in);
		final int MAX_ANZAHL = 10;
		ZutatenManager z = new ZutatenManager();

		System.out.println("You`ll never burger alone - Create your Burger");

		//Wiederholt bis bestellt wird 
		while(!fertig[0]){

			//Wenn die maximale Anzahl an Burgern erreicht wurde
			if(anzahlBurger == MAX_ANZAHL){
				System.out.println("Du hast die maximale Anzahl an Burgern von " + MAX_ANZAHL + " erreicht.");
				eingabe = "bestellen";
				inputMenu(eingabe, anzahlBurger, bestellung, fertig, z);
				break;
			}

			inputCheckMenu(anzahlBurger, fertig, bestellung, sc, z);

			//Solange ein Burger zusammengestellt wird
			while(!fertig[1]){
				//Wenn schon 8 Zutaten hinzugefuegt wurden und noch ein Broetchen fehlt
				if(bestellung[anzahlBurger].getAnzahlZutaten()==8 && !bestellung[anzahlBurger].istMitBroetchen()){
					System.out.println("Dein Burger hat fast die maximale Anzahl an Zutaten erreicht und du hast noch kein Broetchen.");
					System.out.println("Bitte waehle eins mit \"Zutat 10\", \"Zutat 11\", \"Zutat 12\" oder \"Zutat 13\":");

					eingabe = broetchenHinzufuegen(fertig, sc);
					fertig[2] = false;
					anzahlBurger = inputZutat(eingabe, anzahlBurger, bestellung, fertig, z);
					anzahlBurger = inputZutat("ok", anzahlBurger, bestellung, fertig, z);
					break;
				}

				//Wenn die maximale Anzahl an Zutaten erreicht wurde
				if(bestellung[anzahlBurger].isFull()){
					System.out.println("Dein Burger hat fast die maximale Anzahl an Zutaten erreicht.");
					anzahlBurger = inputZutat("ok", anzahlBurger, bestellung, fertig, z);
					break;
				}

				//Solange bis "ok" eingegeben wird bzw. solange der Burger zusammengestellt wird
				while (!fertig[2]){
					System.out.println("Bitte gib die " + (bestellung[anzahlBurger].getAnzahlZutaten()+1) + ". Zutat an:");
					eingabe = sc.nextLine();
					anzahlBurger = inputZutat(eingabe, anzahlBurger, bestellung, fertig, z);
				}
				fertig[2] = false;
			}
		}
		sc.close();
	}

	/***
	 * Methode, die den Nutzer dazu zwingt ein Broetchen auszuwaehlen
	 * @param fertig
	 * @param sc
	 * @return die Auswahl des Broetchens
	 */
	private static String broetchenHinzufuegen(boolean[] fertig, Scanner sc) {
		String eingabe = null;
		//Wiederholt bis eine korrekte Eingabe getätigt wurde
		while(!fertig[2]){
			eingabe = sc.nextLine();
			switch(eingabe){
				case "Zutat 10", "Zutat 11", "Zutat 12", "Zutat 13,": fertig[2] = true;
				break;
				default: System.out.println("Bitte waehle ein Broetchen mit \"Zutat 10\", \"Zutat 11\", \"Zutat 12\" oder \"Zutat 13\":");
			}
		}
		return eingabe;
	}

	/***
	 * Gibt Menu-Optionen aus und fordert Nutzer zur Eingabe auf
	 * @param anzahlBurger
	 * @param fertig
	 * @param bestellung
	 * @param sc
	 */
	private static void inputCheckMenu(int anzahlBurger, boolean[] fertig, Burger[] bestellung, Scanner sc, ZutatenManager z) {
		String eingabe;
		//Wiederholt bis eine korrekte Eingabe getätigt wurde
		while(!fertig[2]){
			System.out.println("Mit \"menu\" kannst du dir alle zur Verfuegung stehenden Zutaten anzeigen lassen.");
			System.out.println("Mit \"neuer Burger\" und einem Namen dahinter kannst du dir einen neuen Burger mit einem Namen erstellen.");
			System.out.println("Mit \"meine burger\" kannst du dir deine bisherige Bestellung anschauen.");
			System.out.println("Mit \"bestellen\" kannst du deine Bestellung abschliessen.");
			eingabe = sc.nextLine();
			inputMenu(eingabe, anzahlBurger, bestellung, fertig, z);
			if(!fertig[2]) {
				System.out.println();
				System.out.println("Bitte achte darauf, dass du einen der folgenden Befehle verwendest:");
			}
		}
		fertig[2] = false;
	}

	/***
	 * Verwertung der Eingabe (Menu-Optionen) wenn aktuell kein Burger in der Zusammenstellung ist
	 * @param eingabe user input
	 * @param bestellung
	 * @param anzahlBurger
	 * @param fertig
	 */
	public static void inputMenu(String eingabe, int anzahlBurger, Burger[] bestellung, boolean[] fertig, ZutatenManager z) {
		//wenn "menu" eingegeben wurde
		if(eingabe.contentEquals("menu")){
			z.printMenu();
			fertig[2] = true;
		}

		//wenn ein Neuer Burger erstellt wird
		if(eingabe.startsWith("neuer Burger ")){
			String name;
			name = eingabe.substring(13);
			bestellung[anzahlBurger] = new Burger(name);
			fertig[1] = false;
			fertig[2] = true;
			System.out.println("Du stellst einen neuen Burger zusammen.");
			System.out.println("Mit \"Zutat\" und der jeweiligen Nummer kannst du eine Zutat auswählen.");
			System.out.println("Du solltest mindestens ein Broetchen auswaehlen und darfst ansonsten bis zu 8 weitere Zutaten waehlen.");
			System.out.println("Mit \"ok\" kannst du deine Zusammenstellung abschließen.");
		}

		//Aufruf der bisherigen Bestellung
		if(eingabe.contentEquals("meine burger")){
			if (anzahlBurger > 0){
				printBestellung(bestellung, anzahlBurger);
				
			} else {
				System.out.println("Deine Bestellung enthaelt noch keine Burger.");
				System.out.println();
			}
			fertig[2] = true;
		}

		//Bestellung abschliessen
		if(eingabe.contentEquals("bestellen")){
			fertig[2] = true;
			if(anzahlBurger > 0){
				bestellen(anzahlBurger, bestellung, fertig);
			} else {
				System.out.println("Du hast leider keine Burger zusammengestellt. Deine Bestellung wird abgebrochen.");
				fertig[0] = true;
			}
		}
	}

	/***
	 * Ausgabe der Bestellung und der Rezepte
	 * @param anzahlBurger
	 * @param bestellung
	 * @param fertig
	 */
	private static void bestellen(int anzahlBurger, Burger[] bestellung, boolean[] fertig) {
		fertig[0] = true;
		System.out.println();
		System.out.println("Deine Burger werden frisch zubereitet.");
		System.out.println("Hier nochmal ein Uebersicht deiner Bestellung:");
		printBestellung(bestellung, anzahlBurger);
		System.out.println("");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("");

		for (int i=0; i < anzahlBurger; i++) {
			bestellung[i].printRezept();
			System.out.println("");
			System.out.println("");
		}
	}

	/***
	 * Verwertung der Eingabe (Zutaten-Optionen) wenn aktuell ein Burger zusammengestellt wird
	 * @param eingabe
	 * @param anzahlBurger
	 * @param bestellung
	 * @param fertig
	 * @return neuer Anzahl der Burger
	 */
	public static int inputZutat(String eingabe, int anzahlBurger, Burger[] bestellung, boolean[] fertig, ZutatenManager z) {
		String nummerStr;
		//wenn eine Zutat hinzugefuegt werden soll
		if(eingabe.startsWith("Zutat ")){
			nummerStr = eingabe.substring(6);
			zutatCheck(anzahlBurger, bestellung, fertig, nummerStr, z);
		//wenn die Zusammenstellung des aktuellen Burgers abgeschlossen werden soll	
		} else if(eingabe.contentEquals("ok")){
			anzahlBurger = okCheck(anzahlBurger, bestellung, fertig);
		} else {
			System.out.println();
			System.out.println("Bitte achte darauf, dass du den Befehl \"Zutat\" mit einer Bestellnummer oder \"ok\" verwendest.");
		}
		return anzahlBurger;
	}

	/***
	 * Schliesst die Zusammenstellung des aktuellen Burgers ab
	 * @param anzahlBurger
	 * @param bestellung
	 * @param fertig
	 * @return die neue Anzahl an Burgern
	 */
	private static int okCheck(int anzahlBurger, Burger[] bestellung, boolean[] fertig) {
		//Uberprueft ob schon ein Broetchen im Burger ist
		if(bestellung[anzahlBurger].istMitBroetchen()){
			fertig[1] = true;
			fertig[2] = true;
			System.out.println("Dein Burger \"" + bestellung[anzahlBurger].getName() + "\" wird aufgenommen.");
			anzahlBurger++;
		} else System.out.println("Dein Burger braucht mindestens ein Broetchen. Bitte fuege noch eins dazu.");
		return anzahlBurger;
	}

	/***
	 * Kontrolliert, ob nach "Zutat " eine Nummer angegeben wurde und speichert als Integer
	 * Andernfalls wird der Nutzer darauf hingewiese, dies zu tun.
	 * @param anzahlBurger
	 * @param bestellung
	 * @param fertig
	 * @param nummerStr String, die die Nummer enthaelt
	 */
	private static void zutatCheck(int anzahlBurger, Burger[] bestellung, boolean[] fertig, String nummerStr, ZutatenManager z) {
		int nummer;
		try {
			nummer = Integer.parseInt(nummerStr);
			nummerCheck(anzahlBurger, bestellung, fertig, nummer, z);
		} catch (Exception e) {
			System.out.println("Bitte nach \"Zutat\" eine Bestellnummer angeben:");
		}
	}

	/***
	 * Fuegt die Zutat mit der Bestellnummer dem aktuellen Burger hinzu
	 * @param anzahlBurger
	 * @param bestellung
	 * @param fertig
	 * @param nummer
	 */
	private static void nummerCheck(int anzahlBurger, Burger[] bestellung, boolean[] fertig, int nummer, ZutatenManager z) {
		//Wenn nummer eine existierende Bestellnummer ist
		Zutaten aktZutat = z.getZutat(nummer);
		if(aktZutat != null){
			//Wenn Broetchen existiert und ein weiteres Broetchen hinzugefuegt werden soll
			if(bestellung[anzahlBurger].istMitBroetchen() && z.getZutat(nummer).getClass() == Broetchen.class){
				System.out.println("Dein aktueller Burger hat bereits ein Broetchen.");
				System.out.println("Bitte waehle eine andere Zutat oder fuege den Burger deiner Bestellung hinzu.");
			}else {
				bestellung[anzahlBurger].zutatHinzufuegen(aktZutat);
				fertig[2] = true;
			}
		} else System.out.println("Bitte eine gueltige Bestellnumer angeben:");
	}

	/***
	 * Gibt alle bisher zusammengestellten Burger aus
	 * @param bestellung
	 * @param anzahlBurger
	 */
	public static void printBestellung(Burger[] bestellung, int anzahlBurger) {
		for (int i = 0; i < anzahlBurger; i++) {
			System.out.println("No." + (i+1) + "\t" + bestellung[i].getName() + ": " + bestellung[i].toString());
		}
	}
}
