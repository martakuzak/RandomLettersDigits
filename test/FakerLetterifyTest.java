import static org.junit.Assert.*;

import org.junit.Test;

public class FakerLetterifyTest {

	@Test
	public void LetterifyShouldReturnRandomLetters() {
		Faker faker = new Faker();
		String result = faker.letterify("???");
		assertTrue(result.matches("[a-z][a-z][a-z]"));
	}

	@Test
	public void LetterifyShouldReplaceAllQ() {
		Faker faker = new Faker();
		String result = faker.letterify("Marcin?i??Marta");
		assertTrue(result.matches("Marcin[a-z]i[a-z][a-z]Marta"));
	}

	@Test
	public void LetterifyShouldReturnTheSameValueWhenNoQ() {
		Faker faker = new Faker();
		String result = faker.letterify("Marcin i Marta");
		assertTrue(result.matches("Marcin i Marta"));	
	}

	@Test
	public void LetterifyShouldReturnNullWhenNullEntry() {
		Faker faker = new Faker();
		String result = faker.letterify(null);
		assertEquals(null, result);	
	}

}
