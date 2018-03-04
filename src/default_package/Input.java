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
	//      LineStorage lineStorage;
	KWICdriver gui = new KWICdriver();
	public static Button submitButton;
	/**
	 * Construct Input
	 */
	//      public Input() {
	//              lineStorage = new LineStorage();
	//      }

	/**
	 * Reads the file and parses every line
	 *
	 * @param file
	 *
	 * @return Line Storage object
	 *
	 * @throws IOException
	 */
	public LineStorage readAndStore(String file, LineStorage lineStorage) throws IOException {
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
		return lineStorage;
	}

	public void getUserInput( LineStorage lineStorage){

		// KWICdriver gui = new KWICdriver();
		// submitButton = new Button("Submit");

		//System.out.println("button text:" + gui.getSubmitButton().getText());



		int lineCounter = 0;

		//if(e.getSource() == gui.getsubmitButton()){
		for (String line : gui.getTextArea().getText().split("\\n")){
			if(!line.equals("")){
				lineStorage.setLine(lineCounter, line);
				System.out.println("line:" + line);
				//      }
				lineCounter++;
			}
			//        submitButton.setVisible(false);
			//      gui.getHeaderLaber().setText("Output:");
			gui.getTextArea().setText("");
		}
	}



}

