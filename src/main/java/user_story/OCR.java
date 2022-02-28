package user_story;


import java.util.ArrayList;
import java.util.List;

public class OCR {
    private ReadFile readFile;
    private WriteFile writeFile;
    private List<Code> codes = new ArrayList<Code>();

    public OCR(ReadFile readFile, WriteFile writeFile) {
        this.readFile = readFile;
        this.writeFile = writeFile;
    }

    public void parse(List<Entry> entries) {
        Parser parser = new Parser();
        codes = parser.asciiToCodes(entries);
        this.readFile.read(codes);
    }

    public void writeCodeInFile(List<Code> codes) {
        this.writeFile.write(codes);
    }

}
