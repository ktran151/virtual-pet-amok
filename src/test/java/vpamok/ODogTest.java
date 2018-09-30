package vpamok;

import org.junit.Assert;
import org.junit.Test;

public class ODogTest {
	ODog underTest = new ODog("james", "has spots");

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

	@Test
	public void shouldBeClean() {
		int result = underTest.getPoo();
		Assert.assertEquals(0, result);
	}

	@Test
	public void shouldDecreasePooFromWalk() {
		underTest.tick();
		underTest.tick();
		underTest.tick();
		underTest.walk();
		int result = underTest.getPoo();
		Assert.assertEquals(10, result);
	}

	@Test
	public void shouldCleanCage() {
		underTest.walk();
		underTest.cleanCage();
		int result = underTest.getPoo();
		Assert.assertEquals(0, result);
	}

	@Test
	public void shouldGetPooFromOverridedTick() {
		underTest.tick();
		int result = underTest.getPoo();
		Assert.assertEquals(10, result);
	}

}
