import static org.junit.Assert.*;

import org.junit.Test;

public class FakerBothifyTest {

	@Test
	public void BothifyShouldReturnRandomLetters() {
		Faker faker = new Faker();
		String result = faker.bothify("????");
		assertTrue(result.matches("[a-z][a-z][a-z][a-z]"));
	}

	@Test
	public void BothifyShouldReturnRandomNumbers() {
		Faker faker = new Faker();
		String result = faker.bothify("###");
		assertTrue(result.matches("[0-9][0-9][0-9]"));
	}

	@Test
	public void BothifyShouldReplaceAllQ() {
		Faker faker = new Faker();
		String result = faker.bothify("Marcin?i??Marta");
		assertTrue(result.matches("Marcin[a-z]i[a-z][a-z]Marta"));
	}

	@Test
	public void BothifyShouldReplaceAllHashes() {
		Faker faker = new Faker();
		String result = faker.bothify("Marcin#i##Marta");
		assertTrue(result.matches("Marcin[0-9]i[0-9][0-9]Marta"));
	}

	@Test 
	public void BothifyShouldReplaceAllHashesAndQMarks() {
		Faker faker = new Faker();
		String result = faker.bothify("?Marcin#i#?#Marta");
		assertTrue(result.matches("[a-z]Marcin[0-9]i[0-9][a-z][0-9]Marta"));
	}

	@Test
	public void BothifyShouldReturnTheSameValueWhenNoHashesAndNoQMarks() {
		Faker faker = new Faker();
		String result = faker.bothify("Marcin i Marta");
		assertTrue(result.matches("Marcin i Marta"));	
	}

	@Test
	public void BothifyShouldReturnNullWhenNullEntry() {
		Faker faker = new Faker();
		String result = faker.bothify(null);
		assertEquals(null, result);	
	}

}
