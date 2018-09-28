package vpamok;

public class SymDog extends SymPet {

	public SymDog(String name, String description) {
		super(name, description);
		rust = 0;
	}

	public void decreaseHealthFromRust() {
		if (rust >= 30) { // TODO put condition in tick?
			health -= 15;
		}

	}

}
