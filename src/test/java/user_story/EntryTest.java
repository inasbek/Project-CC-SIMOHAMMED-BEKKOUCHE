package user_story;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class EntryTest {
    @Test
    public void InvalidEntryHasUnBlankFourthLineTest() {
        List<String> invalidInput = Arrays.asList(
                new String(new char[27]).replace('\0', ' '),
                new String(new char[27]).replace('\0', ' '),
                new String(new char[27]).replace('\0', ' '),
                new String(new char[27]).replace('\0', '_')
        );
        Entry e = new Entry(invalidInput);
        Assert.assertEquals(e.isValid(), false);

    }
    @Test
    public void ValidEntryHasBlankFourthLineTest() {
        List<String> valid = Arrays.asList(
                new String(new char[27]).replace('\0', ' '),
                new String(new char[27]).replace('\0', ' '),
                new String(new char[27]).replace('\0', ' '),
                new String(new char[27]).replace('\0', ' ')
        );
        Entry e = new Entry(valid);
        Assert.assertEquals(e.isValid(), true);
    }
    @Test
    public void InvalidEntryHasOtherThanFourLinesTest() {
        List<String> invalidInput = Arrays.asList(
                new String(new char[27]).replace('\0', ' '),
                new String(new char[27]).replace('\0', ' '),
                new String(new char[27]).replace('\0', ' '),
                new String(new char[27]).replace('\0', ' '),
                new String(new char[27]).replace('\0', ' ')
                );
        Entry e = new Entry(invalidInput);
        Assert.assertEquals(e.isValid(), false);
    }
    @Test
    public void ValidEntryHasExactlyFourLinesTest() {
        List<String> validInput = Arrays.asList(
                new String(new char[27]).replace('\0', ' '),
                new String(new char[27]).replace('\0', ' '),
                new String(new char[27]).replace('\0', ' '),
                new String(new char[27]).replace('\0', ' '),
                new String(new char[27]).replace('\0', ' ')
        );
        Entry e = new Entry(validInput);
        Assert.assertEquals(e.isValid(), false);
    }

    @Test
    public void InvalidEntryHasLinesDifferentThan27CharactersTest() {

        List<String> validInput = Arrays.asList(
                new String(new char[27]).replace('\0', ' '),
                new String(new char[26]).replace('\0', ' '),
                new String(new char[27]).replace('\0', ' '),
                new String(new char[27]).replace('\0', ' ')
        );
        Entry e = new Entry(validInput);
        Assert.assertEquals(e.isValid(), false);
    }
    @Test
    public void ValidEntryHasAllLinesOf27CharactersTest() {

        List<String> validInput = Arrays.asList(
                new String(new char[27]).replace('\0', ' '),
                new String(new char[27]).replace('\0', ' '),
                new String(new char[27]).replace('\0', ' '),
                new String(new char[27]).replace('\0', ' ')
                );
        Entry e = new Entry(validInput);
        Assert.assertEquals(e.isValid(), true);
    }


}
