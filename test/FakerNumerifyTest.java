import static org.junit.Assert.*;

import org.junit.Test;

public class FakerNumerifyTest {

	@Test
	public void NumerifyShouldReturnRandomNumbers() {
		Faker faker = new Faker();
		String result = faker.numerify("###");
		assertTrue(result.matches("[0-9][0-9][0-9]"));
	}

	@Test
	public void NumerifyShouldReplaceAllHashes() {
		Faker faker = new Faker();
		String result = faker.numerify("Marcin#i##Marta");
		assertTrue(result.matches("Marcin[0-9]i[0-9][0-9]Marta"));
	}

	@Test
	public void NumerifyShouldReturnTheSameValueWhenNoHashes() {
		Faker faker = new Faker();
		String result = faker.numerify("Marcin i Marta");
		assertTrue(result.matches("Marcin i Marta"));	
	}

	@Test
	public void NumerifyShouldReturnNullWhenNullEntry() {
		Faker faker = new Faker();
		String result = faker.numerify(null);
		assertEquals(null, result);	
	}

}
