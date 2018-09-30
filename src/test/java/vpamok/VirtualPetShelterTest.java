package vpamok;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import vpamok.VirtualPet;

public class VirtualPetShelterTest {
	VirtualPetShelter underTest = new VirtualPetShelter();
	VirtualPet dummyPet = new VirtualPet("james", "");

	@Test
	public void shouldStartEmptyShelter() {
		boolean isEmpty = underTest.hasNoPets();
		assertEquals(true, isEmpty);
	}

	@Test
	public void shouldAddPet() {
		underTest.addPet("", dummyPet);
		boolean isEmpty = underTest.hasNoPets();
		assertEquals(false, isEmpty);
	}

	@Test
	public void shouldRemovePet() {
		underTest.addPet("", dummyPet);
		underTest.removePet("");
		boolean isEmpty = underTest.hasNoPets();
		assertEquals(true, isEmpty);
	}

	@Test
	public void petsShouldPlay() {
		underTest.addPet("", dummyPet);
		underTest.allPetsPlay();
		int dummyHappiness = dummyPet.getHappiness();
		assertEquals(60, dummyHappiness);
	}

	@Test
	public void shouldGetPet() {
		underTest.addPet("123", dummyPet);
		VirtualPet tempPet = underTest.fetchPetFromId("123");
		assertEquals(dummyPet, tempPet);
	}

	@Test
	public void shouldPrintPetsInShelter() {
		underTest.addPet("1", dummyPet);
		for (VirtualPet eachPet : underTest.allPets()) {
			String loopedPet = eachPet.getName();
			assertEquals("james", loopedPet);
		}
	}

	@Test
	public void shouldGetPetFromId() {
		String petsName = dummyPet.getName();
		underTest.addPet(petsName, dummyPet);
		VirtualPet actual = underTest.fetchPetFromId(petsName);
		assertEquals("james", actual.getName());
	}

	@Test
	public void checkPlayWithOne() {
		underTest.addPet("", dummyPet);
		underTest.playWithOnePet("");
		int afterPlay = dummyPet.getHappiness();
		assertEquals(70, afterPlay);
	}

	@Test
	public void shouldFillCatBox() {
		underTest.pooInLitterBox();
		int result = underTest.getLitterBox();
		assertEquals(1, result);
	}

	@Test
	public void shouldCleanLitterBox() {
		underTest.pooInLitterBox();
		underTest.cleanLitterBox();
		int result = underTest.getLitterBox();
		assertEquals(0, result);
	}

	@Test
	public void shouldLowerCatHealthFromLitterbox() {
		VirtualPet dummyCat = new OCat("", "");
		underTest.addPet("", dummyCat);
		underTest.pooInLitterBox();
		underTest.pooInLitterBox();
		underTest.pooInLitterBox();
		underTest.pooInLitterBox();
		underTest.pooInLitterBox();
		underTest.lowerCatHealth();
		int result = dummyCat.getHealth();
		assertEquals(90, result);
	}

	@Test
	public void shouldNotLowerDogHealth() {
		SymDog dummyDog = new SymDog("", "");
		underTest.addPet("", dummyDog);
		underTest.lowerCatHealth();
		int result = dummyDog.getHealth();
		assertEquals(100, result);
	}

	@Test
	public void shouldWalkDogs() {
		VirtualPet dummyDog1 = new SymDog("", "");
		underTest.addPet("", dummyDog1);
//		VirtualPet dummyDog2 = new ODog("", "");
//		underTest.addPet("", dummyDog2);
		underTest.walkDogs();
		int result = dummyDog1.getHappiness();
		assertEquals(65, result);
	}

	@Test
	public void shouldOilRobots() {
		SymPet dummyDog1 = new SymDog("", "");
		underTest.addPet("", dummyDog1);
		dummyDog1.tick();
		dummyDog1.tick();
		underTest.oilAllBots();
		int result = dummyDog1.getRust();
		assertEquals(0, result);
	}

}
