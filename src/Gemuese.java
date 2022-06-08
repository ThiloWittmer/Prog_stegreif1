/***
 * @class Gemuese - Werte Definition der verschiedenn Gemuesesorten
 * @parameter scheibenDicke - Dicke einer Gemuesescheibe
 * @parameter scheibenAnzahl - Anzahl der Scheiben pro Gemuese Zutat
 */
public class Gemuese extends Zutaten {
    private int scheibenDicke, scheibenAnzahl;

    /***
     * Kunstruktor; erzeugt Gemuese basierend auf der Bestellnummer
     * @param nummer Bestellnummer des Broetchens
     */
    public Gemuese(int nummer, String name, float preis, boolean klassisch, int scheibenDicke, int scheibenAnzahl){
        super(nummer, name, preis, klassisch, true, false);
        this.scheibenDicke = scheibenDicke;
        this.scheibenAnzahl = scheibenAnzahl;
    }

    /***
     * Gibt Zubereitungsanweisung aus
     * @return Zubereitungszeit
     */
    public int zubereiten() {
        System.out.println(name + " wird gewaschen");
        for(int i=1; i <= scheibenAnzahl; i++){
            System.out.println(i + ". Scheibe mit " + scheibenDicke + "mm schneiden");
        }
        return scheibenAnzahl;
    }

    /***
     * @return die Hoehe des Gemuese
     */
    public float berechneHoehe() {
        return (float) scheibenAnzahl * scheibenDicke;
    }

    public int getScheibenDicke() {
        return scheibenDicke;
    }

    public int getScheibenAnzahl() {
        return scheibenAnzahl;
    }
}
