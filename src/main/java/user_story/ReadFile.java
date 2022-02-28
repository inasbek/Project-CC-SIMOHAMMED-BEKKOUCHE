package user_story;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private String filePath;

    public ReadFile(String filePath) {
        this.filePath = filePath;
    }
    public List<String> read() {
        List<String> lines = new ArrayList<String>();
        BufferedReader reader = null ;
        try {
            reader = Files.newBufferedReader(Path.of(this.filePath));
            String line = null;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;

    }
}
