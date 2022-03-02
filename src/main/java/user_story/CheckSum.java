package user_story;

public class CheckSum {

    private String status;
    private String code;

    public CheckSum(String code) {
        this.code = code;
        this.status = status(code);
    }

    public String getCode() {
        return code;
    }
    
    public String getStatus() {
        return status;
    }

    public int checkSumOf(String code) {
        int checksum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Integer.parseInt(code.substring(i, i+1));
            checksum = checksum + digit * (9-i) ;
        }

        return checksum % 11;
    }

    public boolean isReadable(String code) {
        return code.contains("?");
    }

    public boolean isValid(String code) {
        return !isReadable(code) && checkSumOf(code) == 0;
    }

    public String status(String code) {
        String suffix = "";

        if(!isValid(code)) {
            suffix = " ERR";
        }
        if(isReadable(code)) {
            suffix = " ILL";
        }

        return suffix;
    }

}
