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

	public void loseHPWhenUnclean() {
		if (poo > 30) {
			loseHP();
		}
	}

	public void feed(String food) {
		hunger -= 30;
	}

	public void drink(String drink) {
		thirst -= 30;
	}

	@Override
	public void tick() {
		happiness -= 10;
		poo += 10;
		hunger += 15;
		thirst += 10;
	}

}
