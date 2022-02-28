package user_story;

import java.util.List;

public class Entry {
    public List<String> lines;
    private boolean isValid = true;

    public Entry(List<String> lines) {
        this.lines = lines;
    }

    public boolean isValid() {
        if(this.lines.stream().count() != 4) {
            isValid = false;
        }
        if(this.lines.get(3).trim().length() != 0) {
            isValid = false;
        }
        for (String line : this.lines) {
            if(line.length() != 27) {
                isValid = false;
            }
        }
        return isValid;
    }

}
