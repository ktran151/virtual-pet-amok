package vpamok;

public class OCat extends OrganicPet {
	static int pooBox = 0;

	public OCat(String name, String description) {
		super(name, description);

	}

	public int getPooBox() {
		return pooBox;
	}

	public void pooInBox() {
		pooBox += 10;
	}

}
