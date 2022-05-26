/**
 * @class Salat = hier werden der einzelnen Salat abgelegt 
 * @extends Die Klasse Salat erbt von der Klasse Zutaten
 */
public class Salat extends Zutaten {
    public Salat(int nummer){
        this.nummer = nummer;      
        vegetarisch = true;
        vegan = true;
        
        
        /***
         * Die Zutaten werden mit Nummer unterschieden - zwischen 30 und 31 der Salat 
         * Je nach Nummer wird der jeweilige Salat in einem Case ausgelesen und in der Klasse Burger im Array z gespeichert
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

    public int zubereiten(){
        System.out.println(name + " wird gewaschen und geschleudert");
        return 0;
    }

    public float berechneHoehe() {
        return 0f;
    }
}
