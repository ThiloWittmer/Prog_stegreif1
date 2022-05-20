public class Salat extends Zutaten {
    public Salat(int nummer){
        this.nummer = nummer;
        klassisch = false;
        vegetarisch = false;
        vegan = true;
        switch(nummer){
            case 30:
                name = "Eisbergsalat";
                preis = (float) 0.18;
            case 31:
                name = "Rucolasalat";
                preis = (float) 0.25;
        }
    }

    public int zubereiten(){
        System.out.println(name + " wird gewaschen und geschleudert");
        return 0;
    }

    public float berechneHoehe() {
        return 0;
    }
}
