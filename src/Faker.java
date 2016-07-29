public class Faker {

	public static final int NUMBER_OF_LETTERS = 26;
	public static final char QMARK = '?';
	public static final int NUMBER_OF_DIGITS = 10;
	public static final char HASH = '#';

	/**
	 * Replaces all '?' with random lower case letters
	 * @param letterString
	 * @return
	 */
	public String letterify(String letterString) {
		return internalReplace(letterString, QMARK, 'a', NUMBER_OF_LETTERS);
	}

	/**
	 * Replaces all '#' with random digits
	 * @param numberString
	 * @return
	 */

	public String numerify(String numberString) {
		return internalReplace(numberString, HASH, '0', NUMBER_OF_DIGITS);
	}

	/**
	 * Replaces all '?' with random lower case letter and all '#' with random digits
	 * @param string
	 * @return
	 */

	public String bothify(String string) {
		return letterify(numerify(string));
	}


	/**
	 * Replace given character in the String with random characters from given range
	 * @param input
	 * @param replaceChar character to replace
	 * @param startChar the first character from range from which there will be draw
	 * @param numOfChar number of character in the range
	 * @return proper string with all the characters replaced
	 * 
	 * Example:
	 * input = "Ala ma kota"
	 * replaceChar = 'a'
	 * startChar = 'N'
	 * numOfChar = 4
	 * 
	 * The method replaces all the 'a' characters with random characters from set {'N', 'O', 'P', 'Q'}
	 * 
	 * Examples of output: "NlN mP kotQ", "OlQ mQ kotP"
	 */

	private String internalReplace(String input, char replaceChar, char startChar, int numOfChar) {
		if(input == null)
			return null;
		StringBuilder builder = new StringBuilder(input);

		for(int i = 0; i < builder.length(); ++ i) {
			if(builder.charAt(i) == replaceChar) {
				builder.setCharAt(i, (char)(Math.random() *  numOfChar + startChar));
			}
		}
		return builder.toString();
	}

}