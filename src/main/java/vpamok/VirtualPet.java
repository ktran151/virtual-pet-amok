package vpamok;

public class VirtualPet {

	private String name;
	private int happiness;
	private int health;
	private boolean alive;
	private String description;

	public String getName() {
		return name;
	}

	public int getHappiness() {
		return happiness;
	}

	public int getHealth() {
		return health;
	}

	public boolean getAlive() {
		return alive;
	}

	public String getDesciption() {
		return description;
	}

	public VirtualPet(String name, String description) {
		this.name = name;
		this.happiness = 50;
		this.health = 100;
		this.alive = true;
		this.description = description;
	}

	public void play() {
		happiness += 15;
	}

	public void die() {
		alive = false;
		System.out.println(name + "has died!");
	}

	public void tick() {
		happiness -= 10;
		loseHPWhenLowHappy();
		if (health <= 0) {
			die();
		}
	}

	public void loseHPWhenLowHappy() {
		if (happiness < 30) {
			System.out.println(getName() + " is unhappy \n-10 HP");
			loseHP();
		}
	}

	public void gainHappy(int HP) {
		happiness += HP;
	}

	public void loseHP() {
		health -= 10;
	}

	@Override
	public String toString() {
		return getName() + "\t|" + getHealth() + " | " + getHappiness() + " | ";
	}

}
