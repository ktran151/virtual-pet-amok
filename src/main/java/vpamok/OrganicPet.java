package vpamok;

public class OrganicPet extends VirtualPet {
	protected int hunger;
	protected int thirst;
	protected int poo;

	public int getHunger() {
		return hunger;
	}

	public int getThirst() {
		return thirst;
	}

	public int getPoo() {
		return poo;
	}

	public OrganicPet(String name, String description) {
		super(name, description);
		this.hunger = 50;
		this.thirst = 50;
	}

	public void loseHPIfSubOptimal() {
		if (poo > 30) {
			System.out.println(getName() + " is filthy! \n-10HP");
			loseHP();
		}
		if (hunger <= 0 || thirst <= 0) {
			System.out.println(getName() + " requires sustenance! \n-10HP");
			loseHP();
		}
	}

	public void feed() {
		hunger -= 20;
	}

	public void drink() {
		thirst -= 20;
	}

	@Override
	public void tick() {
		happiness -= 10;
		poo += 10;
		hunger += 15;
		thirst += 10;
		loseHPIfSubOptimal();
		if (health <= 0) {
			die();
		}
	}

	@Override
	public String toString() {
		return getName() + "\t  |" + getHealth() + " \t| " + getHappiness() + "    \t| " + getHunger() + "    | "
				+ getThirst() + "    |   X   ||";
	}

}
