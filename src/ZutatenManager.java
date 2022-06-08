import java.util.Iterator;
import java.util.LinkedList;

/***
 * @class Hier werden alle Zutaten verwaltet, bei Bedarf neu erzeugt und
 * es besteht die Option zu kontrollieren, ob eine Bestellnumer existiert
 */
public class ZutatenManager {
	private LinkedList<Zutaten> alleZutaten;
    //private Zutaten[] alleZutaten = new Zutaten[22];
    
    public ZutatenManager(){
    	alleZutaten = new LinkedList<Zutaten>();
    	alleZutaten.add(new Broetchen(10, "Hamburger (Standard)", 0.85f, true, true, false, 27, 90));
    	alleZutaten.add(new Broetchen(11, "Hamburger Sesam", 0.95f, true, true, false, 28, 90));
    	
    	/**
        alleZutaten[0] = new Broetchen(10, "Hamburger (Standard)", 0.85f, true, true, false, 27, 90);
        alleZutaten[1] = new Broetchen(11, "Hamburger Sesam", 0.95f, true, true, false, 28, 90);
        alleZutaten[2] = new Broetchen(12, "Vegan-Broetchen", 0.55f, false, true, false, 34, 240);
        alleZutaten[3] = new Broetchen(13, "Ciabatta", 0.45f, false, true, false, 41, 330);
        alleZutaten[4] = new Bratling(20, "Rindfleisch (Original)", 1.85f, true, false, false, 25, 270);
        alleZutaten[5] = new Bratling(21, "Haenchenfleisch gegrillt", 1.15f, false, false, false, 11, 180);
        alleZutaten[6] = new Bratling(22, "Falafel-Bratling", 1.45f, false, true, false, 21, 210);
        alleZutaten[7] = new Bratling(23, "Gemuese-Bratling", 1.75f, false, true, false, 25, 240);
        alleZutaten[8] = new Salat(30, "Eisbergsalat", 0.18f, true);
        alleZutaten[9] = new Salat(31, "Rucolasalat", 0.25f, false);
        alleZutaten[10] = new Gemuese(40, "Tomate", 0.25f, true, 3, 3);
        alleZutaten[11] = new Gemuese(41, "Salzgurke", 0.15f, true, 2, 4);
        alleZutaten[12] = new Gemuese(42, "Rote Zwiebelringe", 0.08f, false, 2, 5);
        alleZutaten[13] = new Gemuese(43, "Jalapeno-Ringe", 0.08f, false, 2, 5);
        alleZutaten[14] = new Sauce(50, "Ketchup", 0.1f, true, true, false, 5, "normal");
        alleZutaten[15] = new Sauce(51, "Sandwich-Sauce", 0.15f, true, true, false, 10, "normal");
        alleZutaten[16] = new Sauce(52, "Chili-Sauce", 0.25f, false, true, false, 8, "scharf");
        alleZutaten[17] = new Sauce(53, "Honig-Senf-Sauce", 0.18f, false, true, false, 8, "suess");
        alleZutaten[18] = new Topping(155, "Candy Bacon (Klassik)", 0.79f, true, false, false, 230, Zubereitungsart.BRATEN);
        alleZutaten[19] = new Topping(156, "Käse Cracker", 0.59f, false, false, true, 40, Zubereitungsart.FRITTIEREN);
        alleZutaten[20] = new Topping(157, "Coleslaw Rot", 0.39f, false, true, false, 900, Zubereitungsart.KOCHEN);
        alleZutaten[21] = new Topping(158, "Pfifferlinge mit Salbei", 1.59f, false, true, false, 180, Zubereitungsart.BRATEN);
        */
    }

    /***
     * Methode, um neue  Zutaten zu erzeugen
     * @param nummer Bestellnummer der Zutat
     * @return Objekt der passenden Zutat// null wenn keine Zutat gefunden
     */
    public Zutaten getZutat(int nummer) {
    	Iterator<Zutaten> zutatenIterator = alleZutaten.iterator();
        Zutaten aktZutat;
        while(zutatenIterator.hasNext()) {
        	aktZutat = zutatenIterator.next();
        	if(aktZutat.getNummer() == nummer) {
        		return aktZutat;
        	}
        }
        return null;
    }

    /***
     * Beschreibung aller Zutaten werden ausgegeben
     */
    public void printMenu() {
        for (Zutaten aktZutat : alleZutaten) {
            System.out.println(aktZutat.toString());
            System.out.println();
        }
    }
}