package vpamok;

import java.util.Scanner;

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
		shelter.addPet("Georgie", new ODog("Georgie", "shaggy hair"));
		shelter.addPet("Stripes", new SymCat("Stripes", "racing stripes"));
		shelter.addPet("Scrappy", new SymDog("Scrappy", "Razor sharp teeth"));

		System.out.println("You now have " + cat1.getName() + " in your shelter!");
		System.out.println(
				"It seems there are a few other pets that have found their way in as well. (some of which seem to be robotic...)");
		System.out.println("Good luck and try to keep the pets alive!");

		input.close();
	}
}
