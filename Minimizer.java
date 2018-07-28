package minimizer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

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

		// String str = "you say yes, I say no you say stop and I say go go go";

		// String input = "/*\n * public Function public to chop chop a public
		// if string in half.\n */\n public chop.static string chop(string
		// input) { \n if(input == null || input.isEmpty()) {";

		String input = "/*\n * Function to chop a string in half.\n */\n"
				+ "public static string chop(string input) {\n" + "  if (input == null || input.isEmpty()) {\n"
				+ "  return input;\n" + "  }\n" + "  if (input.length() % 2 == 1) {\n"
				+ "		return \"cannot chop an odd-length string in half\";\n" + "	}\n"
				+ "	return input.substring(input.length()/2);\n" + "} \n ";

		String[] splitByNewLine = splitByNewLine(input);

		// Get a list of distinct words in the original input.
		distinctWords = createDistinctListOfWords(splitByNewLine);
		String[] mainInputSplit = splitByAllNonAlphabets(input);

		String minimizedInput = input;
		int indexOfDistinctWord;

		for (String word : distinctWords) {
			indexOfDistinctWord = 0;

			for (String curVal : mainInputSplit) {

				if ((curVal.length() != 0) && curVal.contains(word)) {
					break;
				}
				indexOfDistinctWord++;

				if (curVal.length() == 0) {
					indexOfDistinctWord--;
				}

			}
			String regexString = "\\b" + word + "\\b";

			minimizedInput = minimizedInput.replaceAll(regexString, "\\$" + indexOfDistinctWord);

			minimizedInput = minimizedInput.replaceFirst("\\$" + indexOfDistinctWord, word);

		}
		System.out.println("*********");
		System.out.println("Input provided was: ");
		System.out.println("*********");
		System.out.println(input);
		System.out.println("*********");
		System.out.println("Minimized output is: ");
		System.out.println("*********");
		System.out.println(minimizedInput);
		System.out.println("*********");

	}

	/**
	 * @param input
	 * @return
	 */
	public static String[] splitByAllNonAlphabets(String input) {
		return input.split("[^a-zA-Z]");
	}

	/**
	 * @param input
	 * @return
	 */
	public static String[] splitByNewLine(String input) {
		return input.split("\n+");
	}

	/**
	 * @param splitByNewLine
	 * @return
	 */
	public static List<String> createDistinctListOfWords(String[] splitByNewLine) {
		// splitByNewLine has a new line at each index
		for (String newLine : splitByNewLine) {

			// Breaking down each line into words delimited by anything other
			// than alphabets.
			String[] lineSplitBySpace = newLine.trim().split("[^a-zA-Z]");

			// lineSplitBySpace is now an array of words in each line. The below
			// for loop loops through each line to get a list of distinct words.
			for (String wordInLine : lineSplitBySpace) {
				// Ignore null values or if the word is already in
				// distinctWords. Otherwise, add the current word to the list.

				if (wordInLine != null && wordInLine.length() > 0 && !distinctWords.contains(wordInLine)) {

					distinctWords.add(wordInLine);

				}
			}

		}

		return distinctWords;
	}

}
