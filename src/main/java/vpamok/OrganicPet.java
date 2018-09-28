package vpamok;

public class OrganicPet extends VirtualPet {
	int hunger;
	int thirst;
	int poo;

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
			health -= 20;
		}

	}

	public void feed(String food) {
		hunger -= 30;
	}

	public void drink(String drink) {
		thirst -= 30;
	}

}
