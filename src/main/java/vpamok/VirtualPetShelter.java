package vpamok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import vpamok.VirtualPet;

public class VirtualPetShelter {

	public Map<String, VirtualPet> shelter = new HashMap<String, VirtualPet>();

	boolean allPetsAlive = true;
	private int litterBox = 0;

	public int numberOfPets() {
		return shelter.size();
	}

	public boolean hasNoPets() {
		return shelter.isEmpty();
	}

	public void addPet(String id, VirtualPet petToAdd) {
		shelter.put(id, petToAdd);
	}

	public void removePet(String id) {
		shelter.remove(id);
	}

	public Collection<VirtualPet> allPets() {
		return shelter.values();
	}

	public void allPetsPlay() {
		for (Entry<String, VirtualPet> eachPet : shelter.entrySet()) {
			VirtualPet loopedPet = eachPet.getValue();
			loopedPet.play();
		}
	}

	public void playWithOnePet(String name) {
		VirtualPet playingPet = shelter.get(name);
		playingPet.play();
		playingPet.play();
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

//***************************************************
	// litterBox methods
	public void pooInLitterBox() {
		litterBox += 1;
	}

	public int getLitterBox() {
		return litterBox;
	}

	public void cleanLitterBox() {
		litterBox = 0;
	}

	// AMOK methods
	// ***************************************************
	public void walkDogs() {
		for (VirtualPet eachPet : allPets()) {
			if (eachPet instanceof Walking) {
				((Walking) eachPet).walk();
			}
		}
	}

	public void feedOPets() {
		for (VirtualPet eachPet : allPets()) {
			if (eachPet instanceof OrganicPet) {
				((OrganicPet) eachPet).feed();
			}
		}
	}

	public void waterOPets() {
		for (VirtualPet eachPet : allPets()) {
			if (eachPet instanceof OrganicPet) {
				((OrganicPet) eachPet).drink();
			}
		}
	}

	public void cleanODogs() {
		for (VirtualPet eachPet : allPets()) {
			if (eachPet instanceof ODog) {
				((ODog) eachPet).cleanCage();
			}
		}
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
