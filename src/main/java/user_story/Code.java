package user_story;

public class Code {
    public String code;
    public String status;

    public Code(String code) {
        this.code = code;
        CheckSum check = new CheckSum(code);
        this.status = check.status;
    }

    public Code(String code,String status) {
        this.code = code;
        CheckSum check = new CheckSum(code);
        this.status = status;
    }

}
