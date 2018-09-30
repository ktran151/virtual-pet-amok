package vpamok;

public class OCat extends OrganicPet {

	public OCat(String name, String description) {
		super(name, description);
	}

	public void pooInBox(VirtualPetShelter shelter) {
		shelter.pooInLitterBox();
	}

}
