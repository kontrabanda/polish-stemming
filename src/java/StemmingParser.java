import java.util.Locale;
import java.util.List;

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
			List<WordData> wodrDataList = stemmer.lookup(t);

			if(wodrDataList.size() == 0) {
				result += t;
			} else {
				for (WordData wd : wodrDataList) {
					result += (wd.getStem() == null ? "<<null>>" : wd.toString()) + "/";
				}
			}

			result += " ";
		}

		return result;
	}
}