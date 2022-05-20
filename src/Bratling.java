public class Bratling extends Zutaten {
    private float bratzeit;
    private int hoehe;
    private String bratlingName;

    public Bratling(hoehe){
        this.hoehe = hoehe;
		switch(hoehe) {
		case 25: 
			bratlingName = "Rindfleisch (Original)";
			bratzeit = 4.5;
		case 11: 
			bratlingName = "Haendchenfleisch gegrillt";
			bratzeit = 3.0;
		case 21: 
			bratlingName = "Falafel-Bratling";
			bratzeit = 3.5;
		case 25: 
			bratlingName = "Gemuese-Bratling";
			bratzeit = 4.0;
		}
    }
    
    public float zubereiten() {
        System.out.println(bratlingName + " von jeder Seite " bratzeit + " Minuten grillen.");
    }
}
