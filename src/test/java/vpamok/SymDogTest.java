package vpamok;

import org.junit.Assert;
import org.junit.Test;

public class SymDogTest {
	SymDog underTest = new SymDog("", "");

	@Test
	public void shouldRustFromTick() {
		underTest.tick();
		int result = underTest.getRust();
		Assert.assertEquals(10, result);
	}

	@Test
	public void shouldDecreaseHealthFromRust() {
		underTest.tick();
		underTest.tick();
		underTest.tick();
		int result = underTest.getHealth();
		Assert.assertEquals(80, result);
	}

	@Test
	public void oilShouldReduceRust() {
		underTest.giveOil();
	}

	@Test
	public void shouldHaveInheritedHappy() {
		int result = underTest.getHappiness();
		Assert.assertEquals(50, result);
	}

	@Test
	public void shouldIncreaseHappyFromWalk() {
		underTest.walk();
		int result = underTest.getHappiness();
		Assert.assertEquals(65, result);
	}

}
