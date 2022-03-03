package user_story;

public class Code {
    private String code;
    private String status;

    public Code(String code) {
        this.code = code;
        CheckSum check = new CheckSum(code);
        this.status = check.getStatus();
    }

    public Code(String code, String status) {
        this.code = code;
        CheckSum check = new CheckSum(code);
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String toString() {
        return (this.getCode() + this.getStatus());
    }
}
