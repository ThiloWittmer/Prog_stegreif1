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
    public Bratling(int nummer, String name, float preis, boolean klassisch, boolean vegetarisch, boolean vegan, int hoehe, int bratzeit){
        super(nummer, name, preis, klassisch, vegan, vegetarisch);
		this.hoehe = hoehe;
		this.bratzeit = bratzeit;
	}

	/***
	 * Zubereiung berechnet Bratzeit
	 * @return bratzeit = bratzeit pro Seite
	 */
    public int zubereiten() {
		String min;
		if(bratzeit/60/2 > 1) {
			min = "Minuten";
		} else min = "Minute";
		System.out.println(name + " von jeder Seite " + bratzeit/60/2 + " " + min + " und " + ((bratzeit % 60)/2) + " Sekunden grillen.");
		return  bratzeit;
	}


	/***
	 * @return h = neu berechnete Hoehe mittels der Bratzeit
	 */
	public float berechneHoehe() {
		float h;
		h = hoehe - (bratzeit/60.0f * (hoehe * 0.035f));
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
