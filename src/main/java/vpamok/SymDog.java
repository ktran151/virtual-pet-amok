package vpamok;

public class SymDog extends SymPet implements Walking {

	public SymDog(String name, String description) {
		super(name, description);
		rust = 0;
	}

	@Override
	public void walk() {
		gainHappy(15);
	}

}
