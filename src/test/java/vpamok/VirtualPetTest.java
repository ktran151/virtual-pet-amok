package vpamok;

import org.junit.Assert;
import org.junit.Test;

import vpamok.VirtualPet;

public class VirtualPetTest {

	@Test
	public void shouldHaveName() {
		// arrange
		VirtualPet underTest = new VirtualPet("dan", "");

		String petName = underTest.name;
		Assert.assertEquals("dan", petName);
	}

	@Test
	public void shouldBeAlive() {
		VirtualPet underTest = new VirtualPet("", "");

		boolean alive = underTest.alive;
		Assert.assertTrue(alive);
	}

	@Test
	public void shouldBeDead() {
		VirtualPet underTest = new VirtualPet("", "");
		underTest.die();
		underTest.tick();
		Assert.assertFalse(underTest.alive);
	}

	@Test
	public void shouldLoseHealthWhenUnhappy() {
		VirtualPet underTest = new VirtualPet("", "");
		underTest.happiness = 20;
		underTest.loseHPWhenUnhappy();
		int result = underTest.getHealth();
		Assert.assertEquals(80, result);
	}

}
