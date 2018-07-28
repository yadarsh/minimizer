package minimizer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author yadlapallia
 *
 *
 *
 */
public class Minimizer {

	private static final Logger LOGGER = Logger.getLogger(Minimizer.class.getName());
	protected static List<String> distinctWords = new ArrayList<>();
	String regex = "[a-zA-Z]*";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOGGER.setLevel(Level.INFO);

		String str = "/*\n * public Function public to chop chop a public string in half.\n */\n public chop.static string chop(string input) { \n   if (input == null || input.isEmpty()) {";

		String[] splitByNewLine = str.split("\n+");

		distinctWords = createDistinctListOfWords(splitByNewLine);

		String newStr = str;
		int indexOfDistinctWord = 0;
		for (String word : distinctWords) {

			String regexString = "\\b" + word + "\\b";

			newStr = newStr.replaceAll(regexString, "\\$" + indexOfDistinctWord);

			newStr = newStr.replaceFirst("\\$" + indexOfDistinctWord, word);
			indexOfDistinctWord++;

		}
		System.out.println(newStr);

	}

	/**
	 * @param splitByNewLine
	 * @return
	 */
	private static List<String> createDistinctListOfWords(String[] splitByNewLine) {
		// splitByNewLine has a new line at each index
		for (String newLine : splitByNewLine) {

			// Breaking down each line into multiple indexes by space. Assuming
			// this will have a word/special characters in each index of
			// lineSplitBySpace
			String[] lineSplitBySpace = newLine.trim().split("[^a-zA-Z]");

			for (String wordInLine : lineSplitBySpace) {

				if (wordInLine != null && wordInLine.length() > 0 && !distinctWords.contains(wordInLine)) {

					distinctWords.add(wordInLine);

				} else {
					LOGGER.info("This word has already been added");

				}
			}

		}

		return distinctWords;
	}

}