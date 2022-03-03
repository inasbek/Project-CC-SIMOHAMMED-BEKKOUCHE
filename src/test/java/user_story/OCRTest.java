package user_story;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class OCRTest {

    @Test
    public void ParseGoodCodeFileTest() throws IOException {
        OCR ocr = new OCR("src/main/java/user_story/files/text_normal.txt", "src/test/java/user_story/files/Authorized/write_code.txt");
        ocr.parse();
        ReadFile readFile = new ReadFile("src/test/java/user_story/files/Authorized/write_code.txt");
        Assert.assertEquals(readFile.read().get(0), "123456789");
    }

    @Test
    public void ParseErrorCodeFileTest() throws IOException {
        OCR ocr = new OCR("src/main/java/user_story/files/text_error.txt", "src/test/java/user_story/files/Errored/write_error_code.txt");
        ocr.parse();
        ReadFile readFile = new ReadFile("src/test/java/user_story/files/Errored/write_error_code.txt");
        Assert.assertEquals(readFile.read().get(0), "071717170 ERR");
    }

    @Test
    public void ParseIllisibleCodeFileTest() throws IOException {
        OCR ocr = new OCR("src/main/java/user_story/files/text_illisible.txt", "src/test/java/user_story/files/Unknown/write_illisible_code.txt");
        ocr.parse();
        ReadFile readFile = new ReadFile("src/test/java/user_story/files/Unknown/write_illisible_code.txt");
        Assert.assertEquals(readFile.read().get(0), "1234?6789 ILL");
    }

    @Test
    public void ParseMultipleCodeFileTest() {
        OCR ocr = new OCR("src/main/java/user_story/files/text_group.txt", "src/test/java/user_story/files/write_group_code.txt");
        ocr.parse();
        ReadFile readFile = new ReadFile("src/test/java/user_story/files/write_group_code.txt");
        Assert.assertEquals(readFile.read().get(0), "123456789");
        Assert.assertEquals(readFile.read().get(1), "49006771? ILL");
        Assert.assertEquals(readFile.read().get(2), "071717170 ERR");
    }

}
