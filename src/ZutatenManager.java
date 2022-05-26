/***
 * @class Zutaten - Werte Definiton der Zutaten der OberKlasse
 * @parameter nummer - jede Zutat hat eine Nummer  
 * @parameter name - jede Zutat hat einen Name 
 * @parameter preis - jede Zutat hat einen Preis
 * @parameter klassisch - die Zutat kann klassisch sein
 * @parameter vegan- die Zutat kann vegan sein
 * @parameter vegetarisch - die Zutat kann vegetarisch sein 
 */
public class ZutatenManager {
    private Zutaten[] liste = new Zutaten[18];

    
    public ZutatenManager() {
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
    }

    public Zutaten getZutat(int nummer) {
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
        return liste[0];
    }

    public void printMenu() {
        for (Zutaten aktZutat : liste) {
            System.out.println(aktZutat.toString());
            System.out.println();
        }
    }

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

    public Zutaten[] getListe() {
        return liste;
    }
}
