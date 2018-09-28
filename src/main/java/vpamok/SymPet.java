package vpamok;

public class SymPet extends VirtualPet {

	int rust;

	public int getRust() {
		return rust;
	}

	public SymPet(String name, String description) {
		super(name, description);
		rust = 0;
	}

	@Override
	public void tick() {
		rust += 10;
	}
}
