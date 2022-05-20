public class Gemuese extends Zutaten {
    private int scheibenDicke, scheibenAnzahl;

    public Gemuese(int nummer){
        this.nummer = nummer;
		switch(nummer) {
		case 40: 
			name = "Tomate";
			preis = (float) 0.25;
			klassisch = false;
			vegetarisch = false;
			vegan = true;
            scheibenDicke = 3;
            scheibenAnzahl = 3;
		case 41: 
			name = "Salzgurke";
			preis = (float) 0.15;
			klassisch = false;
			vegetarisch = false;
			vegan = true;
            scheibenDicke = 2;
            scheibenAnzahl = 4;
		case 42: 
			name = "Rote Zwiebelringe";
			preis = (float) 0.08;
			klassisch = false;
			vegetarisch = false;
			vegan = true;
            scheibenDicke = 2;
            scheibenAnzahl = 5;
		case 43: 
			name = "Jalapeno-Ringe";
			preis = (float) 0.08;
			klassisch = false;
			vegetarisch = false;
			vegan = true;
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
