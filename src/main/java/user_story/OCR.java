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

    public List<Entry> getListEntriesFromLines(List<String> lines) {
        int i=0;
        List<Entry> entries = new ArrayList<>();
        while(i < lines.size()) {
            Entry entry = new Entry(lines.subList(i, i+3));
            entries.add(entry);
            i+=4;
        }
        return entries;
    }
    public void parse() {
        Parser parser = new Parser();
        List<String> lines = this.readFile.read();
        List<Entry> entries = getListEntriesFromLines(lines);
        this.codes = parser.asciiToCodes(entries);
    }

    public void writeCodeInFile(List<Code> codes) {
        this.writeFile.write(codes);
    }

}
