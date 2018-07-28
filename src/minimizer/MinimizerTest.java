package minimizer;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class MinimizerTest {
	String str = "you say yes,\n I say no";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@Test
	public void splitByAllNonAlphabets_Test() {
		String[] splitString = Minimizer.splitByAllNonAlphabets(str);

		String[] expectedStringArray = { "you", "say", "yes", "", "", "I", "say", "no" };

		assertArrayEquals(splitString, expectedStringArray);
	}

	@Test
	public void splitByNewLine_Test() {
		String[] splitString = Minimizer.splitByNewLine(str);

		String[] expectedStringArray = { "you say yes,", " I say no" };

		assertArrayEquals(splitString, expectedStringArray);

	}

	@Test
	public void createDistinctListOfWords_Test() {

		String[] splitByLines = { "you say yes,", " I say no" };

		List<String> distinctWords = Minimizer.createDistinctListOfWords(splitByLines);

		List<String> expectedDistinctWords = Arrays.asList("you", "say", "yes", "I", "no");

		assertEquals(distinctWords, expectedDistinctWords);

	}
}
