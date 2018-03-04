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
                 submitButton = new Button("Submit");

                //System.out.println("button text:" + gui.getSubmitButton().getText());


                 submitButton.setOnAction(new EventHandler<ActionEvent>(){
                          @Override
                        public void handle(ActionEvent e)
                        {
                                int lineCounter = 0;

                                //if(e.getSource() == gui.getsubmitButton()){
                                        for (String line : gui.getTextArea().getText().split("\\n")){
                                        if(!line.equals("")){
                                                //lineStorage.setLine(lineCounter, line);
                                                System.out.println("line:" + line);
                                //      }
                                        lineCounter++;
                        }
                                        submitButton.setVisible(false);
                                //      gui.getHeaderLaber().setText("Output:");
                                        gui.getTextArea().setText("");
                                }
                        }
                });

        }

        public Button getSubmitButton() {
                return submitButton;
        }
}



-------------------------------------------



/**
 * CircularShift: Performs circular word shift to the right
 *
 */
public class CircularShift {

        /**
         * Line Storage object
         */
        LineStorage lineStore = new LineStorage();

        /**
         * Stores circular line list
         */
        //List<String> circularLineList;

        /**
         * Construct the Circular Shift object based on Line Storage object
         *
         * @param lineStorage
         */
        //      public CircularShift(LineStorage lineStorage) {
        //              this.lineStorage = lineStorage;
        //              circularLineList = new ArrayList<String>();
        //
        //      }

        /**
         * Performs the circular shifts and adds them to the circular line list
         */
        //private LineStorage lineStore = new LineStorage();

        String line;
        int shiftedLineIndex = 0;
        public void setup(LineStorage lineStorage) {
                //loop through all original lines to shift
                for(int i = 0; i < lineStorage.getLineCount(); i++){
                        line = lineStorage.getLine(i);

                        //loop through how many words on current line to produce shift
                        for(int j = 0; j <lineStorage.getWordCountOnLine(i); j++){

                                if(lineStorage.getWordCountOnLine(i) > 1) {
                                        //sets words in shifted line to be used for subsequent line appending
                                        setWord(shiftedLineIndex, line);

                                        //take first word append to end of original line
                                        line = line.toString().replaceAll(getWord(shiftedLineIndex)[0] + " ", "");

                                        line = line+ " " + getWord(shiftedLineIndex)[0];
                                }

                                //set shifted lines
                                setLine(shiftedLineIndex, line);
                                System.out.println("shifted line: " + getLine(shiftedLineIndex));
                                shiftedLineIndex++;
                        }
                }
                System.out.println("index: " + shiftedLineIndex);
        }

        public void setLine(int lineNumber, String shiftedLine) {
                lineStore.setLine(lineNumber, shiftedLine);

        }

        //returns a shifted line based on given line number
        public String getLine(int lineNumber) {
                return lineStore.getLine(lineNumber);
        }

        //returns words on given shifted line
        public String[] getWord(int lineNumber) {
                return lineStore.getWord(lineNumber);
        }

        //sets shifted words on given line
        public void setWord(Integer lineNumber, String line) {
                lineStore.setWord(lineNumber, line);
        }

        //number of shifted lines
        public int getLineCount(){
                return shiftedLineIndex;
        }
}