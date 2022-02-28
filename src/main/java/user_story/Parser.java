package user_story;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Parser {
    HashMap<String, String> asciiToCodeMap = new HashMap<>();

    public Parser() {
        asciiToCodeMap.put(" _ | ||_|", "0");
        asciiToCodeMap.put("     |  |", "1");
        asciiToCodeMap.put(" _  _||_ ", "2");
        asciiToCodeMap.put(" _  _| _|", "3");
        asciiToCodeMap.put(" _ | ||_|", "4");
        asciiToCodeMap.put(" _ |_  _|", "5");
        asciiToCodeMap.put(" _ |_ |_|", "6");
        asciiToCodeMap.put(" _   |  |", "7");
        asciiToCodeMap.put(" _ |_||_|", "8");
        asciiToCodeMap.put(" _ |_| _|", "9");

    }

    public String getCodeOfAscii(String ascii) {
        return asciiToCodeMap.get(ascii);
    }

    public List<Code> asciiToCodes(List<Entry> entries) {
        List<Code> codes = new ArrayList<Code>();
        List<String> asciiStrings = new ArrayList<String>();
        for(Entry entry : entries) {
            List<String> asciiNumbers = entryToAscii(entry);
            String codeValues = "";
            String codeValue = "";
            String asciiOf = "";
            for (int i = 0; i < asciiNumbers.size(); i += 3) {
                asciiOf += asciiNumbers.get(i);
                asciiOf += asciiNumbers.get(i + 1);
                asciiOf += asciiNumbers.get(i + 2);
                codeValue += getCodeOfAscii(asciiOf);
                if (!(codeValue == null)) {
                    codeValues += codeValue;
                    codeValue = "";
                    asciiOf = "";
                }
            }
            asciiStrings.add(codeValues);
        }
        for(String asciiString : asciiStrings) {
            Code newCode = new Code(asciiString);
            codes.add(newCode);
        }

        return codes;
    }

    public List<String> entryToAscii(Entry entry) {
        List<String> asciiNumbers = new ArrayList<String>();
        String element = "";
        for (String line : entry.lines) {
            if (line != "") {
                asciiNumbers.add(0,line.substring(0,3));
                asciiNumbers.add(1,line.substring(3,6));
                asciiNumbers.add(2,line.substring(6,9));
                asciiNumbers.add(3,line.substring(9,12));
                asciiNumbers.add(4,line.substring(12,15));
                asciiNumbers.add(5,line.substring(15,18));
                asciiNumbers.add(6,line.substring(18,21));
                asciiNumbers.add(7,line.substring(21,24));
                asciiNumbers.add(8,line.substring(24,27));
            }
        }
        System.out.println(asciiNumbers);
        return asciiNumbers;
    }
}