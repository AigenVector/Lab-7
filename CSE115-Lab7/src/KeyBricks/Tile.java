package KeyBricks;

public class Tile {
	private Character _c;

	public Tile(Character c) {
		_c = c;
	}

	public Character getCharacter() {
		return _c;
	}

	public Character remove() {
		return null;
	}

	public String toString() {
		return _c.toString();
	}

}
