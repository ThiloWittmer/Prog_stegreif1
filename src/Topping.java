
public class Topping extends Zutaten{
	private int herstellungszeit;
	private Zubereitungsart zubereitungsart;
	
	public Topping(int nummer, String name, float preis, boolean klassisch, boolean vegan, boolean vegetarisch, int herstellungszeit, Zubereitungsart zubereitungsart) {
		super(nummer, name, preis, klassisch, vegan, vegetarisch);
		this.herstellungszeit = herstellungszeit;
		this.zubereitungsart = zubereitungsart;
	}

	@Override
	public int zubereiten() {
		String ausgabe;
		ausgabe = "Topping " + name + " " + zubereitungsart.getArt() + " und Burger damit belegen.";
		System.out.println(ausgabe);
		return herstellungszeit+5;
	}

	@Override
	public float berechneHoehe() {
		return 0f;
	}
	
	
}
