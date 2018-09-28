package vpamok;

import org.junit.Assert;
import org.junit.Test;

public class OCatTest {
	OCat underTest = new OCat("Kitty Bo", "Black cat");
	OCat secondTest = new OCat("Kitty Bo", "Black cat");

	@Test
	public void shouldHavePoo() {
		underTest.pooInBox();
		int result = secondTest.getPooBox();
		Assert.assertEquals(10, result);
	}

	@Test
	public void shouldHavePooFromTwoOCats() {
		underTest.pooInBox();
		secondTest.pooInBox();
		int result = underTest.getPooBox();
		Assert.assertEquals(20, result);
	}
}
