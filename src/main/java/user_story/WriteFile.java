package user_story;


import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.io.*;

public class WriteFile {

    private final String path;

    public WriteFile(String path) {
        this.path = path;
    }

    public void write(List<Code> codes) {
        try {
            PrintWriter writer = new PrintWriter(this.path, StandardCharsets.UTF_8);
            for(Code code : codes) {
                writer.write(new StringBuilder().append(code.toString()).append('\n').toString());
            }
            writer.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
