public class Salat extends Zutaten {
    public Salat(int nummer){
        this.nummer = nummer;
        vegetarisch = true;
        vegan = true;
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
