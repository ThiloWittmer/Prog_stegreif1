/***
 * @class Gemuese - Werte Definition der verschiedenn Gemuesesorten
 * @parameter scheibenDicke - Dicke einer Gemuesescheibe
 * @parameter scheibenAnzahl - Anzahl der Scheiben pro Gemuese Zutat
 */
public class Gemuese extends Zutaten {
    private int scheibenDicke, scheibenAnzahl;

    public Gemuese(int nummer){
        this.nummer = nummer;
        vegetarisch = true;
		vegan = true;
		switch(nummer) {
		case 40: 
			name = "Tomate";
			preis = 0.25f;
			klassisch = true;
            scheibenDicke = 3;
            scheibenAnzahl = 3;
            break;
		case 41: 
			name = "Salzgurke";
			preis = 0.15f;
			klassisch = true;
            scheibenDicke = 2;
            scheibenAnzahl = 4;
            break;
		case 42: 
			name = "Rote Zwiebelringe";
			preis = 0.08f;
			klassisch = false;
            scheibenDicke = 2;
            scheibenAnzahl = 5;
            break;
		case 43: 
			name = "Jalapeno-Ringe";
			preis = 0.08f;
			klassisch = false;
            scheibenDicke = 2;
            scheibenAnzahl = 5;
        }
    }

    public int zubereiten() {
        System.out.println(name + " wird gewaschen");
        for(int i=1; i <= scheibenAnzahl; i++){
            System.out.println(i + ". Scheibe mit " + scheibenDicke + "mm schneiden");
        }
        return scheibenAnzahl;
    }

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
