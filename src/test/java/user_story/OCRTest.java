package user_story;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class OCRTest {

    @Test
    public void ParseAGoodCodeFileTest() throws IOException {
        OCR ocr = new OCR("src/main/java/user_story/files/text_normal.txt","");
        ocr.parse();
        List<Code> codes = ocr.getCodes();
        Assert.assertEquals(codes.size(),1);
        Assert.assertEquals(codes.get(0).code,"123456789");
        Assert.assertEquals(codes.get(0).status,"");
    }

    @Test
    public void ParseAnErrorCodeFileTest() {
        OCR ocr = new OCR("src/main/java/user_story/files/text_error.txt","");
        ocr.parse();
        List<Code> codes = ocr.getCodes();
        Assert.assertEquals(codes.size(),1);
        Assert.assertEquals(codes.get(0).code,"071717170");
        Assert.assertEquals(codes.get(0).status," ERR");
    }

    @Test
    public void ParseAnIllisibleCodeFileTest() {
        OCR ocr = new OCR("src/main/java/user_story/files/text_illisible.txt","");
        ocr.parse();
        List<Code> codes = ocr.getCodes();
        Assert.assertEquals(codes.size(),1);
        Assert.assertEquals(codes.get(0).code,"1234?6789");
        Assert.assertEquals(codes.get(0).status," ILL");
    }

    @Test
    public void ParseAGroupCodeFileTest() {

    }

}
