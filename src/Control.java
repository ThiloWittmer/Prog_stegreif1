import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;

public class Control {

	public static void main(String[] args) {
		int anzahlBurger = 0;
		boolean[] fertig = {false, false}; //fertig[0] fuer gesamte Bestellung und fertig[1] fuer Burger Zusammenstellung
		Zutatenliste z = new Zutatenliste();
		Burger[] bestellung = new Burger[10];
		String eingabe;
		Scanner sc = new Scanner(System.in);

		System.out.println("You`ll never burger alone - Create your Burger");
		System.out.println("Mit \"menu\" kannst du dir alle zur Verfügung stehenden Zutaten anzeigen lassen.");
		System.out.println("Mit \"neuer Burger\" und einem Namen dahinter kannst du dir einen neuen Burger mit einem Namen erstellen.");
		eingabe = sc.next();
		
		anzahlBurger = inputCheck1(eingabe, z, anzahlBurger, bestellung, fertig);


		System.out.println("Bitte gib die " + bestellung[anzahlBurger-1].getAnzahlZutaten + ". Zutat an:");
	}

	/***
	 * inputCheck wenn aktuell kein Burger in der Zusammenstellung ist
	 * @param eingabe user input
	 * @param z Objekt von Zutatenliste fuer printMenu() Methode
	 * @param bestellung arr zu dem potentiell ein neuer Burger hinzugefuegt wird
	 * @param anzahlBurger Anzahl der bisher erstellten Burger
	 * @return	neue Anzahl der erstellten Burger
	 */
	public static int inputCheck1(String eingabe, Zutatenliste z, int anzahlBurger, Burger[] bestellung, boolean[] fertig) {
		if(eingabe.contentEquals("menu")){
			z.printMenu();
		}
		if(eingabe.startsWith("neuer Burger")){
			String name;
			name = eingabe.substring(13);
			bestellung[anzahlBurger] = new Burger(name);
			anzahlBurger++;
			System.out.println("Du stellst einen neuen Burger zusammen.");
			System.out.println("Mit \"zutat\" und der jeweiligen Nummer kannst du eine Zutat auswählen.");
			System.out.println("Du solltest mindestens ein Broetchen auswaehlen und darfst ansonsten bis zu 8 weitere Zutaten waehlen.");
			System.out.println("Mit \"ok\" kannst du deine Zusammenstellung abschließen.");
		}
		if(eingabe.contentEquals("bestellen")){
			if(anzahlBurger > 0){
				fertig[0] = true;
				System.out.println("Ihre Burger werden frisch zubereitet.");
				System.out.println("Hier nochmal ein Uebersicht ihrer Bestellung:");
				printBestellung(bestellung);
			} else {
				System.out.println("Sie haben keine Burger zusammengestellt. Ihre Bestellung wird abgebrochen.");
				fertig[0] = true;
			}
		}
		return anzahlBurger;
	}

	public static void inputCheck2(String eingabe, int anzahlBurger, Burger[] bestellung, boolean[] fertig) {
		int nummer;
		String nummerStr;
		nummerStr = eingabe.substring(6);
		nummer = Integer.parseInt(nummerStr);
	}

	public static void printBestellung(Burger[] bestellung) {
		int i = 1;
		for (Burger burger : bestellung) {
			System.out.println("No." + i + "\t" + burger.toString());
			i++;
		}
	}
}
