package default_package;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Alphabetizer: Sorts the list of output lines
 */
public class Alphabetizer {

	/**
	 * Circular Shift object
	 */
	CircularShift circularShift = new CircularShift();

	/**
	 * Stores sorted list
	 */
	ArrayList<String> sortedLineList;
	ArrayList<String> shiftedLineList;


	/**
	 * Construct the Alphabetizer constructor initialize sorting list
	 *
	 * @param circularShift
	 */
	public Alphabetizer() {
		//      this.circularShift = circularShift;
		shiftedLineList = new ArrayList<String>();
		sortedLineList = new ArrayList<String>();
	}

	/**
	 * Makes a copy of the original list from circularShift and sorts this new
	 * list so that source is unchanged
	 */
	public void alpha(CircularShift circularShift) {
		// Copy from the original list to a new list
		for (int i =0; i < circularShift.getLineCount(); i ++) {
			shiftedLineList.add(circularShift.getLine(i));
		}


		Collator tertiraryCollator = Collator.getInstance(Locale.US);
		tertiraryCollator.setStrength(Collator.TERTIARY);

		Collections.sort(shiftedLineList, tertiraryCollator);
		sortedLineList = shiftedLineList;
		
		for(int i = 0; i < sortedLineList.size(); i++) {
			setLine(i, sortedLineList.get(i));
		}

	}

	/**
	 * @return Sorted list
	 */
	public List<String> getLine() {
		return sortedLineList;
	}


	public void setLine(int lineNumber, String shiftedLine) {
		circularShift.setLine(lineNumber, shiftedLine);

	}

	//returns a shifted line based on given line number
	public String getLine(int lineNumber) {
		return circularShift.getLine(lineNumber);
	}

	public int getLineCount(){
		return sortedLineList.size();
	}
}