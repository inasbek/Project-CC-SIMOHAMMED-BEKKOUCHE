package user_story;


import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;
import java.io.*;
public class WriteFile {
    private String path;

    public WriteFile(String path) {
        this.path = path;
    }
    public void write(List<Code> codes) {
        try{
            PrintWriter writer = new PrintWriter(this.path, "UTF-8");
            for(Code code : codes) {
                writer.write(code.code);
            }
            writer.close();
        }
        catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
