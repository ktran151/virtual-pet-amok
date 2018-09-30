package vpamok;

import org.junit.Assert;
import org.junit.Test;

public class OrganicPetTest {

	@Test
	public void shouldFeed() {
		OrganicPet underTest = new OrganicPet("", "");

		underTest.feed("");

		Assert.assertEquals(20, underTest.getHunger());
	}

	@Test
	public void shouldBeHungry() {
		OrganicPet underTest = new OrganicPet("", "");
		int petHunger = underTest.getHunger();
		Assert.assertEquals(50, petHunger);
	}

	@Test
	public void shouldLoseHealthWhenUnclean() {
		OrganicPet underTest = new OrganicPet("", "");
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.loseHPWhenUnclean();
		int result = underTest.getHealth();
		Assert.assertEquals(90, result);
	}

}
