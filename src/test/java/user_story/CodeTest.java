package user_story;

import org.junit.*;

public class CodeTest {

    @Test
    public void CodeHasNineLegalDigitsHasEmptyStatusTest() {
        Code code = new Code("123456789");
        Assert.assertEquals(code.getCode(), "123456789");
        Assert.assertEquals(code.getStatus(), "");

    }
    @Test
    public void CodeWithNoWorkedCheckSumHasErrorStatusTest() {
        Code code = new Code("664371495");
        Assert.assertEquals(code.getCode(), "664371495");
        Assert.assertEquals(code.getStatus(), " ERR");
    }
    @Test
    public void CodeWithOneOrMoreUnreadableDigitsHasIllegalStatusTest(){
        Code code = new Code("12345?789");
        Assert.assertEquals(code.getCode(), "12345?789");
        Assert.assertEquals(code.getStatus(), " ILL");
    }

}
