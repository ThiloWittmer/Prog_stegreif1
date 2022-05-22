import java.util.Scanner;

public class Control {

	public static void main(String[] args) {
		int anzahlBurger = 0;
		boolean[] fertig = {false, true}; //fertig[0] fuer gesamte Bestellung und fertig[1] fuer Burger Zusammenstellung und fertig[2] ob gerade ein Burger in Zusammenstellung ist
		Zutatenliste z = new Zutatenliste();
		Burger[] bestellung = new Burger[10];
		String eingabe;
		Scanner sc = new Scanner(System.in);
		int zaehler = 1;

		System.out.println("You`ll never burger alone - Create your Burger");

		while(!fertig[0]){
			System.out.println("Mit \"menu\" kannst du dir alle zur Verfügung stehenden Zutaten anzeigen lassen.");
			System.out.println("Mit \"neuer Burger\" und einem Namen dahinter kannst du dir einen neuen Burger mit einem Namen erstellen.");
			System.out.println("Mit \"meine burger\" kannst du dir deine bisherige Bestellung anschauen.");
			System.out.println("Mit \"bestellen\" kannst du deine Bestellung abschliessen.");
			eingabe = sc.nextLine();
			inputCheck1(eingabe, z, anzahlBurger, bestellung, fertig);
			
			while(!fertig[1]){
				if(bestellung[anzahlBurger].getAnzahlZutaten()==8 && !bestellung[anzahlBurger].istMitBroetchen()){
					System.out.println("Dein Burger hat fast die maximale Anzahl an Zutaten erreicht und du hast noch kein Broetchen.");
					System.out.println("Bitte waehle eins mit \"Zutat 11\", \"Zutat 12\", \"Zutat 13\" oder \"Zutat 14\":");
					eingabe = sc.nextLine();
					anzahlBurger = inputCheck2(eingabe, anzahlBurger, bestellung, fertig);
					System.out.println("Dein Burger \"" + bestellung[anzahlBurger].getName() + "\" wird aufgenommen.");
					anzahlBurger++;
					fertig[1] = true;
				}
				if(bestellung[anzahlBurger].getAnzahlZutaten()==9){
					System.out.println("Dein Burger hat fast die maximale Anzahl an Zutaten erreicht.");
					System.out.println("Dein Burger \"" + bestellung[anzahlBurger].getName() + "\" wird aufgenommen.");
					anzahlBurger++;
					fertig[1] = true;
				}
				System.out.println("Bitte gib die " + zaehler + ". Zutat an:");
				zaehler++;
				eingabe = sc.nextLine();
				if(bestellung[anzahlBurger].istMitBroetchen()){
					//neue Eingabe
				}
				anzahlBurger = inputCheck2(eingabe, anzahlBurger, bestellung, fertig);
			}
			zaehler = 1;
		}
	}

	/***
	 * inputCheck wenn aktuell kein Burger in der Zusammenstellung ist
	 * @param eingabe user input
	 * @param z Objekt von Zutatenliste fuer printMenu() Methode
	 * @param bestellung arr zu dem potentiell ein neuer Burger hinzugefuegt wird
	 * @param anzahlBurger Anzahl der bisher erstellten Burger
	 * @return	neue Anzahl der erstellten Burger
	 */
	public static void inputCheck1(String eingabe, Zutatenliste z, int anzahlBurger, Burger[] bestellung, boolean[] fertig) {
		if(eingabe.contentEquals("menu")){
			z.printMenu();
		}
		if(eingabe.startsWith("neuer Burger")){
			String name;
			name = eingabe.substring(13);
			bestellung[anzahlBurger] = new Burger(name);
			fertig[1] = false;
			System.out.println("Du stellst einen neuen Burger zusammen.");
			System.out.println("Mit \"Zutat\" und der jeweiligen Nummer kannst du eine Zutat auswählen.");
			System.out.println("Du solltest mindestens ein Broetchen auswaehlen und darfst ansonsten bis zu 8 weitere Zutaten waehlen.");
			System.out.println("Mit \"ok\" kannst du deine Zusammenstellung abschließen.");
		}
		if(eingabe.contentEquals("meine burger")){
			printBestellung(bestellung, anzahlBurger);
		}
		if(eingabe.contentEquals("bestellen")){
			if(anzahlBurger > 0){
				fertig[0] = true;
				System.out.println();
				System.out.println("Ihre Burger werden frisch zubereitet.");
				System.out.println("Hier nochmal ein Uebersicht ihrer Bestellung:");
				printBestellung(bestellung, anzahlBurger);
				System.out.println("");
				System.out.println("-------------------------------------------------------------------");
				System.out.println("");

				for (int i=0; i < anzahlBurger; i++) {
					bestellung[i].printRezept(bestellung[i]);
					System.out.println("");
					System.out.println("");
				}
			} else {
				System.out.println("Sie haben keine Burger zusammengestellt. Ihre Bestellung wird abgebrochen.");
				fertig[0] = true;
			}
		}
	}

	public static int inputCheck2(String eingabe, int anzahlBurger, Burger[] bestellung, boolean[] fertig) {
		int nummer;
		String nummerStr;
		if(eingabe.startsWith("Zutat")){
			nummerStr = eingabe.substring(6);
			nummer = Integer.parseInt(nummerStr);
			bestellung[anzahlBurger].zutatHinzufuegen(nummer);
		}
		if(eingabe.contentEquals("ok")){
			fertig[1] = true;
			System.out.println("Dein Burger \"" + bestellung[anzahlBurger].getName() + "\" wird aufgenommen.");
			anzahlBurger++;
		}
		return anzahlBurger;
	}

	public static void printBestellung(Burger[] bestellung, int anzahlBurger) {
		for (int i = 0; i < anzahlBurger; i++) {
			System.out.println("No." + (i+1) + "\t" + bestellung[i].getName() + ": " + bestellung[i].toString());
		}
	}
}
