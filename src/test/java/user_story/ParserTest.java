package user_story;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ParserTest {
    @Test
    public void ParseCodeTest() {
        List<String> input = Arrays.asList(" _ |_| _|     |  | _  _||_ ",
                " _ |_| _|     |  | _  _||_ ",
                " _ |_| _|     |  | _  _||_ ",
                "");

        Entry e = new Entry(input);
        List<Entry> entries = Arrays.asList(e,e);
        Parser parser = new Parser();
        System.out.println(parser.asciiToCodes(entries));

    }
}
