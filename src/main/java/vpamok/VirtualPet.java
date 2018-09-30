package vpamok;

public class VirtualPet {

	protected String name;
	protected int happiness;
	protected int health;
	protected boolean alive;
	protected String description;

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

	public void play(String game) {
		happiness += 10;
	}

	public void die() {
		alive = false;
	}

	public void tick() {
		happiness -= 10;
	}

	public void loseHP() {
		health -= 10;
	}

}
