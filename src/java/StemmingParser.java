import java.util.Locale;

import morfologik.stemming.WordData;
import morfologik.stemming.polish.*;

public class StemmingParser extends Parser {
	private PolishStemmer stemmer;

	public StemmingParser() {
		stemmer = new PolishStemmer();
	}

	public String parse(String input) {
		return getStemmedString(input);
	}

	private String getStemmedString(String in) {
		String result = "";

		for (String t : in.toLowerCase(new Locale("pl")).split("[\\s\\.\\,]+")) {
			for (WordData wd : stemmer.lookup(t)) {
				result += (wd.getStem() == null ? "<<null>>" : wd.getStem()) + "/";
			}
			result += " ";
		}

		return result;
	}
}