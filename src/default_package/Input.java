package default_package;

import javafx.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Input: Reads the file and parses the input to the Line Storage
 */
public class Input {

	/**
	 * Stores lines to the Line Storage object
	 */
	

	/**
	 * Reads the file and parses every line or receives user input
	 *
	 */
	
	KWICdriver gui = new KWICdriver();
	
	public LineStorage readAndStore(String file, StorageI lineStorage) throws IOException {
		// Reads the file
		BufferedReader reader = new BufferedReader(new FileReader(file));

		// Count line
		int lineCounter = 0;

		// Line
		String line;

		// Read one line at a time
		while ((line = reader.readLine()) != null) {
			// Skip empty lines
			if (!"".equals(line)) {

				// Add line to the Line Storage
				lineStorage.setLine(lineCounter, line);

				// Increase line counter
				lineCounter++;

			}

		}

		// Close the file
		reader.close();

		// Return line storage
		return (LineStorage) lineStorage;
	}

	public void getUserInput( StorageI lineStorage){
		int lineCounter = 0;

		for (String line : gui.getTextArea().getText().split("\\n")){
			if(!line.equals("")){
				lineStorage.setLine(lineCounter, line);
				System.out.println("line:" + line);
				lineCounter++;
			}
		}
	}

	

}

