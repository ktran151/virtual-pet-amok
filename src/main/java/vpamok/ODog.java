package vpamok;

public class ODog extends OrganicPet {

	public ODog(String name, String description) {
		super(description, name);
		poo = 0;
	}

	public void walk() {
		happiness += 15;
		poo -= 20;
	}

	public int getPoo() {
		return poo;
	}

	public void cleanCage() {
		poo = 0;

	}

}
