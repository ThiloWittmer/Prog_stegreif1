
public abstract class Zutaten {
	int nummer;
	String name;
	float preis;
	boolean klassisch;
	boolean vegan;
	boolean vegetarisch;
	
	public abstract int zubereiten();
	public abstract float berechneHoehe();
	
	
	public String toString() {
		return "Zutaten [nummer=" + nummer + ", name=" + name + ", preis=" + preis + ", klassisch=" + klassisch
				+ ", vegan=" + vegan + ", vegetarisch=" + vegetarisch + "]";
	}
	public int getNummer() {
		return nummer;
	}
	public String getName() {
		return name;
	}
	public float getPreis() {
		return preis;
	}
	public boolean isKlassisch() {
		return klassisch;
	}
	public boolean isVegan() {
		return vegan;
	}
	public boolean isVegetarisch() {
		return vegetarisch;
	}
}
