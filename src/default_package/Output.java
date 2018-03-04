package default_package;

import java.util.Arrays;
import java.util.List;

import javafx.scene.control.Label;

/**
 * Output: Shows the output based on the requirements
 *
 */
public class Output {

	/**
	 * Noise word list
	 */
	List<String> noiseWordList;

	/**
	 * Alphabetizer object
	 */
	Alphabetizer alphabetizer;
	Label headerLabel;
	KWICdriver gui = new KWICdriver();

	/**
	 * Construct Output based on Alphabetizer
	 *
	 * @param alphabetizer
	 */
	public Output(Alphabetizer alphabetizer) {
		this.alphabetizer = alphabetizer;

		// Declare noise words
		noiseWordList = Arrays.asList(new String[] { "a", "an", "the", "and", "or", "of", "to", "be", "is", "in", "out",
				"by", "as", "at", "off" });
	}

	/**
	 * Print the output
	 */
	public void print() {
		// Loop through the line list to examine every sorted line

		System.out.println();

		for (int i = 0; i < alphabetizer.getLineCount(); i++) {
			// Get the first word in lower case format
			String firstWord = alphabetizer.getLine(i).split(" ")[0].toLowerCase();

			// If first word is a noise word, don't print
			//       if (!noiseWordList.contains(firstWord)) {

			System.out.println("sorted:" + alphabetizer.getLine(i));

			gui.getHeaderLaber().setText("Output:");

			gui.getTextArea().appendText(alphabetizer.getLine(i) + "\n");

			//      }
		}
	}
}