/***
 * @class Bratling - Werte Definiton der verschiedenen Bratlinge
 * @parameter bratzeit - jeder Bratling hat seine Bratzeit 
 * @parameter hoehe -jeder Bratling hat seine eigene Höhe die sich beim zubereiten neu berechnet
 */

public class Bratling extends Zutaten {
    private int bratzeit;
    private int hoehe;

	/***
	 * Kunstruktor; erzeugt ein Bratling basierend auf der Bestellnummer
	 * @param nummer Bestellnummer des Bratlings
	 */
    public Bratling(int nummer){
        this.nummer = nummer;
		switch(nummer) {
		case 20: 
			name = "Rindfleisch (Original)";
			preis = 1.85f;
			klassisch = true;
			vegetarisch = false;
			vegan = false;
			hoehe = 25;
			bratzeit = 270;
			break;
		case 21: 
			name = "Haenchenfleisch gegrillt";
			preis = 1.15f;
			klassisch = false;
			vegetarisch = false;
			vegan = false;
			hoehe = 11;
			bratzeit = 180;
			break;
		case 22: 
			name = "Falafel-Bratling";
			preis = 1.45f;
			klassisch = false;
			vegetarisch = true;
			vegan = true;
			hoehe = 21;
			bratzeit = 210;
			break;
		case 23: 
			name = "Gemuese-Bratling";
			preis = 1.75f;
			klassisch = false;
			vegetarisch = true;
			vegan = false;
			hoehe = 25;
			bratzeit = 240;
		}
    }

	/***
	 * Zubereiung berechnet Bratzeit
	 * @return bratzeit = bratzeit pro Seite
	 */
    public int zubereiten() {
		System.out.println(name + " von jeder Seite " + bratzeit/60/2 + " Minuten und " + ((bratzeit % 60)/2) + " Sekunden grillen.");
		return  bratzeit;
	}


	/***
	 * @return h = neu berechnete Hoehe mittels der Bratzeit
	 */
	public float berechneHoehe() {
		float h;
		h = hoehe - (bratzeit/60f * (hoehe * 0.035f));
		return h;
	}

	public float getBratzeit() {
		return bratzeit;
	}

	public int getHoehe() {
		return hoehe;
	}

	public float getPreis(){
		return preis;
	}
}
