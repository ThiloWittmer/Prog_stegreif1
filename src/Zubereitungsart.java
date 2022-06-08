
public enum Zubereitungsart {
	BRATEN("Braten"),
	KOCHEN("Kochen"),
	FRITTIEREN("Frittieren");
	
	private String art;
	
	private Zubereitungsart(String art) {
		this.art = art;
	}

	public String getArt() {
		return art;
	}
	
}
