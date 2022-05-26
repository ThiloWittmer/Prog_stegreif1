/***
 * @class Hier werden alle Zutaten verwaltet, bei Bedarf neu erzeugt und
 * es besteht die Option zu kontrollieren, ob eine Bestellnumer existiert
 */
public class ZutatenManager {

    /***
     * Methode, um neue  Zutaten zu erzeugen
     * @param nummer Bestellnummer der Zutat
     * @return Objekt der passenden Zutat
     */
    public static Zutaten getZutat(int nummer) {
        switch(nummer){
            case 10,11,12,13: 
                Zutaten broetchen = new Broetchen(nummer);
                return broetchen;
            case 20,21,22,23:
                Zutaten bratling = new Bratling(nummer);
                return bratling;
            case 30,31:
                Zutaten salat = new Salat(nummer);
                return salat;
            case 40,41,42,43:
                Zutaten gemuese = new Gemuese(nummer);
                return gemuese;
            case 50,51,52,53:
                Zutaten sauce = new Sauce(nummer);
                return sauce;
        }
        return null;
    }

    /***
     * Beschreibung aller Zutaten werden ausgegeben
     */
    public static void printMenu() {
        Zutaten[] liste = new Zutaten[18];
        for(int i=0; i<4; i++){
            liste[i] = new Broetchen(i+10);
        }
        for(int i=0; i<4; i++){
            liste[i+4] = new Bratling(i+20);
        }
        for(int i=0; i<2; i++){
            liste[i+8] = new Salat(i+30);
        }
        for(int i=0; i<4; i++){
            liste[i+10] = new Gemuese(i+40);
        }
        for(int i=0; i<4; i++){
            liste[i+14] = new Sauce(i+50);
        }
        for (Zutaten aktZutat : liste) {
            System.out.println(aktZutat.toString());
            System.out.println();
        }
    }

    /***
     * Es wird kontrolliert, ob die mitgegebene Bestellnummer existiert
     * @param nummer Bestllnummer
     * @return true, wenn Bestellnummer existiert
     */
    public static boolean nummerExistiert(int nummer){
        //Einer
        int i = nummer%10;
        //Zehner
        int n = nummer/10;
        switch(n){
            case 1,2,4,5: if(i<4) return true;
            case 3: if (i<2) return true;
        }
        return false;
    }
}