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
		underTest.decreaseHealthFromRust();
		int result = underTest.getHealth();
		Assert.assertEquals(85, result);
	}

}
