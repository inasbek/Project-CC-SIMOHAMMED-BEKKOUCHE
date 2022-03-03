package user_story;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ParserTest {
    @Test
    public void ParseCodeTest() {
        List<String> input = Arrays.asList("    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_| _|",
                "");

        Entry e = new Entry(input);
        List<Entry> entries = Arrays.asList(e, e);
        Parser parser = new Parser();
        List<Code> codes = parser.asciiToCodes(entries);
        Assert.assertEquals(codes.get(0).getCode(), "123456789");
        Assert.assertEquals(codes.get(1).getCode(), "123456789");

    }
}
