import java.util.Scanner;

public class Control {

	public static void main(String[] args) {
		int anzahlBurger = 0;
		//fertig[0] fuer gesamte Bestellung und fertig[1] fuer Burger Zusammenstellung und fertig[2] ob die Eingabe korrekt war
		boolean[] fertig = {false, true, false};
		Burger[] bestellung = new Burger[10];
		String eingabe = null;
		Scanner sc = new Scanner(System.in);

		System.out.println("You`ll never burger alone - Create your Burger");

		//Wiederholt bis bestellt wird 
		while(!fertig[0]){

			//Wenn die maximale Anzahl an Burgern erreicht wurde
			if(anzahlBurger == 10){
				System.out.println("Du hast die maximale Anzahl an Burgern von 10 erreicht.");
				eingabe = "bestellen";
				inputMenu(eingabe, anzahlBurger, bestellung, fertig);
				break;
			}

			inputCheckMenu(anzahlBurger, fertig, bestellung, eingabe, sc);

			//Solange ein Burger zusammengestellt wird
			while(!fertig[1]){
				//Wenn schon 8 Zutaten hinzugefuegt wurden und noch ein Broetchen fehlt
				if(bestellung[anzahlBurger].getAnzahlZutaten()==8 && !bestellung[anzahlBurger].istMitBroetchen()){
					System.out.println("Dein Burger hat fast die maximale Anzahl an Zutaten erreicht und du hast noch kein Broetchen.");
					System.out.println("Bitte waehle eins mit \"Zutat 10\", \"Zutat 11\", \"Zutat 12\" oder \"Zutat 13\":");

					eingabe = broetchenHinzufuegen(fertig, sc);
					fertig[2] = false;
					anzahlBurger = inputZutat(eingabe, anzahlBurger, bestellung, fertig);
					anzahlBurger = inputZutat("ok", anzahlBurger, bestellung, fertig);
					break;
				}

				//Wenn die maximale Anzahl an Zutaten erreicht wurde
				if(bestellung[anzahlBurger].getAnzahlZutaten()==9){
					System.out.println("Dein Burger hat fast die maximale Anzahl an Zutaten erreicht.");
					anzahlBurger = inputZutat("ok", anzahlBurger, bestellung, fertig);
					break;
				}

				while (!fertig[2]){
					System.out.println("Bitte gib die " + (bestellung[anzahlBurger].getAnzahlZutaten()+1) + ". Zutat an:");
					eingabe = sc.nextLine();
					anzahlBurger = inputZutat(eingabe, anzahlBurger, bestellung, fertig);
				}
				fertig[2] = false;
			}
		}
		sc.close();
	}

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

	private static void inputCheckMenu(int anzahlBurger, boolean[] fertig, Burger[] bestellung, String eingabe, Scanner sc) {
		//Wiederholt bis eine korrekte Eingabe getätigt wurde
		while(!fertig[2]){
			System.out.println("Mit \"menu\" kannst du dir alle zur Verfügung stehenden Zutaten anzeigen lassen.");
			System.out.println("Mit \"neuer Burger\" und einem Namen dahinter kannst du dir einen neuen Burger mit einem Namen erstellen.");
			System.out.println("Mit \"meine burger\" kannst du dir deine bisherige Bestellung anschauen.");
			System.out.println("Mit \"bestellen\" kannst du deine Bestellung abschliessen.");
			eingabe = sc.nextLine();
			inputMenu(eingabe, anzahlBurger, bestellung, fertig);
			if(!fertig[2]) {
				System.out.println();
				System.out.println("Bitte achte darauf, dass du einen der folgenden Befehle verwendest:");
			}
		}
		fertig[2] = false;
	}

	/***
	 * inputCheck wenn aktuell kein Burger in der Zusammenstellung ist
	 * @param eingabe user input
	 * @param z Objekt von Zutatenliste fuer printMenu() Methode
	 * @param bestellung arr zu dem potentiell ein neuer Burger hinzugefuegt wird
	 * @param anzahlBurger Anzahl der bisher erstellten Burger
	 * @return	neue Anzahl der erstellten Burger
	 */
	public static void inputMenu(String eingabe, int anzahlBurger, Burger[] bestellung, boolean[] fertig) {
		if(eingabe.contentEquals("menu")){
			ZutatenManager.printMenu();
			fertig[2] = true;
		}
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
		if(eingabe.contentEquals("meine burger")){
			if (anzahlBurger > 0){
				printBestellung(bestellung, anzahlBurger);
				
			} else {
				System.out.println("Deine Bestellung enthaelt noch keine Burger.");
				System.out.println();
			}
			fertig[2] = true;
		}
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
			bestellung[i].printRezept(bestellung[i]);
			System.out.println("");
			System.out.println("");
		}
	}

	public static int inputZutat(String eingabe, int anzahlBurger, Burger[] bestellung, boolean[] fertig) {
		String nummerStr;
		if(eingabe.startsWith("Zutat ")){
			nummerStr = eingabe.substring(6);
			zutatCheck(anzahlBurger, bestellung, fertig, nummerStr);
		} else if(eingabe.contentEquals("ok")){
			anzahlBurger = okCheck(anzahlBurger, bestellung, fertig);
		} else {
			System.out.println();
			System.out.println("Bitte achte darauf, dass du den Befehl \"Zutat\" mit einer Bestellnummer oder \"ok\" verwendest.");
		}
		return anzahlBurger;
	}

	private static int okCheck(int anzahlBurger, Burger[] bestellung, boolean[] fertig) {
		//Uberprueft ob schon ein Broetchen im Burger ist
		if(bestellung[anzahlBurger].istMitBroetchen()){
			fertig[1] = true;
			fertig[2] = true;
			System.out.println("Dein Burger \"" + bestellung[anzahlBurger].getName() + "\" wird aufgenommen.");
			anzahlBurger++;
		} else System.out.println("Dein Burger braucht mindestens ein Broetchen. Bitte fue noch ein dazu.");
		return anzahlBurger;
	}

	private static void zutatCheck(int anzahlBurger, Burger[] bestellung, boolean[] fertig, String nummerStr) {
		int nummer;
		try {
			nummer = Integer.parseInt(nummerStr);
			nummerCheck(anzahlBurger, bestellung, fertig, nummer);
		} catch (Exception e) {
			System.out.println("Bitte nach \"Zutat\" eine Bestellnummer angeben:");
		}
	}

	private static void nummerCheck(int anzahlBurger, Burger[] bestellung, boolean[] fertig, int nummer) {
		//Wenn nummer eine existierende Bestellnummer ist
		if(ZutatenManager.nummerExistiert(nummer)){
			//Wenn Broetchen existiert und ein weiteres Broetchen hinzugefuegt werden soll
			if(bestellung[anzahlBurger].istMitBroetchen() && nummer < 14){
				System.out.println("Dein aktueller Burger hat bereits ein Broetchen.");
				System.out.println("Bitte waehle eine andere Zutat oder fuege den Burger deiner Bestellung hinzu.");
			}else {
				bestellung[anzahlBurger].zutatHinzufuegen(nummer);
				fertig[2] = true;
			}
		} else System.out.println("Bitte eine gueltige Bestellnumer angeben:");
	}

	public static void printBestellung(Burger[] bestellung, int anzahlBurger) {
		for (int i = 0; i < anzahlBurger; i++) {
			System.out.println("No." + (i+1) + "\t" + bestellung[i].getName() + ": " + bestellung[i].toString());
		}
	}
}
