/**
 * @class Salat = hier werden der einzelnen Salat abgelegt 
 * @extends Die Klasse Salat erbt von der Klasse Zutaten
 */
public class Salat extends Zutaten {
    
    /***
     * Kunstruktor; erzeugt Salat basierend auf der Bestellnummer
     * @param nummer Bestellnummer des Salats
    */
    public Salat(int nummer){
        this.nummer = nummer;      
        vegetarisch = true;
        vegan = true;
        
        
        /***
         * Die Zutaten werden mit Nummer unterschieden - zwischen 30 und 31 der Salat 
         * Je nach Nummer wird der jeweilige Salat in einem Case ausgelesen und in der Klasse Burger im Array zutaten gespeichert
         * @param nummer
         */
        
        switch(nummer){
            case 30:
            klassisch = true;
                name = "Eisbergsalat";
                preis = 0.18f;
                break;
            case 31:
            klassisch = false;
                name = "Rucolasalat";
                preis = 0.25f;
        }
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
