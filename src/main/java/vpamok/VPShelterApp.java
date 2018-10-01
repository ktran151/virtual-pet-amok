package vpamok;

import java.util.Scanner;
import java.util.Map.Entry;

public class VPShelterApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		VirtualPetShelter shelter = new VirtualPetShelter();

		// intro/tutorial adding cat
		System.out.println("Welcome to you new Virtual Pet Shelter!!! ");
		System.out.println("Enter a name for your first pet (cat)!");
		String name = input.nextLine();
		System.out.println("Enter a description of the cat");
		String description = input.nextLine();

		// start user with one pet of each pet
		VirtualPet cat1 = new OCat(name, description);
		shelter.addPet(name, cat1);
		shelter.addPet("George", new ODog("George", "shaggy hair"));
		shelter.addPet("Stripes", new SymCat("Stripes", "racing stripes"));
		shelter.addPet("Scrappy", new SymDog("Scrappy", "Razor sharp teeth"));

		System.out.println("You now have " + cat1.getName() + " in your shelter!");
		System.out.println(
				"It seems there are a few other pets that have found their way in as well. (some of which seem to be robotic...)");
		System.out.println("Good luck and try to keep the pets alive!");

		// GameLoop
		do {
			displayPets(shelter);
			displayMainMenu();
			String mainChoice = input.nextLine();
			menuChoice(shelter, mainChoice);
			shelter.shelterTick();
		} while (!shelter.hasNoPets());

		input.close();
	}

	private static void menuChoice(VirtualPetShelter shelter, String playerChoice) {
		Scanner in = new Scanner(System.in);
		switch (playerChoice) {
		case "1":
			displayOrganicSubMenu();
			String newChoice = in.nextLine();
			organicChoice(shelter, newChoice);
			break;
		case "2":
			shelter.oilAllBots();
			break;
		case "3":
			shelter.allPetsPlay();
			break;
		case "4":
			System.out.println("Which pet would you like to play with?");
			System.out.println("(Caps matters)");
			displayPetsWithDescriptions(shelter);
			String petName = in.nextLine();
			shelter.playWithOnePet(petName);
			break;
		case "5":
			displayShelterSubMenu();
			String roboChoice = in.nextLine();
			ShelterChoice(shelter, roboChoice);
			break;
		case "6":
			System.out.println("Alright, these pets are going in the trash");
			System.exit(0);
			break;
		default:
			in.close();
		}
	}

	private static void ShelterChoice(VirtualPetShelter shelter, String roboChoice) {
		Scanner input = new Scanner(System.in);
		switch (roboChoice) {
		case "1":
			System.out.println("Please enter the name of the Dog");
			String id = input.nextLine();
			System.out.println("Please enter description");
			String description = input.nextLine();
			VirtualPet petToAdd = new ODog(id, description);
			shelter.addPet(id, petToAdd);
			System.out.println(id + " has been admitted to the shelter");
			break;
		case "2":
			System.out.println("Please enter the name of the Cat");
			String catId = input.nextLine();
			System.out.println("Please enter description");
			String catDescription = input.nextLine();
			VirtualPet catToAdd = new OCat(catId, catDescription);
			shelter.addPet(catId, catToAdd);
			System.out.println(catId + " has been admitted to the shelter");
			break;
		case "3":
			System.out.println("Please enter the name of the robotic Dog");
			String roboDogId = input.nextLine();
			System.out.println("Please enter description");
			String RoboDogDescription = input.nextLine();
			VirtualPet roboDogToAdd = new SymDog(roboDogId, RoboDogDescription);
			shelter.addPet(roboDogId, roboDogToAdd);
			System.out.println(roboDogId + " has been admitted to the shelter");
			break;
		case "4":
			System.out.println("Please enter the name of the robotic cat");
			String roboCatid = input.nextLine();
			System.out.println("Please enter description");
			String roboCatDescription = input.nextLine();
			VirtualPet roboCatToAdd = new SymCat(roboCatid, roboCatDescription);
			shelter.addPet(roboCatid, roboCatToAdd);
			System.out.println(roboCatid + " has been admitted to the shelter");
			break;
		case "5":
			System.out.println("Which pet would you like to adopt?");
			displayPets(shelter);
			String name = input.nextLine();
			shelter.removePet(name);
			System.out.println(name + " has been adopted! :)");
			break;
		default:
			displayMainMenu();
			String mainChoice = input.nextLine();
			menuChoice(shelter, mainChoice);
			input.close();
		}
	}

	private static void organicChoice(VirtualPetShelter shelter, String newChoice) {
		switch (newChoice) {
		case "1":
			shelter.feedOPets();
			break;
		case "2":
			shelter.waterOPets();
			break;
		case "3":
			shelter.cleanODogs();
			break;
		case "4":
			shelter.cleanLitterBox();
			break;
		default:
			displayMainMenu();
			Scanner input = new Scanner(System.in);
			String subChoice = input.nextLine();
			menuChoice(shelter, subChoice);
		}
	}

	private static void displayMainMenu() {
		System.out.println("1. Organic Pet options");
		System.out.println("2. Oil Machine Pets");
		System.out.println("3. Pets free play time");
		System.out.println("4. Play with a pet");
		System.out.println("5. Shelter Options");
		System.out.println("6. Quit");
	}

	private static void displayOrganicSubMenu() {
		System.out.println("1. Feed all");
		System.out.println("2. Give all pets water");
		System.out.println("3. Clean all dogs' cages");
		System.out.println("4. Clean litterbox");
		System.out.println("5. Go back");
	}

	private static void displayShelterSubMenu() {
		System.out.println("1. Admit organic dog");
		System.out.println("2. Admit organic cat");
		System.out.println("3. Admit robotic dog");
		System.out.println("4. Admit robotic cat");
		System.out.println("5. Adopt Pet");
		System.out.println("6. Go back");
	}

	// displays pets in shelter
	public static void displayPets(VirtualPetShelter thisShelter) {
		System.out.println("**********************************************************");
		System.out.println("Name      | Health | Happiness | Hunger | Thirst | Rust ||");
		System.out.println("----------|--------|-----------|--------|-------|-------||");
		for (VirtualPet loopedPet : thisShelter.allPets()) {
			System.out.println(loopedPet);
		}
		System.out.println("**********************************************************\n");
		System.out.println("Shelter Litterbox: " + thisShelter.getLitterBox());
	}

	public static void displayPetsWithDescriptions(VirtualPetShelter thisShelter) {
		for (Entry<String, VirtualPet> eachPet : thisShelter.shelter.entrySet()) {
			VirtualPet loopedPet = eachPet.getValue();
			System.out.println(loopedPet.getName() + ": " + loopedPet.description);
		}

	}
}
