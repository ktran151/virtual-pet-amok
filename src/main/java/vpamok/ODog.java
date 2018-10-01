package vpamok;

public class ODog extends OrganicPet implements Walking {

	public ODog(String name, String description) {
		super(name, description);
//		this.poo = getPoo();
//		this.happiness = getHappiness();
	}

	@Override
	public void walk() {
		gainHappy(15);
		poo -= 20;
	}

	public void cleanCage() {
		poo = 0;
	}

}
