package vpamok;

public class SymPet extends VirtualPet {

	protected int rust;

	public int getRust() {
		return rust;
	}

	public SymPet(String name, String description) {
		super(name, description);
		rust = 0;
	}

	public void decreaseHealthFromRust() {
		if (rust >= 30) { // TODO put condition in tick?
			health -= 15;
		}
	}

	public void giveOil() {
		if (rust > 20) {
			rust -= 20;
		} else {
			rust = 0;
		}
	}

	@Override
	public void tick() {
		rust += 10;
	}
}
