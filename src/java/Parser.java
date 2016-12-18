public abstract class Parser {
	public Parser(){};

	public abstract String parse(String input);

	public static Parser getInstance(String actionType) {
		switch(actionType) {
			case "speller":
				return new SpellerParser();
			default:
				return new StemmingParser(); 
		}
	}
}