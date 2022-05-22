import java.util.Scanner;

public class Control {

	public static void main(String[] args) {
		int anzahlBurger = 0;
		Zutatenliste z = new Zutatenliste();
		Burger[] bestellung = new Burger[10];
		String eingabe;
		Scanner sc = new Scanner(System.in);

		System.out.println("You`ll never burger alone - Create your Burger");
		System.out.println("Mit \"menu\" kannst du dir alle zur Verfügung stehenden Zutaten anzeigen lassen.");
		System.out.println("Mit \"neuer Burger\" und einem Namen dahinter kannst du dir einen neuen Burger mit einem Namen erstellen.");
		eingabe = sc.next();
		
		anzahlBurger = inputCheck1(eingabe, z, bestellung, anzahlBurger);
	}

	public static int inputCheck1(String eingabe, Zutatenliste z, Burger[] bestellung, int anzahlBurger) {
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
		//if bestellen
		return anzahlBurger;
	}

}
