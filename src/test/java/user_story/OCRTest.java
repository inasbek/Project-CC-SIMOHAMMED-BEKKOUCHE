package user_story;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class OCRTest {

    @Test
    public void ParseAnEmptyCodeFileTest() throws IOException {
        OCR ocr = new OCR("src/main/java/user_story/files/ascii.txt","");
        ocr.parse();
        List<Code> codes = ocr.getCodes();
        Assert.assertEquals(codes.size(),1);
    }

    @Test
    public void ParseAnErrorCodeFileTest() {

    }

    @Test
    public void ParseAnIllisibleCodeFileTest() {

    }

    @Test
    public void ParseAGroupCodeFileTest() {

    }

}
