package default_package;

public interface StorageI {

    public void setLine(int lineNumber, String shiftedLine);

    //returns a shifted line based on given line number
    public String getLine(int lineNumber);

    public int getLineCount();

    public String[] getWord(int lineNumber);

    //sets shifted words on given line
    public void setWord(int lineNumber, String line);

    public int getWordCountOnLine(int lineNumber);

    //public void alpha(IStorage lineStorage);
    //public void alpha(CircularShift circularShift);

    //public void setup(IStorage lineStorage);

    //public void alpha(IStorage circularShift);


}
