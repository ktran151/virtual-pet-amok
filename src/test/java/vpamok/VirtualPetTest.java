package vpamok;

import org.junit.Assert;
import org.junit.Test;

import vpamok.VirtualPet;

public class VirtualPetTest {

	@Test
	public void shouldHaveName() {
		// arrange
		VirtualPet underTest = new VirtualPet("dan", "");

		String petName = underTest.getName();
		Assert.assertEquals("dan", petName);
	}

	@Test
	public void shouldBeAlive() {
		VirtualPet underTest = new VirtualPet("", "");
		boolean alive = underTest.getAlive();
		Assert.assertTrue(alive);
	}

	@Test
	public void shouldBeDead() {
		VirtualPet underTest = new VirtualPet("", "");
		underTest.die();
		underTest.tick();
		Assert.assertFalse(underTest.getAlive());
	}

	@Test
	public void shouldLoseHealthWhenUnhappy() {
		VirtualPet underTest = new VirtualPet("", "");
		underTest.gainHappy(-30);
		underTest.loseHP();
		int result = underTest.getHealth();
		Assert.assertEquals(90, result);
	}

}
