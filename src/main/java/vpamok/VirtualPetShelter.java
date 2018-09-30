package vpamok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import vpamok.VirtualPet;

public class VirtualPetShelter {

	Map<String, VirtualPet> shelter = new HashMap<String, VirtualPet>();

	boolean allPetsAlive = true;
	private int litterBox = 0;

	public boolean hasNoPets() {
		if (shelter.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public void addPet(String id, VirtualPet petToAdd) {
		shelter.put(id, petToAdd);
	}

	public void removePet(String id) {
		shelter.remove(id);
	}

	public Collection<VirtualPet> allPets() {
		Collection<VirtualPet> petCollection = shelter.values();
		return petCollection;
	}

	public void allPetsPlay() {
		for (Entry<String, VirtualPet> eachPet : shelter.entrySet()) {
			VirtualPet loopedPet = eachPet.getValue();
			loopedPet.play("");
		}
	}

	public void playWithOnePet(String name) {
		VirtualPet playingPet = shelter.get(name);
		playingPet.play("");
		playingPet.play("");
	}

	public VirtualPet fetchPetFromId(String id) {
		return shelter.get(id);
	}

	public void shelterTick() {
		for (Entry<String, VirtualPet> eachPet : shelter.entrySet()) {
			VirtualPet loopedPet = eachPet.getValue();
			loopedPet.tick();
		}
	}

	public void walkDogs() {
		for (VirtualPet eachPet : allPets()) {
			if (eachPet instanceof Walking) {
				((Walking) eachPet).walk();
			}
		}
	}

	public void pooInLitterBox() {
		litterBox += 1;
	}

	public int getLitterBox() {
		return litterBox;
	}

	public void cleanLitterBox() {
		litterBox = 0;
	}

	public void lowerCatHealth() {
		if (litterBox >= 5) {
			for (VirtualPet eachPet : allPets()) {
				if (eachPet instanceof OCat) {
					((OCat) eachPet).loseHP();
				}
			}
		}
	}

	public void oilAllBots() {
		for (VirtualPet eachPet : allPets()) {
			if (eachPet instanceof SymPet) {
				((SymPet) eachPet).giveOil();
			}
		}

	}

}
