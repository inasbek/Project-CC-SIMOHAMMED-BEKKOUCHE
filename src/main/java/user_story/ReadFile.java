package user_story;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFile {
    private String filePath;

    public ReadFile(String filePath) {
        this.filePath = filePath;
    }
    public void read(List<Code> codes) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int entry=0; entry <= lines.size()/4; entry += 4) {
            String currentLine = lines.get(entry);

        }
    }
}
