/**
 * @class Salat = hier werden der einzelnen Salat abgelegt 
 * @extends Die Klasse Salat erbt von der Klasse Zutaten
 */
public class Salat extends Zutaten {
    
    /***
     * Kunstruktor; erzeugt Salat basierend auf der Bestellnummer
     * @param nummer Bestellnummer des Salats
    */
    public Salat(int nummer, String name, float preis, boolean klassisch){
        super(nummer, name, preis, klassisch, true, false);
    }

    /***
     * Gibt Zubereitungsanweisung aus
     * @return Zubereitungszeit(0)
     */
    public int zubereiten(){
        System.out.println(name + " wird gewaschen und geschleudert");
        return 0;
    }

    public float berechneHoehe() {
        return 0f;
    }
}
