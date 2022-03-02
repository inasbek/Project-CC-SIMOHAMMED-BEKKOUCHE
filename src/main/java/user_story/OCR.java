package user_story;

import java.util.ArrayList;
import java.util.List;

public class OCR {

    private final ReadFile readFile;
    private final WriteFile writeFile;
    private List<Code> codes = new ArrayList<>();

    public OCR(String readFilePath, String writeFilePath) {
        this.readFile = new ReadFile(readFilePath);
        this.writeFile = new WriteFile(writeFilePath);
    }

    public List<Code> getCodes() {
        return codes;
    }

    public void parse() {
        Parser parser = new Parser();
        List<String> lines = this.readFile.read();
        Entry entry = new Entry(lines);
        List<Entry> entries = new ArrayList<>();
        entries.add(entry);
        codes = parser.textToCodes(entries);
    }

    public void writeCodeInFile(List<Code> codes) {
        this.writeFile.write(codes);
    }

}
