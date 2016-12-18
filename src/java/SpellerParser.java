public class SpellerParser extends Parser {

	public SpellerParser() {

	}

	public String parse(String input) {
		return getSpelledString(input);
	}

	public static String getSpelledString(String in) {
		return in;
	}
}