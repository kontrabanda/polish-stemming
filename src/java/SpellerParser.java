import java.net.URL;
import java.io.*;
import java.util.*;

import morfologik.stemming.Dictionary;
import morfologik.speller.*;

public class SpellerParser extends Parser {
	private Dictionary dictionary;
	private Speller speller;

	public SpellerParser() {
		try {
			final URL url = (new java.io.File("src/dict/pl.dict")).toURI().toURL();
			System.out.println(url);
			dictionary = Dictionary.read(url);	
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		speller = new Speller(dictionary);
	}

	public String parse(String input) {
		return getSpelledString(input);
	}

	public String getSpelledString(String in) {
		List<String> reps = speller.findReplacements("tchurz");

		for(String word: reps) {
			System.out.println(word);
		}

		return in;
	}
}