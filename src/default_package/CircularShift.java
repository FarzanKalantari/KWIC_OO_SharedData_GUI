package default_package;

/**
 * CircularShift: Performs circular word shift to the right
 *
 */
public class CircularShift implements StorageI {

        /**
         * Line Storage object
         */
        LineStorage lineStore = new LineStorage();

        /**
         * Construct the Circular Shift object based on Line Storage object
         *
         * @param lineStorage
         */


        /**
         * Performs the circular shifts and adds them to the circular line list
         */

        String line;
        int shiftedLineIndex = 0;
        public void setup(StorageI lineStorage) {
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

        //sets shifted lines on given line
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
        public void setWord(int lineNumber, String line) {
                lineStore.setWord(lineNumber, line);
        }

        //number of shifted lines
        public int getLineCount(){
                return shiftedLineIndex;
        }

		@Override
		public int getWordCountOnLine(int lineNumber) {
			// TODO Auto-generated method stub
			return 0;
		}

		
}