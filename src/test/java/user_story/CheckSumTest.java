package user_story;

import org.junit.Assert;
import org.junit.Test;

public class CheckSumTest {
    @Test
    public void CodeHasAllLegalDigitsIsValid() {
        CheckSum check = new CheckSum("123456789");
        Assert.assertEquals(check.isValid(check.getCode()), true);
    }

    @Test
    public void CodeHasNotWorkedCheckSumIsInvalid() {
        CheckSum check = new CheckSum("664371495");
        Assert.assertEquals(check.isValid(check.getCode()), false);
    }

    @Test
    public void CodeHasOneOrMoreIllegalDigitsIsInvalid() {
        CheckSum check = new CheckSum("12345?789");
        Assert.assertEquals(check.isValid(check.getCode()), false);
    }
}
