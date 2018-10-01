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
		if (rust >= 30) {
			System.out.println(getName() + " is rusty! \n-10HP");
			loseHP();
			loseHP();
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
		gainHappy(-10);
		decreaseHealthFromRust();
		if (getHealth() <= 0) {
			die();
		}
	}

	@Override
	public String toString() {
		return getName() + "\t  |" + getHealth() + " \t| " + getHappiness() + "    \t|   X   |   X   | " + getRust()
				+ "\t||";
	}
}
