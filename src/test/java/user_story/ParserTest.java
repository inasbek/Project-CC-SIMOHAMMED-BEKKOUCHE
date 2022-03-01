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
        List<Entry> entries = Arrays.asList(e,e);
        Parser parser = new Parser();
        List<Code> codes = parser.textToCodes(entries);
        Assert.assertEquals(codes.get(0).code, "123456789");
        Assert.assertEquals(codes.get(1).code, "123456789");

    }
}
