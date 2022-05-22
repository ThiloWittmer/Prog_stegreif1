public class Salat extends Zutaten {
    public Salat(int nummer){
        this.nummer = nummer;
        vegetarisch = false;
        vegan = true;
        switch(nummer){
            case 30:
            klassisch = true;
                name = "Eisbergsalat";
                preis = (float) 0.18;
                break;
            case 31:
            klassisch = false;
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
